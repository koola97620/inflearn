package com.example.demobootweb;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author choijaeyong on 19/03/2019.
 * @project demo-boot-web
 * @description
 */

@Entity
public class Person {

  @Id @GeneratedValue
  private Long id;

  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
