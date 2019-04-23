package me.jdragon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author choijaeyong on 17/04/2019.
 * @project springbootgettingstarted
 * @description
 */

@SpringBootApplication
public class Application {

  public static void main(String[] args) {

//    SpringApplication application = new SpringApplication(Application.class);
//   application.setWebApplicationType(WebApplicationType.SERVLET);
//    application.run(args);
    SpringApplication.run(Application.class,args);
  }

  @Bean
  public HoloMan holoMan() {
    HoloMan holoMan = new HoloMan();
    holoMan.setName("jd");
    holoMan.setHowLong(60);
    return holoMan;
  }

}
