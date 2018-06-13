package com.xhj.security.core.validate.code.sms;

/**
 * Created by 熊厚谨 on 2018/6/13 14:48
 *  默认的短信验证码实现（一般默认的大多用来被覆盖）
 * @author 熊厚谨
 */
public class DefaultSmsCodeSender implements SmsCodeSender {
    @Override
    public void send(String mobile, String code) {
        System.out.println("向手机" + mobile + "发送短信验证码" + code);
    }
}
