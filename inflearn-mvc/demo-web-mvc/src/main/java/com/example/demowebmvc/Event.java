package com.example.demowebmvc;

import java.time.LocalDate;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

/**
 * @author choijaeyong on 25/03/2019.
 * @project demo-web-mvc
 * @description
 */
public class Event {

//  interface ValidateLimit{}
//  interface ValidateName{}

  private Integer id;

//  @NotBlank(groups = ValidateName.class)
  @NotBlank
  private String name;

  @DateTimeFormat(iso = ISO.DATE)
  private LocalDate startDate;

  //@Min(value = 0,groups = ValidateLimit.class)
  @Min(0)
  private Integer limit;

  public Integer getLimit() {
    return limit;
  }

  public void setLimit(Integer limit) {
    this.limit = limit;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public LocalDate getStartDate() {
    return startDate;
  }

  public void setStartDate(LocalDate startDate) {
    this.startDate = startDate;
  }
}
