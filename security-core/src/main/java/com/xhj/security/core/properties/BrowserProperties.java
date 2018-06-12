package com.xhj.security.core.properties;

/**
 * Created by 熊厚谨 on 2018/6/5 16:02
 *
 * @author 熊厚谨
 */
public class BrowserProperties {

    //设置默认值
    private String loginPage = "/login.html";

    private LoginType loginType = LoginType.jSON;

    public LoginType getLoginType() {
        return loginType;
    }

    public BrowserProperties setLoginType(LoginType loginType) {
        this.loginType = loginType;
        return this;
    }

    public String getLoginPage() {
        return loginPage;
    }

    public BrowserProperties setLoginPage(String loginPage) {
        this.loginPage = loginPage;
        return this;
    }
}
