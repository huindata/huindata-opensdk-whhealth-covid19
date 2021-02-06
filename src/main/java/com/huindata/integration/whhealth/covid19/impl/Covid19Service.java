package com.huindata.integration.whhealth.covid19.impl;

import cn.hutool.crypto.SmUtil;
import cn.hutool.crypto.symmetric.SymmetricCrypto;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.huindata.integration.whhealth.covid19.ICovid19Service;
import com.huindata.integration.whhealth.covid19.vo.AppConfig;
import com.huindata.integration.whhealth.covid19.vo.*;
import org.apache.http.Consts;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class Covid19Service implements ICovid19Service {
    private String uriLogin = "/auth";
    private String uriCYXX = "/hscy/api/yjss/importCYXXResult",
        uriJCJGQ = "/hscy/api/yjss/importJCJGQSResult",
        uriJCJG = "/hscy/api/yjss/importJCJGResult";
    private AppConfig appConfig;

    private ObjectMapper mapper = new ObjectMapper();

    SymmetricCrypto sm4;

    private LoginInfo token;

    private long exprAt;

    /**
     * 构造服务
     * @param apiRoot 核酸采样信息接口根地址
     * @param appCode
     * @param loginSign
     * @param  hs01Sign
     * @param  hs02Sign
     * @param  hs03Sign
     * @param appId 授信应用id
     * @param appSecret 授信应用密钥
     * @param sysCode 系统编号
     * @param loginName loginName
     * @param loginPwd loginPwd
     * @param key 过密sm4加密，密钥由平台分配
     */
    public Covid19Service(String apiRoot, String appCode, String loginSign,
                          String hs01Sign,
                          String hs02Sign,
                          String hs03Sign,
                          String appId, String appSecret, String sysCode, String loginName, String loginPwd, String key){
        this(new AppConfig(apiRoot,
                appCode,
                loginSign,
                hs01Sign,
                hs02Sign,
                hs03Sign,
                appId,
                appSecret,
                sysCode,
                loginName,
                loginPwd,
                key));
    }

    /**
     * 构造服务
     * @param appConfig 配置
     */
    public Covid19Service(AppConfig appConfig){
        this.appConfig = appConfig;
        sm4 = SmUtil.sm4(appConfig.getKey().getBytes());
        mapper.getSerializerProvider().setNullValueSerializer(new JsonSerializer(){
            @Override
            public void serialize(Object o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
                jsonGenerator.writeString("");
            }
        });
    }

    public Response importCYXXResult(CYXXRequestBody requestBody) {
        return createAndRequest(pathJoin(appConfig.getApiRoot(),uriCYXX),appConfig.getHs01Sign(),requestBody);
    }

    public Response importJCJGQSResult(JCJGQSRequestBody requestBody) {
        return createAndRequest(pathJoin(appConfig.getApiRoot(),uriJCJGQ),appConfig.getHs02Sign(),requestBody);
    }

    public Response importJCJGResult(JCJGRequestBody requestBody) {
        return createAndRequest(pathJoin(appConfig.getApiRoot(),uriJCJG),appConfig.getHs03Sign(),requestBody);
    }

    /**
     * 创建并完成请求
     * @param url
     * @param sign
     * @param requestBody
     * @return
     */
    private Response createAndRequest(String url,String sign,RequestBody requestBody){
        BusinessRequest request = new BusinessRequest<RequestBody>();
        request.setAppid(appConfig.getAppId());
        request.setAppSecret(appConfig.getAppSecret());
        request.setKey(appConfig.getKey());
        try {
            request.setToken(getToken().getToken());
        } catch (Exception e) {
            Response r = new Response();
            r.setResult("fail");
            r.setErrorCode("systemError");
            r.setMessage(e.getLocalizedMessage());
            return r;
        }


        request.setData(requestBody);
        return request(url,sign,request);
    }

    /**
     * 执行请求
     * @param url
     * @param sign
     * @param request
     * @return
     */
    private Response request(String url,String sign,BusinessRequest request){
        Response r = null;
        try {
            String jsonStr = mapper.writeValueAsString(request);
            try(CloseableHttpClient client = HttpClients.createDefault()){
                HttpPost post = new HttpPost(url);
                post.addHeader("appCode",appConfig.getAppCode());
                post.addHeader("sign",sign);
                post.setEntity(new StringEntity(jsonStr,ContentType.APPLICATION_JSON));
                try(CloseableHttpResponse response = client.execute(post)){
                    String respJson = EntityUtils.toString(response.getEntity(), Consts.UTF_8.name());
                    if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                        r = mapper.readValue(respJson,Response.class);
                    }else{
                        r = new Response();
                        r.setResult("faile");
                        r.setErrorCode("Connection Error!");
                        r.setMessage(respJson);
                    }
                }
            }

        } catch (IOException e) {
            r = new Response();
            r.setResult("fail");
            r.setErrorCode("systemError");
            r.setMessage(e.getLocalizedMessage());
        }

        return r;
    }

    /**
     * 获取token
     * @return
     * @throws IOException
     */
    private LoginInfo getToken() throws IOException {
        if(token == null || exprAt > System.currentTimeMillis()){
            synchronized (this){
                if(token == null || exprAt > System.currentTimeMillis()){
                    token = refreshToken();
                    exprAt = System.currentTimeMillis() + appConfig.getTokenExist();
                }
            }
        }

        return token;
    }

    /**
     * 请求token
     * @return
     */
    private LoginInfo refreshToken() throws IOException {
        PtInfo info = new PtInfo();
        info.setPtLoginName(appConfig.getLoginName());
        info.setPtPwd(appConfig.getLoginPwd());

        String data = sm4.encryptBase64(mapper.writeValueAsString(info));

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setData(data);
        loginRequest.setSysCode(appConfig.getSysCode());

        try(CloseableHttpClient client = HttpClients.createDefault();){
            HttpPost post = new HttpPost(pathJoin(appConfig.getApiRoot(),uriLogin));
            post.addHeader("appCode",appConfig.getAppCode());
            post.addHeader("sign",appConfig.getLoginSign());
            post.setEntity(new StringEntity(mapper.writeValueAsString(loginRequest),
                    ContentType.APPLICATION_JSON));

            try(CloseableHttpResponse response = client.execute(post);){
                String respJson = EntityUtils.toString(response.getEntity(), Consts.UTF_8.name());
                if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                    LoginResponse respObj = mapper.readValue(respJson,LoginResponse.class);
                    if("10000".equals(respObj.getRespCode())){
                        String loingInfoStr = sm4.decryptStr(respObj.getRespData());
                        return mapper.readValue(loingInfoStr,LoginInfo.class);
                    }else{
                        throw new IOException("Get Token Failed With Code[" + respObj.getRespCode()+"] and descripted as " + respObj.getRespDesc());
                    }
                }else{
                    throw new IOException("Get Token Failed:" + respJson);
                }
            }
        }
    }

    /**
     * 路径拼接，防止不和规范的路径配置
     * @param root
     * @param path
     * @return
     */
    private String pathJoin(String root,String path){
        return root.replaceAll("\\/*$","").concat("/").concat(path.replaceAll("^\\/*",""));
    }

    /**
     * 重设登陆地址
     * @param uriLogin
     */
    public void setUriLogin(String uriLogin) {
        this.uriLogin = uriLogin;
    }

    /**
     * 重设核酸采样信息应急实时上报接口地址
     * @param uriCYXX
     */
    public void setUriCYXX(String uriCYXX) {
        this.uriCYXX = uriCYXX;
    }

    /**
     * 重设核酸检测标本检测机构签收应急实时上报接口地址
     * @param uriJCJGQ
     */
    public void setUriJCJGQ(String uriJCJGQ) {
        this.uriJCJGQ = uriJCJGQ;
    }

    /**
     * 重设核酸检测标本检测机构签收应急实时上报接口地址
     * @param uriJCJG
     */
    public void setUriJCJG(String uriJCJG) {
        this.uriJCJG = uriJCJG;
    }
}
