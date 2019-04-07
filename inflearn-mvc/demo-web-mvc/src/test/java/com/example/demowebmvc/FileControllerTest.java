package com.example.demowebmvc;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 * @author choijaeyong on 07/04/2019.
 * @project demo-web-mvc
 * @description
 */

@RunWith(SpringRunner.class)
@SpringBootTest   // 모든 빈을 다 등록해서 애플리케이션 전반에 걸친 테스트를 하려면 이걸 붙인다.
@AutoConfigureMockMvc
public class FileControllerTest {
  // SpringBootTest 가 MockMvc빈을 등록해주지 않기에 그 아래 애노테이션도 써준다.

  @Autowired
  private MockMvc mockMvc;


  @Test
  public void fileUploadTest() throws Exception {

    MockMultipartFile file = new MockMultipartFile("file","test.txt","text/plain","hello file".getBytes());


    mockMvc.perform(multipart("file").file(file))
        .andDo(print())
        .andExpect(status().is3xxRedirection());
  }








}