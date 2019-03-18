package com.example.demobootweb;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.format.FormatterRegistry;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
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
}
