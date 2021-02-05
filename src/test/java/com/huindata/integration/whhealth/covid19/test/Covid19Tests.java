package com.huindata.integration.whhealth.covid19.test;

import com.huindata.integration.whhealth.covid19.ICovid19Service;
import com.huindata.integration.whhealth.covid19.impl.Covid19Service;
import com.huindata.integration.whhealth.covid19.vo.AppConfig;
import com.huindata.integration.whhealth.covid19.vo.CYXXRequestBody;
import com.huindata.integration.whhealth.covid19.vo.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Covid19Tests {

    @Test
    public void importCYXXResult(){
        AppConfig config = new AppConfig();
        config.setApiRoot("http://localhost:9080/"); //武汉核酸检测平台
        config.setAppId("5rc6t7vyb8u9nimpo");  //授信应用id
        config.setAppSecret("q3zw4xe5cr68vt79by80un9ie5r6ctv7yb8uio"); //授信应用密钥
        config.setSysCode("ECARD"); //系统编号
        config.setLoginName("ECARD_zhangsan"); //平台登录账号
        config.setLoginPwd("123456"); //平台密码
        config.setKey("NG7P3TCTHINLHNUS"); //过密sm4加密，密钥由平台分配

        ICovid19Service service = new Covid19Service(config);
        ((Covid19Service) service).setUriLogin("/api/login");

        CYXXRequestBody requestBody = new CYXXRequestBody();
        //TODO : 数据设置
        Response r = service.importCYXXResult(requestBody);

        assertEquals("fail",r.getResult());
    }
}
