package com.serviceinfotech.config;

import com.serviceinfotech.Service;
import com.serviceinfotech.controllers.SimpleController;
import com.serviceinfotech.model.Customer;
import com.serviceinfotech.model.CustomerService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.validation.Validator;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public Validator validator() {
        return new org.springframework.validation.beanvalidation.LocalValidatorFactoryBean();
    }

    @Bean
    @Profile("prodmq")
    public CustomerService customerService() {
        return new CustomerService();
    }

    @Bean
    @Profile("proddb")
    public CustomerService anotherCustomerService() {
        return new CustomerService();
    }

    @Bean
    @Scope(scopeName = "prototype")
    public CustomerService anotherCustomerServiceProtoType() {
        return new CustomerService();
    }

    @Bean
    @Profile("prod")
    public Customer customer() {
        return new Customer();
    }


    @Bean
    public SimpleController simpleController() {
        return new SimpleController();
    }

    @Bean
    public Service service() {
        return new Service();
    }

}
