package com.xhj.security.core.properties;

import com.xhj.security.core.SecurityProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by 熊厚谨 on 2018/6/5 16:09
 *  使 SecurityProperties 这个配置类生效
 * @author 熊厚谨
 */

@Configuration
@EnableConfigurationProperties(SecurityProperties.class)
public class securityCoreConfig {
}
