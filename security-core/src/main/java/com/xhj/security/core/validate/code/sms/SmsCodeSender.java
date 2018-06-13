package com.xhj.security.core.validate.code.sms;

/**
 * Created by 熊厚谨 on 2018/6/13 14:47
 *
 * @author 熊厚谨
 */
public interface SmsCodeSender {

    void send(String mobile, String code);
}
