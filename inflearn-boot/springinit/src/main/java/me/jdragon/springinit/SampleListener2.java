package me.jdragon.springinit;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author choijaeyong on 28/04/2019.
 * @project springinit
 * @description
 */

@Component
public class SampleListener2 implements ApplicationListener<ApplicationStartedEvent> {

  @Override
  public void onApplicationEvent(ApplicationStartedEvent applicationStartedEvent) {
    System.out.println("========================");
    System.out.println("Started");
    System.out.println("========================");
  }
}
