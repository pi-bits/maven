package com.serviceinfotech.controllers;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloControllerTest {

    @Autowired
    HelloController helloController;


    @Test
    public void testHello() throws Exception {
        Assertions.assertThat(helloController.index()).isEqualTo("Wohaaa we have customers to greet ... Greetings from Spring Boot!");
    }
}
