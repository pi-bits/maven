package com.serviceinfotech.config;

import com.serviceinfotech.Service;
import com.serviceinfotech.SessionScopeController;
import com.serviceinfotech.controllers.SessionScopedBean;
import com.serviceinfotech.controllers.SimpleController;
import com.serviceinfotech.model.Customer;
import com.serviceinfotech.model.CustomerService;
import org.springframework.context.annotation.*;
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
    public SessionScopeController sessionScopeController() {
        return new SessionScopeController();
    }

    @Bean
    @Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
    public SessionScopedBean sessionScopedBean() {
        return new SessionScopedBean();
    }

    @Bean
    public Service service() {
        return new Service();
    }

}
