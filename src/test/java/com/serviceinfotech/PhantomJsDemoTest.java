package com.serviceinfotech;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;

public class PhantomJsDemoTest {
    @Test
    public void testGooglePageWithPhantomJS() throws Exception {

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        URL resource = classLoader.getResource("phantomjs/bin/"+"phantomjs.exe");
        System.setProperty("phantomjs.binary.path", resource.getPath());
        WebDriver driver = new PhantomJSDriver();
        driver.get("https://www.google.co.uk");
        Thread.sleep(1000);
        Assert.assertThat("Google", CoreMatchers.is(CoreMatchers.equalTo(driver.getTitle())));c:
        DriverUtility.captureScreen(driver);

    }
}


