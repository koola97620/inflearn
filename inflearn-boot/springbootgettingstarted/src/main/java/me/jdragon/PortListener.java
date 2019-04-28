package me.jdragon;

import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.boot.web.servlet.context.ServletWebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author choijaeyong on 25/04/2019.
 * @project springbootgettingstarted
 * @description
 */

@Component
public class PortListener implements ApplicationListener<ServletWebServerInitializedEvent> {

  @Override
  public void onApplicationEvent(
      ServletWebServerInitializedEvent servletWebServerInitializedEvent) {

    ServletWebServerApplicationContext applicationContext = servletWebServerInitializedEvent.getApplicationContext();
    int port = applicationContext.getWebServer().getPort();
    System.out.println(port);

  }
}
