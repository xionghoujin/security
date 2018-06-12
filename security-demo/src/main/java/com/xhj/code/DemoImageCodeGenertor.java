package com.xhj.code;

import com.xhj.security.core.validate.code.ImageCode;
import com.xhj.security.core.validate.code.ValidateCodeGenerator;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * Created by 熊厚谨 on 2018/6/12 17:58
 *
 * @author 熊厚谨
 */
//@Component("imageCodeGenerator")
public class DemoImageCodeGenertor implements ValidateCodeGenerator {

    //通过这种方式实现验证码的生成逻辑可以配置
    @Override
    public ImageCode createCode(ServletWebRequest request) {
        System.out.println("更高级的图形验证码生成代码");
        return null;
    }
}
