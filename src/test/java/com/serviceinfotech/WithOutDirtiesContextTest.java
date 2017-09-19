package com.serviceinfotech;

import com.serviceinfotech.config.ApplicationConfiguration;
import com.serviceinfotech.model.Customer;
import com.serviceinfotech.model.CustomerService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfiguration.class , loader=AnnotationConfigContextLoader.class)
public class WithOutDirtiesContextTest {

    @Autowired
    protected Customer customer;

    @Autowired
    ApplicationContext applicationContext;

    @Before
    public void setUp() throws Exception {
        System.out.println(applicationContext.getBeanDefinitionNames());
        System.out.println("beforeTest:" + customer);
        customer.setFirstName("Roy");
    }

    @Test
    @DirtiesContext
    public void customer1test() throws Exception {
        System.out.println("customer1Test:" + customer);
    }

    @Test
    @DirtiesContext
    public void customer2test() throws Exception {
        System.out.println("customer2Test:" + customer);
        customer.setFirstName("Sam");
    }
    @Test
    public void customer3test() throws Exception {
        System.out.println("customer3Test:" + customer);
        customer.setFirstName("Kim");
    }
    @Test
    public void customer4test() throws Exception {
        System.out.println("customer4Test:" + customer);
        customer.setFirstName("Rita");
    }


    @After
    public void tearDown() throws Exception {
        System.out.println("afterTest: " + customer);
    }
}
