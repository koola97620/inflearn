package me.jdragon;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author choijaeyong on 23/04/2019.
 * @project jdragonspringbootstarter
 * @description
 */

@Configuration
@EnableConfigurationProperties(HolomanProperties.class)
public class HoloManConfiguration {


  @Bean
  @ConditionalOnMissingBean
  public HoloMan holoMan(HolomanProperties properties) {
    HoloMan holoMan = new HoloMan();
    holoMan.setHowLong(properties.getHowLong());
    holoMan.setName(properties.getName());

    return holoMan;
  }

}
