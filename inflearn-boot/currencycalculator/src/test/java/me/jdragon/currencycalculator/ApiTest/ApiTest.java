package me.jdragon.currencycalculator.ApiTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 * @author choijaeyong on 19/04/2019.
 * @project currencycalculator
 * @description
 */

@RunWith(SpringRunner.class)
@WebMvcTest
public class ApiTest {
  @Autowired
  MockMvc mockMvc;

  @Test
  public void get_api_test() throws Exception {
    mockMvc.perform(get("/api"))
        .andDo(print())
        .andExpect(status().isOk());
  }

}
