package com.example.demobootweb;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 * @author choijaeyong on 18/03/2019.
 * @project demo-boot-web
 * @description
 * 포매터 설명부분.
 */

@RunWith(SpringRunner.class)
@WebMvcTest
//@SpringBootTest
//@AutoConfigureMockMvc
public class SampleControllerTest {

  @Autowired
  MockMvc mockMvc;

  @Test
  public void hello() throws Exception {
    this.mockMvc.perform(get("/hello/keesun"))
        .andDo(print())
        .andExpect(content().string("hello keesun"));
  }

}