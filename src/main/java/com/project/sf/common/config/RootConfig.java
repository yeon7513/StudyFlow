package com.project.sf.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class RootConfig implements WebMvcConfigurer {

  @Autowired
  HandlerInterceptor adminInterceptor; // 이 인터셉터는 최고 관리자용

  @Override
  public void addInterceptors(InterceptorRegistry registry) {

    // 이 권한 체크 인터셉터가 작동할 URL을 명시적으로 지정
    registry.addInterceptor(adminInterceptor).addPathPatterns("/admins/**");
  }

}
