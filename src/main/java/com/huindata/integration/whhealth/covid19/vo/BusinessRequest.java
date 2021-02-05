package com.huindata.integration.whhealth.covid19.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BusinessRequest<T extends RequestBody> {

    private String appid;

    @JsonProperty("app_secret")
    private String appSecret;

    private String token;

    private T data;

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
