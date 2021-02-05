package com.huindata.integration.whhealth.covid19.vo;

public class AppConfig {
    String apiRoot;
    /**
     * 授信应用id
     * 系统会为每个对接机构生成一个appid和与之对应的app_secret，请妥善保管。
     */
    private String appId;

    /**
     * 授信应用密钥
     */
    private String appSecret;

    /**
     * 系统编号
     */
    private String sysCode;

    /**
     * 平台登录账号
     */
    private String loginName;

    /**
     * 平台密码
     */
    private String loginPwd;

    /**
     * 过密sm4加密，密钥由平台分配
     */
    private String key;

    public AppConfig() {
    }

    public AppConfig(String apiRoot,String appId, String appSecret, String sysCode, String loginName, String loginPwd, String key) {
        this.apiRoot = apiRoot;
        this.appId = appId;
        this.appSecret = appSecret;
        this.sysCode = sysCode;
        this.loginName = loginName;
        this.loginPwd = loginPwd;
        this.key = key;
    }

    /**
     * token成功请求到后的过期时间
     */
    private long tokenExist = 1000 * 60 * 30; //默认半小时

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getSysCode() {
        return sysCode;
    }

    public void setSysCode(String sysCode) {
        this.sysCode = sysCode;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public long getTokenExist() {
        return tokenExist;
    }

    public void setTokenExist(long tokenExist) {
        this.tokenExist = tokenExist;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getApiRoot() {
        return apiRoot;
    }

    public void setApiRoot(String apiRoot) {
        this.apiRoot = apiRoot;
    }
}
