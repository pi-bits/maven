package com.serviceinfotech;

import org.junit.Assert;
import org.junit.Test;

public class ServiceTest {


    @Test
    public void returnsHello() throws Exception {
        Service service = new Service();
        Assert.assertEquals("Hello" , service.sayHello());

    }
}
