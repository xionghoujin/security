package com.xhj.security.core.validate.code;

import com.xhj.security.core.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Created by 熊厚谨 on 2018/6/12 17:45
 *
 * @author 熊厚谨
 */
@Configuration
public class ValidateCodeBeanConfig {

    @Autowired
    private SecurityProperties securityProperties;

    @Bean
    //这个注解判断spring容器中已经有imageCodeGenerator这个bean，有的话就是用已存在的
    //通过这种方法可以在业务模块中进行自己的配置 在这里可以实现验证码生成的逻辑可配置
    @ConditionalOnMissingBean(name = "imageCodeGenerator")
    public ValidateCodeGenerator imageCodeGenertor() {
        ImageCodeGenerator codeGenerator = new ImageCodeGenerator();
        codeGenerator.setSecurityProperties(securityProperties);
        return codeGenerator;
    }
}
