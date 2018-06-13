package com.xhj.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * Created by 熊厚谨 on 2018/6/12 17:39
 *
 * @author 熊厚谨
 */
public interface ValidateCodeGenerator {
    ValidateCode generate(ServletWebRequest request);
}
