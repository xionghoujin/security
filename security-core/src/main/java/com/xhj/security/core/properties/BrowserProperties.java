package com.xhj.security.core.properties;

/**
 * Created by 熊厚谨 on 2018/6/5 16:02
 *
 * @author 熊厚谨
 */
public class BrowserProperties {

    //设置默认值
    //登陆的页面
    private String loginPage = "/login.html";
    //返回的方式
    private LoginType loginType = LoginType.jSON;
    //记住我的过期时间
    private int rememberMeSecondes = 3600;


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

    public int getRememberMeSecondes() {
        return rememberMeSecondes;
    }

    public void setRememberMeSecondes(int rememberMeSecondes) {
        this.rememberMeSecondes = rememberMeSecondes;
    }
}
