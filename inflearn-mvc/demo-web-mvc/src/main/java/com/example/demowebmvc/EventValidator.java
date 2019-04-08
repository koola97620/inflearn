package com.example.demowebmvc;


import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * @author choijaeyong on 10/04/2019.
 * @project demo-web-mvc
 * @description
 */
public class EventValidator implements Validator {

  @Override
  public boolean supports(Class<?> clazz) {
    return Event.class.isAssignableFrom(clazz);
  }

  @Override
  public void validate(Object o, Errors errors) {
    Event event = (Event)o;
    if(event.getName().equals("aaa")) {
      errors.rejectValue("name","wrongValue","the value is not allowed.");

    }


  }
}
