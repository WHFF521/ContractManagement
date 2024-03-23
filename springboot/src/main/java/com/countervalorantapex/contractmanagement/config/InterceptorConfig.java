package com.countervalorantapex.contractmanagement.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import org.springframework.context.annotation.Bean;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/sys/users/**", "/sys/users/register", "/swagger-ui.html", "/swagger-resources/**","/sys/file/**");
    }

    @Bean
    public myJwtInterceptor jwtInterceptor() {
        return new myJwtInterceptor();
    }

}
