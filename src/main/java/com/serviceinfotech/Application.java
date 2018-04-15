package com.serviceinfotech;

import com.serviceinfotech.config.ApplicationConfiguration;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackageClasses = {ApplicationConfiguration.class})

public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext applicationContext)
    {
     return args -> {
         System.out.println("Let's inspect the beans provided by Spring Boot:");
//         Object customerService = applicationContext.getBean("customerService");
//         Object anotherCustomerService = applicationContext.getBean("customerService");
//         System.out.println(customerService == anotherCustomerService);
//         anotherCustomerService = applicationContext.getBean("anotherCustomerService");
//         System.out.println(customerService == anotherCustomerService);
//         Object anotherCustomerService1 = applicationContext.getBean("anotherCustomerServiceProtoType");
//         Object anotherCustomerService2 = applicationContext.getBean("anotherCustomerServiceProtoType");
//         System.out.println(anotherCustomerService1 == anotherCustomerService2);

     };
    }
}

