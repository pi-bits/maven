package com.serviceinfotech.controllers;

import com.serviceinfotech.config.ApplicationConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationConfiguration.class)
@WebAppConfiguration
public class SimpleControllerTest {


    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;


    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();

    }

    @Test
    public void validGetInteger() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/simple/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("hello1"))
                .andDo(print());
    }

    @Test
    public void validGetString() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/simple/ghf"))
                .andExpect(status().isOk())
                .andExpect(content().string("hello I am a null object"))
                .andDo(print());
    }

    @Test
    public void withString() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/simple/yhgfh"))
                .andDo(print())
                .andExpect(content().string("hello I am a null object"))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void withInteger() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/simple/2"))
                .andDo(print())
                .andExpect(content().string("hello2"))
                .andExpect(status().is2xxSuccessful());
    }

}