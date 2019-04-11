package com.example.demowebmvc;

import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * @author choijaeyong on 09/04/2019.
 * @project demo-web-mvc
 * @description
 */

@ControllerAdvice(assignableTypes = {SampleController.class, EventAPI.class})
public class BaseController {

  @ExceptionHandler({EventException.class, RuntimeException.class})
  public String eventErrorHandler(EventException exception, Model model) {
    model.addAttribute("message" , "event error");
    return "error";

  }


  @InitBinder
  public void initEvent(WebDataBinder webDataBinder) {
    webDataBinder.setDisallowedFields("id");
    webDataBinder.addValidators(new EventValidator());
  }


  //  @ModelAttribute
//  public void categories(Model model) {
//    model.addAttribute("categories",List.of("study","seminar","hobby"));
//  }

  @ModelAttribute("categories")
  public List<String> categoies(Model model) {
    return List.of("study","seminar");
  }


}
