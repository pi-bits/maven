package com.serviceinfotech;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import java.io.File;

public class PhantomJsDemoTest {
    @Test
    public void testGooglePageWithPhantomJS() throws Exception {
        File file = new File("C:\\SWF\\phantomjs-2.1.1-windows\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
        System.setProperty("phantomjs.binary.path", file.getAbsolutePath());
        WebDriver driver = new PhantomJSDriver();
        driver.get("https://www.google.co.uk");
        Thread.sleep(1000);
        Assert.assertThat("Google", CoreMatchers.is(CoreMatchers.equalTo(driver.getTitle())));

    }
}


