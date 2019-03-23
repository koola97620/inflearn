package com.example.demowebmvc;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItems;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.head;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.options;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.handler;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


/**
 * @author choijaeyong on 22/03/2019.
 * @project demo-web-mvc
 * @description
 */

@RunWith(SpringRunner.class)
@WebMvcTest
public class SampleControllerTest {

  @Autowired
  MockMvc mockMvc;

  @Test
  public void helloTest() throws Exception{
    mockMvc.perform(get("/hello")
//         .header(HttpHeaders.AUTHORIZATION,"abc")
//        .accept(MediaType.APPLICATION_JSON)
        )
        .andDo(print())
        .andExpect(status().isOk());
//        .andExpect(header().stringValues(HttpHeaders.ALLOW ,
//            hasItems(containsString("GET"),
//                containsString("POST"),
//                containsString("HEAD"),
//                containsString("OPTIONS")) ));

//        .andExpect(content().string("hello"))
//        .andExpect(handler().handlerType(SampleController.class))
//        .andExpect(handler().methodName("hello"))


  }

  @Test
  public void 연습문제풀기1() throws Exception{
    mockMvc.perform(get("/events"))
        .andDo(print())
        .andExpect(status().isOk());
//        .andExpect(content().string("events"));
  }

  @Test
  public void 연습문제풀기2() throws Exception{
    mockMvc.perform(get("/events/1"))
        .andExpect(status().isOk());
    mockMvc.perform(get("/events/2"))
        .andExpect(status().isOk());
    mockMvc.perform(get("/events/3 "))
        .andExpect(status().isOk());
  }

  @Test
  public void 연습문제풀기3() throws Exception {
    mockMvc.perform(post("/events")
      .contentType(MediaType.APPLICATION_JSON)
      .accept(MediaType.APPLICATION_JSON))
      .andExpect(status().isOk());
  }



}