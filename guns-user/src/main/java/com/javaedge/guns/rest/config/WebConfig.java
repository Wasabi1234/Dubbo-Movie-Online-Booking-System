package com.javaedge.guns.rest.config;

import com.javaedge.guns.rest.modular.auth.filter.AuthFilter;
import com.javaedge.guns.rest.modular.auth.security.DataSecurityAction;
import com.javaedge.guns.rest.modular.auth.security.impl.Base64SecurityAction;
import com.javaedge.guns.rest.config.properties.RestProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * web配置
 *
 * @author JavaEdge
 * @date 2017-08-23 15:48
 */
@Configuration
public class WebConfig {

    @Bean
    @ConditionalOnProperty(prefix = RestProperties.REST_PREFIX, name = "auth-open", havingValue = "true", matchIfMissing = true)
    public AuthFilter jwtAuthenticationTokenFilter() {
        return new AuthFilter();
    }

    @Bean
    public DataSecurityAction dataSecurityAction() {
        return new Base64SecurityAction();
    }
}
