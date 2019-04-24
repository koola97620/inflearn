package me.jdragon;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author choijaeyong on 24/04/2019.
 * @project jdragonspringbootstarter
 * @description
 */

@ConfigurationProperties("holoman")
public class HolomanProperties {

  private String name;
  private int howLong;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getHowLong() {
    return howLong;
  }

  public void setHowLong(int howLong) {
    this.howLong = howLong;
  }
}
