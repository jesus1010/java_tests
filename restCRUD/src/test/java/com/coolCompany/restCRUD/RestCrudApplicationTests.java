package com.coolCompany.restCRUD;

import com.coolCompany.restCRUD.model.User;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.http.MediaType;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RestCrudApplicationTests 
{
  @Autowired
  private WebApplicationContext context;

  private MockMvc mockMvc;

  @Before
  public void setUp() 
  {
    mockMvc= MockMvcBuilders.webAppContextSetup(context).build();
  }


  @Test
  public void testCreateUser() throws Exception 
  {
    String birthday= "1990-01-01";
    String name= "Name1";

    mockMvc.perform(post("/api/user/create")
           .contentType(MediaType.APPLICATION_JSON)
           .content("{\"name\":\"" + name + "\",\"birthday\":\""+ birthday + "\"}"))
           .andExpect(status().isOk())
           .andExpect(jsonPath("$.id", is(1)))
           .andExpect(jsonPath("$.name", is(name)))
           .andExpect(jsonPath("$.birthday", is(birthday)));
  }
}
