package com.example.demowebmvc;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author choijaeyong on 22/03/2019.
 * @project demo-web-mvc
 * @description
 */

@Controller
@SessionAttributes("event")
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

//  @PostMapping("/events")
//  @ResponseBody
//  public Event postEvent2(@RequestParam Map<String,String> params , @RequestParam Integer limit) {
//    Event event = new Event();
//    event.setName(params.get("name"));
//    event.setLimit(limit);
//    return event;
//  }

  @GetMapping("/events/form/name")
  public String eventFormName(Model model, HttpSession httpSession) {
    model.addAttribute("event", new Event());
    //httpSession.setAttribute("event", newEvent); @SessionAttributes("event")해주면 이 코드가 없어도 알아서 세션에 넣어줌.
    return "events/form-name";
  }

    @PostMapping("/events/form/name")
    public String postEventName(@Validated @ModelAttribute Event event,
        BindingResult bindingResult) {
      if(bindingResult.hasErrors()) {
//        System.out.println("=====================");
//        bindingResult.getAllErrors().forEach(c -> {
//              System.out.println(c.toString());
//            });
//        sessionStatus.setComplete();
        return "/events/form/limit";
      }

//      List<Event> eventList = new ArrayList<>();
//      eventList.add(event);
//      model.addAttribute("events", eventList);

      return "redirect:/events/list";
    }


  @GetMapping("/events/form/limit")
  public String eventFormLimit(@ModelAttribute Event event, Model model) {
    model.addAttribute("event", event);
    //httpSession.setAttribute("event", newEvent); @SessionAttributes("event")해주면 이 코드가 없어도 알아서 세션에 넣어줌.
    return "events/form-limit";
  }

  @PostMapping("/events/form/limit")
  public String postEventLimit(@Validated @ModelAttribute Event event,
      BindingResult bindingResult,SessionStatus sessionStatus, RedirectAttributes redirectAttributes) {
    if (bindingResult.hasErrors()) {
//        System.out.println("=====================");
//        bindingResult.getAllErrors().forEach(c -> {
//              System.out.println(c.toString());
//            });
      return "/events/form/limit";
    }
    sessionStatus.setComplete();
    //redirectAttributes.addAttribute("name",event.getName());
    redirectAttributes.addFlashAttribute("newEvent", event);
    return "redirect:/events/list";

  }


  @GetMapping("/events/list")
  public String getList(//@ModelAttribute("newEvent") Event newEvent,
      Model model, @SessionAttribute("visitTime") LocalDateTime visitTime) {
    System.out.println(visitTime);
    Event event = new Event();
    event.setName("spring");
    event.setLimit(10);

    Event newEvent = (Event)model.asMap().get("newEvent");

    List<Event> eventList = new ArrayList<>();
    eventList.add(event);

    model.addAttribute("events", eventList);

    return "events/list";
  }




}
