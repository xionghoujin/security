package com.xhj.sercurity.browser.support;

/**
 * Created by 熊厚谨 on 2018/6/5 15:52
 *
 * @author 熊厚谨
 *   自定义的 BrowserSecurityController 的 requireAuthentication方法的返回信息

 */
public class SimpleResponse {

    private Object content;

    public SimpleResponse(Object content) {
        this.content = content;
    }

    public Object getContent() {
        return content;
    }

    public SimpleResponse setContent(Object content) {
        this.content = content;
        return this;
    }
}
