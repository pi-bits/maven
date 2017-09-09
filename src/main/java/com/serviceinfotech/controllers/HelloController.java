package com.serviceinfotech.controllers;

import com.serviceinfotech.model.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

@RestController
public class HelloController {

    @Autowired
    CustomerService customerService;

    private List customerList;


    public HelloController() {

    }

    @RequestMapping("/hello")
    public String index() {
        if (customerList.size()>0)
        {
            return "Wohaaa we have customers to greet ... Greetings from Spring Boot!";
        }
        else
        {
            return "No customer added :( but still Greetings from Spring Boot!";
        }
    }

    @PostConstruct
    public void init() throws Exception {
        customerList = customerService.getCustomerList();
    }

    @PreDestroy
    public void cleanUp() throws Exception {
    }


}
