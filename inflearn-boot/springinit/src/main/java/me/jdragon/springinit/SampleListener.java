package me.jdragon.springinit;

import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author choijaeyong on 28/04/2019.
 * @project springinit
 * @description
 */

@Component
public class SampleListener implements ApplicationListener<ApplicationStartingEvent> {

  @Override
  public void onApplicationEvent(ApplicationStartingEvent applicationStartingEvent) {
    System.out.println("========================");
    System.out.println("application is starting");
    System.out.println("========================");
  }
}
