package com.xhj.security.core.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by 熊厚谨 on 2018/6/5 16:02
 *
 * @author 熊厚谨
 */
@ConfigurationProperties(prefix = "xhj.security")
public class SecurityProperties {

    private BrowserProperties browser = new BrowserProperties();

    /**
     * 验证码配置
     */
    private ValidateCodeProperties code = new ValidateCodeProperties();

    public BrowserProperties getBrowser() {
        return browser;
    }

    public SecurityProperties setBrowser(BrowserProperties browser) {
        this.browser = browser;
        return this;
    }

    public ValidateCodeProperties getCode() {
        return code;
    }

    public SecurityProperties setCode(ValidateCodeProperties code) {
        this.code = code;
        return this;
    }
}
