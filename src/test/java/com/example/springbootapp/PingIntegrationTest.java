package com.example.springbootapp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PingIntegrationTest {

  private static final String ARTIFACT_ID = "spring-boot-app";
  private static final String VERSION = "0.0.1";
  private static final String PONG = "Hello world, here is spring-boot-app version 0.0.1";

  @Autowired
  private MockMvc mvc;

  @MockBean
  BuildProperties build;

  @Test
  public void testHelloWorldEndpoint() throws Exception {
    doReturn(ARTIFACT_ID).when(build).getName();
    doReturn(VERSION).when(build).getVersion();

    String response = mvc
        .perform(get("/api/ping"))
        .andReturn().getResponse().getContentAsString();
    assertEquals(PONG, response);
  }
}