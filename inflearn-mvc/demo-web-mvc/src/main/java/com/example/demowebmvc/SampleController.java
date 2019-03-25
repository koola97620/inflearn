package com.example.demowebmvc;

import java.util.Map;
import java.util.Optional;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author choijaeyong on 22/03/2019.
 * @project demo-web-mvc
 * @description
 */

@Controller
public class SampleController {

  //@RequestMapping(value = "/hello", method = RequestMethod.GET)
//  @GetHelloMapping
//  @ResponseBody
//  public String hello() {
//    return "hello";
//  }

//  @PostMapping(value="/hello")
//  @ResponseBody
//  public String helloPost() {
//    return "hello";
//  }

//  @RequestMapping("/**")
//  @ResponseBody
//  public String hello() {
//    return "hello";
//  }

//  @GetMapping("/events")
//  @ResponseBody
//  public String events() {
//    return "events";
//  }
//
//  @GetMapping("/events/{id}")
//  public String getEvents(@PathVariable int id) {
//    return "event";
//  }
//
//  @PostMapping(value = "/events" , consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//  @ResponseBody
//  public String postEvents() {
//    return "events";
//  }


  // 39. 핸들러 메소드 2부.
  @GetMapping("/events/{id}")
  @ResponseBody
  public Event getEvent(@PathVariable("id") Integer idValue, @MatrixVariable String name) {
    Event event = new Event();
    event.setId(idValue);
    event.setName(name);
    return event;
  }

  @PostMapping("/events")
  @ResponseBody
  public Event postEvent2(@RequestParam Map<String,String> params , @RequestParam Integer limit) {
    Event event = new Event();
    event.setName(params.get("name"));
    event.setLimit(limit);
    return event;
  }

  @GetMapping("/events/form")
  public String eventForm(Model model) {
    Event newEvent = new Event();
    newEvent.setLimit(50);
    model.addAttribute("event", newEvent);
    return "events/form";
  }


}
