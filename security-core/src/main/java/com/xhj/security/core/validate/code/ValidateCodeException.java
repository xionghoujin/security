package com.xhj.security.core.validate.code;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

/**
 * Created by 熊厚谨 on 2018/6/11 18:01
 *
 * @author 熊厚谨
 */
public class ValidateCodeException extends AuthenticationException {



    private static final long serialVersionUID = -7285211528095468156L;

    public ValidateCodeException(String msg) {
        super(msg);
    }
}
