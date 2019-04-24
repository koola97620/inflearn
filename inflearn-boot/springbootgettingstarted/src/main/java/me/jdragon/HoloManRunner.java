package me.jdragon;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @author choijaeyong on 23/04/2019.
 * @project springbootgettingstarted
 * @description
 */
@Log
@Component
public class HoloManRunner implements ApplicationRunner {

  @Autowired
  HoloMan holoMan;

  public void ss() {
    log.info("--");
  }

  @Override
  public void run(ApplicationArguments args) throws Exception {
    System.out.println(holoMan);
  }
}
