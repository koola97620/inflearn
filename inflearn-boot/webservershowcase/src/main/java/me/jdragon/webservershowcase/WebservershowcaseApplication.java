package me.jdragon.webservershowcase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class WebservershowcaseApplication {

  @GetMapping("/hello")
  public String hello() {
    return "hello spring";
  }

  public static void main(String[] args) {
    SpringApplication.run(WebservershowcaseApplication.class, args);
  }

//  @Bean
//  public ServletWebServerFactory serverFactory() {
//    TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
//    tomcat.addAdditionalTomcatConnectors(createStandardConnector());
//    return tomcat;
//  }
//
//  private Connector createStandardConnector() {
//    Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
//    connector.setPort(8080);
//    return connector;
//  }


}
