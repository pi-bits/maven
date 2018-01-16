package com.serviceinfotech;

import com.serviceinfotech.config.ApplicationConfiguration;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ApplicationConfiguration.class})
@ActiveProfiles("test")
public class ServiceTest {

    @Autowired
    Service service;


    @Test
    public void returnsHello() throws Exception {
        Assert.assertEquals("Hello" , service.sayHello());

    }
}
