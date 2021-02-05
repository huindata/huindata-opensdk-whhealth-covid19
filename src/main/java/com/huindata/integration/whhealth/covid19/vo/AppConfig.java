package com.huindata.integration.whhealth.covid19.vo;

public class AppConfig {
    String apiRoot;

    private String appCode;

    private String loginSign;

    private String hs01Sign;

    private String hs02Sign;

    private String hs03Sign;
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

    public AppConfig(String apiRoot,String appCode,String loginSign,
                     String hs01Sign,
                     String hs02Sign,
                     String hs03Sign,
                     String appId, String appSecret, String sysCode, String loginName, String loginPwd, String key) {
        this.apiRoot = apiRoot;
        this.appCode = appCode;
        this.loginSign = loginSign;
        this.hs01Sign = hs01Sign;
        this.hs02Sign = hs02Sign;
        this.hs03Sign = hs03Sign;
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
    private long tokenExist = 1000 * 60 * 500; //默认半小时

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

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public String getLoginSign() {
        return loginSign;
    }

    public void setLoginSign(String loginSign) {
        this.loginSign = loginSign;
    }

    public String getHs01Sign() {
        return hs01Sign;
    }

    public void setHs01Sign(String hs01Sign) {
        this.hs01Sign = hs01Sign;
    }

    public String getHs02Sign() {
        return hs02Sign;
    }

    public void setHs02Sign(String hs02Sign) {
        this.hs02Sign = hs02Sign;
    }

    public String getHs03Sign() {
        return hs03Sign;
    }

    public void setHs03Sign(String hs03Sign) {
        this.hs03Sign = hs03Sign;
    }
}
