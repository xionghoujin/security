package com.xhj.security.core.validate.code;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

/**
 * Created by 熊厚谨 on 2018/6/11 18:01
 *
 * @author 熊厚谨
 */
public class ValidateCodeException extends AuthenticationException {



    public ValidateCodeException(String msg, Throwable t) {
        super(msg, t);
    }

    public ValidateCodeException(String msg) {
        super(msg);
    }
}
