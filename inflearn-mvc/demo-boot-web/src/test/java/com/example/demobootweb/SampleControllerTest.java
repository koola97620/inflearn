package com.example.demobootweb;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import javax.annotation.Resource;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 * @author choijaeyong on 18/03/2019.
 * @project demo-boot-web
 * @description
 * 포매터 설명부분.
 */

@RunWith(SpringRunner.class)
//@WebMvcTest
@SpringBootTest
@AutoConfigureMockMvc
public class SampleControllerTest {

  @Autowired
  MockMvc mockMvc;

  @Autowired
  PersonRepository personRepository;

  @Autowired
  ObjectMapper objectMapper;



//  @Test   //pathvariable 테스트
//  public void hello() throws Exception {
//    this.mockMvc.perform(get("/hello/keesun"))
//        .andDo(print())
//        .andExpect(content().string("hello keesun"));
//  }
  @Test
  public void hello() throws Exception {
    Person person = new Person();
    person.setName("keesun");
    Person savedPerson = personRepository.save(person);

    this.mockMvc.perform(get("/hello").param("id",savedPerson.getId().toString()))
        .andDo(print())
        .andExpect(content().string("hello keesun"));
  }


  @Test
  public void helloStatic() throws Exception {
    this.mockMvc.perform(get("/index.html"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string(Matchers.containsString("hello index")));
  }

  @Test
  public void helloMobile() throws Exception {
    this.mockMvc.perform(get("/mobile/index.html"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string(Matchers.containsString("hello mobile")));
//        .andExpect(header().exists(HttpHeaders.CACHE_CONTROL));
  }

  @Test
  public void stringMessage() throws Exception {
    this.mockMvc.perform(get("/message")
      .content("hello"))
      .andDo(print())
      .andExpect(status().isOk())
      .andExpect(content().string("hello"));
  }

  @Test
  public void jsonMessage() throws Exception {

    Person person = new Person();
    person.setId(2019l);
    person.setName("keesun");

    String jsonString = objectMapper.writeValueAsString(person);

    this.mockMvc.perform(get("/jsonMessage")
        .contentType(MediaType.APPLICATION_JSON_UTF8)
        .accept(MediaType.APPLICATION_JSON_UTF8)
        .content(jsonString))
        .andDo(print())
        .andExpect(status().isOk());
  }


}