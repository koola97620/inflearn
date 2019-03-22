package com.example.demowebmvc;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author choijaeyong on 22/03/2019.
 * @project demo-web-mvc
 * @description
 */

@Controller
public class SampleController {

  //@RequestMapping(value = "/hello", method = RequestMethod.GET)
  @RequestMapping(value="/hello" ,
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.TEXT_PLAIN_VALUE)
  @ResponseBody
  public String hello() {
    return "hello";
  }

//  @RequestMapping("/**")
//  @ResponseBody
//  public String hello() {
//    return "hello";
//  }


}
