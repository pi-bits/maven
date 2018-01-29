package com.serviceinfotech.controllers;

import com.serviceinfotech.RequestScopedBean;
import com.serviceinfotech.config.ApplicationConfiguration;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ApplicationConfiguration.class})
@AutoConfigureMockMvc
public class ScopeControllerTest {


    @Autowired
    private MockMvc mockMvc;


    @Test
    public void sessionScopedBeanTest() throws Exception {
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

    @Test
    public void requestScopedBeanTest() throws Exception {
        MockHttpSession mocksession = new MockHttpSession();
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                .get("/requestScope/abc").session(mocksession)).andReturn();

        RequestScopedBean requestScopedBean = (RequestScopedBean) mvcResult.getRequest().getAttribute("scopedTarget.requestScopedBean");
        Assert.assertThat(requestScopedBean.getValue(), is("abc"));
        mvcResult = mockMvc.perform(MockMvcRequestBuilders
                .get("/requestScope/abc1").session(mocksession)).andReturn();

        requestScopedBean = (RequestScopedBean) mvcResult.getRequest().getAttribute("scopedTarget.requestScopedBean");
        Assert.assertThat(requestScopedBean.getValue(), is("abc1"));

        mvcResult = mockMvc.perform(MockMvcRequestBuilders
                .get("/requestScope/abc2").session(new MockHttpSession())).andReturn();

        requestScopedBean = (RequestScopedBean) mvcResult.getRequest().getAttribute("scopedTarget.requestScopedBean");
        Assert.assertThat(requestScopedBean.getValue(), is("abc2"));


    }


}
