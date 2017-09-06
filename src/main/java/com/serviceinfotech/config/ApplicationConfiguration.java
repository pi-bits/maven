package com.serviceinfotech.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Validator;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public Validator validator() {
        return new org.springframework.validation.beanvalidation.LocalValidatorFactoryBean();
    }

}
