package com.serviceinfotech.config;

import com.serviceinfotech.model.Customer;
import com.serviceinfotech.model.CustomerService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Validator;

import javax.xml.ws.WebEndpoint;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public Validator validator() {
        return new org.springframework.validation.beanvalidation.LocalValidatorFactoryBean();
    }

    @Bean
    public CustomerService customerService()
    {
     return new CustomerService();
    }


}
