package com.example.demowebmvc;

import javax.validation.Valid;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author choijaeyong on 09/04/2019.
 * @project demo-web-mvc
 * @description
 */


@RestController("/api/events")
public class EventAPI {

//  @PostMapping
//  public Event createEvent(HttpEntity<Event> request) {
//
//    // repository.save event 생략.
//
//    MediaType contentType = request.getHeaders().getContentType();
//    System.out.println(contentType);
//
//    return request.getBody();
//  }

//  @PostMapping
//  public Event createEvent(@RequestBody @Valid Event event, BindingResult bindingResult) {
//
//    // repository.save event 생략.
//    if(bindingResult.hasErrors()) {
//      bindingResult.getAllErrors().forEach(error ->
//          System.out.println(error));
//    }
//
//    return event;
//  }

  @PostMapping
  public ResponseEntity<Event> createEvent(@RequestBody @Valid Event event, BindingResult bindingResult) {

    // repository.save event 생략.
    if(bindingResult.hasErrors()) {
      return ResponseEntity.badRequest().build();
    }

    return ResponseEntity.ok(event);
  }

}
