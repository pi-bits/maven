package com.serviceinfotech.controllers;

import com.serviceinfotech.config.ApplicationConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ApplicationConfiguration.class})
@AutoConfigureMockMvc
public class SessionScopeControllerTest {


    @Autowired
    private MockMvc mockMvc;


    @Test
    public void shouldHaveSessionAttribute() throws Exception {
        MockHttpSession mocksession = new MockHttpSession();
        mockMvc.perform(MockMvcRequestBuilders
                .get("/sessionScope/abc").session(mocksession))
                .andExpect(request()
                        .sessionAttribute("scopedTarget.sessionScopedBean",
                                hasProperty("value",
                                        is("abc"))));
        mockMvc.perform(MockMvcRequestBuilders
                .get("/sessionScope/abc2").session(mocksession))
                .andExpect(request()
                        .sessionAttribute("scopedTarget.sessionScopedBean",
                                hasProperty("value",
                                        is("abc2"))));
        mockMvc.perform(MockMvcRequestBuilders
                .get("/sessionScope/abc3").session(new MockHttpSession()))
                .andExpect(request()
                        .sessionAttribute("scopedTarget.sessionScopedBean",
                                hasProperty("value",
                                        is("abc3"))));
    }
}
