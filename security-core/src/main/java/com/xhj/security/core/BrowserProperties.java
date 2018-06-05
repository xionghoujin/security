package com.xhj.security.core;

/**
 * Created by 熊厚谨 on 2018/6/5 16:02
 *
 * @author 熊厚谨
 */
public class BrowserProperties {

    private String loginPage = "/login.html";

    public String getLoginPage() {
        return loginPage;
    }

    public BrowserProperties setLoginPage(String loginPage) {
        this.loginPage = loginPage;
        return this;
    }
}
