package com.example.demowebmvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 * @author choijaeyong on 09/04/2019.
 * @project demo-web-mvc
 * @description
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class EventAPITest {

  @Autowired
  ObjectMapper objectMapper;

  @Autowired
  MockMvc mockMvc;

  @Test
  public void createEventTest() throws Exception {
    Event event = new Event();
    event.setLimit(20);
    event.setName("keesun");

    String json = objectMapper.writeValueAsString(event);

    mockMvc.perform(post("/api/events")
            .contentType(MediaType.APPLICATION_JSON_UTF8)
            .content(json)
            .accept(MediaType.APPLICATION_JSON_UTF8))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("name").value("keesun"))
            .andExpect(jsonPath("limit").value(20));

  }





}