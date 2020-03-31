package com.xiaoci.im.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册 base 拦截器
        registry.addInterceptor(baseIntercept())
                .addPathPatterns("/**");
        // 注册 auth 拦截器
        registry.addInterceptor(authenticationIntercept())
                .addPathPatterns("/**");
    }

    @Bean
    public AuthInterceptor authenticationIntercept() {
        return new AuthInterceptor();
    }

    @Bean
    public BaseInterceptor baseIntercept() {
        return new BaseInterceptor();
    }
}
