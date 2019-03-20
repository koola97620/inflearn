package com.example.demobootweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author choijaeyong on 18/03/2019.
 * @project demo-boot-web
 * @description
 * 포매터 설명부분.
 */

@RestController
public class SampleController {
//  @Bean
//  public PersonFormatter personFormatter() {
//    return new PersonFormatter();
//  }

//  @GetMapping("/hello/{name}") // name 이란 문자열을 Person 으로 어떻게 변환해야할까?
//  public String hello(@PathVariable("name") Person person) {
//    return "hello " + person.getName();
//  }

  // prehandle1
  // prehandle2
  // 요청처리
  // posthandle2
  // posthandle1
  // 뷰렌더링
  // afterCompletion2
  // afterCompletion1

  @GetMapping("/hello") // name 이란 문자열을 Person 으로 어떻게 변환해야할까?
  public String hello(@RequestParam("id") Person person) {
    return "hello " + person.getName();
  }

  @GetMapping("/message")
  @ResponseBody
  public String message(@RequestBody String body) {
    return body;
  }

  @GetMapping("/jsonMessage")
  public Person jsonMessage(@RequestBody Person person) {
    return person;
  }



}
