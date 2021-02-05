package com.huindata.integration.whhealth.covid19.test;

import com.huindata.integration.whhealth.covid19.ICovid19Service;
import com.huindata.integration.whhealth.covid19.impl.Covid19Service;
import com.huindata.integration.whhealth.covid19.vo.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Covid19Tests {

    private static ICovid19Service covid19Service;

    private static ICovid19Service getCovid19Service(){
        if(covid19Service == null){
            AppConfig config = new AppConfig();
            config.setApiRoot("http://esb.whhealth.org.cn:8903/"); //武汉核酸检测平台
            config.setAppId("f627656ee2ac4c11911b6bb725ba72b4");  //授信应用id
            config.setAppSecret("54035da9e4594befbdf9abb85aedf9fa"); //授信应用密钥
            config.setSysCode("sshscjxt"); //系统编号
            config.setLoginName("sshscjxt"); //平台登录账号
            config.setLoginPwd("123456"); //平台密码
            config.setKey("NG7P3TCTHINLHNUS"); //过密sm4加密，密钥由平台分配

            config.setAppCode("VorYtU");
            config.setLoginSign("6CE25779DCC90362577B771CEEFDD8E4");
            config.setHs01Sign("3C5633652F6DEB2533D30E5CEBF525ED");
            config.setHs02Sign("3C2934882A4F5C8C87624BE64C7D3A2C");
            config.setHs03Sign("7A92327B73A0AB3B9CCFA067C242C657");

            covid19Service = new Covid19Service(config);
        }
        return covid19Service;
    }

    @Test
    public void importCYXXResult(){
        CYXXRequestBody requestBody = new CYXXRequestBody();
        //TODO : 数据设置
        Response r = getCovid19Service().importCYXXResult(requestBody);

        assertEquals("unvalidFieldData",r.getErrorCode());
    }

    @Test
    public void importJCJGQSResult(){
        JCJGQSRequestBody requestBody = new JCJGQSRequestBody();
        //TODO : 数据设置
        Response r = getCovid19Service().importJCJGQSResult(requestBody);

        assertEquals("unvalidFieldData",r.getErrorCode());
    }

    @Test
    public void importJCJGResult(){
        JCJGRequestBody requestBody = new JCJGRequestBody();
        //TODO : 数据设置
        Response r = getCovid19Service().importJCJGResult(requestBody);

        assertEquals("unvalidFieldData",r.getErrorCode());
    }
}
