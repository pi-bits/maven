package com.serviceinfotech.config;

import com.serviceinfotech.RequestScopedBean;
import com.serviceinfotech.Service;
import com.serviceinfotech.ScopeController;
import com.serviceinfotech.controllers.SessionScopedBean;
import com.serviceinfotech.controllers.SimpleController;
import com.serviceinfotech.model.Customer;
import com.serviceinfotech.model.CustomerService;
import com.serviceinfotech.service.UpdateService;
import com.serviceinfotech.util.RejectionHandler;
import org.springframework.context.annotation.*;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.validation.Validator;
import org.springframework.web.context.WebApplicationContext;

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
    public ScopeController sessionScopeController() {
        return new ScopeController();
    }

    @Bean
    @Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
    public SessionScopedBean sessionScopedBean() {
        return new SessionScopedBean();
    }

    @Bean
    @Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
    public RequestScopedBean requestScopedBean () {
        return new RequestScopedBean();
    }
    @Bean
    public Service service() {
        return new Service();
    }

    @Bean
    public RejectionHandler rejectionHandler()
    {
        return new RejectionHandler();
    }

    @Bean
    public AsyncTaskExecutor taskExecutor(final RejectionHandler rejectionHandler)
    {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setRejectedExecutionHandler(rejectionHandler);
        threadPoolTaskExecutor.setCorePoolSize(2);
        threadPoolTaskExecutor.setMaxPoolSize(5);
        threadPoolTaskExecutor.setQueueCapacity(30);
        threadPoolTaskExecutor.initialize();
        threadPoolTaskExecutor.setWaitForTasksToCompleteOnShutdown(true);
        return threadPoolTaskExecutor;
    }


    @Bean
    public UpdateService updateService(final AsyncTaskExecutor taskExecutor){
        return new UpdateService(taskExecutor);
    }


}
