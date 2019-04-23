package me.jdragon;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author choijaeyong on 23/04/2019.
 * @project jdragonspringbootstarter
 * @description
 */

@Configuration
public class HoloManConfiguration {
  @Bean
  public HoloMan holoMan() {
    HoloMan holoMan = new HoloMan();
    holoMan.setHowLong(5);
    holoMan.setName("keesun");

    return holoMan;
  }

}
