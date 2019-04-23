package me.jdragon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @author choijaeyong on 23/04/2019.
 * @project springbootgettingstarted
 * @description
 */

@Component
public class HoloManRunner implements ApplicationRunner {

  @Autowired
  HoloMan holoMan;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    System.out.println(holoMan);
  }
}
