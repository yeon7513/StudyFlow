package com.project.sf.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import com.project.sf.common.interceptor.AdminInterceptor;

@Configuration
public class InterceptorConfig {

  @Bean
  HandlerInterceptor adminInterceptor() {
    return new AdminInterceptor();
  }

}
