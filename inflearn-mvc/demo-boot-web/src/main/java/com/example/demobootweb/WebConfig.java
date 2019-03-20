package com.example.demobootweb;

import java.util.concurrent.TimeUnit;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.CacheControl;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author choijaeyong on 19/03/2019.
 * @project demo-boot-web
 * @description
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

//  @Override
//  public void addFormatters(FormatterRegistry registry) {
//    registry.addFormatter(new PersonFormatter());
//  }


  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(new GreetingInterceptor()).order(0);
    registry.addInterceptor(new AnotherInterceptor())
        .addPathPatterns("/hi")
        .order(-1);
  }

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/mobile/**")
        .addResourceLocations("classpath:/mobile/")
        .resourceChain(true);
//        .setCacheControl(CacheControl.maxAge(10, dTimeUnit.MINUTES));
  }
}
