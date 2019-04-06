package com.example.demowebmvc;

import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Map;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.servlet.ModelAndView;


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

  @Test
  public void 핸들러메소드2부() throws Exception {
    mockMvc.perform(get("/events/1;name=keesun"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("id").value(1));
  }

  @Test
  public void postTest() throws Exception {
    mockMvc.perform(post("/events2")
        .param("name","keesun")
        .param("limit","20"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("name").value("keesun"));
  }

  @Test
  public void eventForm() throws Exception {
    MockHttpServletRequest request = mockMvc.perform(get("/events/form"))
        .andDo(print())
        .andExpect(view().name("events/form"))
        .andExpect(model().attributeExists("event"))
        .andExpect(request().sessionAttribute("event",notNullValue()))
        .andReturn().getRequest();

    Object event = request.getSession().getAttribute("event");
    System.out.println(event);

  }

  @Test
  public void postTest2() throws Exception {
    ResultActions resultActions = mockMvc.perform(post("/events")
        .param("name","keesun")
        .param("limit","-10"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(model().hasErrors());

    ModelAndView modelAndView = resultActions.andReturn().getModelAndView();
    Map<String,Object> map = modelAndView.getModel();
    System.out.println(map.size());
  }



}