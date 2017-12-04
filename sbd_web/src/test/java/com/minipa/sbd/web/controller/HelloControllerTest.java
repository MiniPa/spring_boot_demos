package com.minipa.sbd.web.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;

/**
 * HelloControllerTest:
 * mockmvc编写简单http请求来测试
 * 利用MockMvcResultHandlers.print()打印结果
 *
 * author: Chengjs, version:1.0.0, 2017-11-21
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloControllerTest {
  private MockMvc mvc;

  @Before
  public void setUp() throws Exception {
    mvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();
  }

  @Test
  public void hello() throws Exception {
    mvc.perform(MockMvcRequestBuilders.get("/direct").accept(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().string(equalTo("Hello World")));
  }

}