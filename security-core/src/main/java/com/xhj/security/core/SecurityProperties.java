package com.xhj.security.core;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by 熊厚谨 on 2018/6/5 16:02
 *
 * @author 熊厚谨
 */
@ConfigurationProperties(prefix = "xhj.security")
public class SecurityProperties {

    private BrowserProperties browser = new BrowserProperties();

    public BrowserProperties getBrowser() {
        return browser;
    }

    public SecurityProperties setBrowser(BrowserProperties browser) {
        this.browser = browser;
        return this;
    }
}
