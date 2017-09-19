package com.serviceinfotech.aspects;

import com.serviceinfotech.IncomeFormData;
import com.serviceinfotech.IncomeFormDataSanitiser;
import com.serviceinfotech.controllers.IncomeController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.verify;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class)
public class SanitizerAspectTest {

    @Autowired
    IncomeController incomeController;

    @MockBean
    IncomeFormDataSanitiser incomeFormDataSanitiser;


    @Test
    public void proxyObjectCreated() {
        assertTrue(AopUtils.isAopProxy(incomeController));
    }

    @Test
    public void testSanitise() throws Exception {
        IncomeFormData incomeFormData = new IncomeFormData();
        incomeController.doPost(incomeFormData);
        verify(incomeFormDataSanitiser,timeout(1)).sanitise(incomeFormData);
    }

    @Configuration
    @EnableAspectJAutoProxy
    static public class TestContext{

        @Bean
        IncomeController incomeController()
        {
            return new IncomeController();
        }

        @Bean SanitizerAspect aspect() {
            return new SanitizerAspect(incomeFormDataSanitiser());
        }

        @Bean
        IncomeFormDataSanitiser incomeFormDataSanitiser(){
            return new IncomeFormDataSanitiser();
        }
    }

}
