package com.huindata.integration.whhealth.covid19.vo;

public class LoginInfo {
    private String token;
    private LoginUser user;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LoginUser getUser() {
        return user;
    }

    public void setUser(LoginUser user) {
        this.user = user;
    }
}
