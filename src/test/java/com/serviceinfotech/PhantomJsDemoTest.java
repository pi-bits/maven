package com.serviceinfotech;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Ignore;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import java.net.URL;

public class PhantomJsDemoTest {
    @Ignore
    public void testGooglePageWithPhantomJS() throws Exception {

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        URL resource = classLoader.getResource("phantomjs-2.1.1-macosx/bin/" + "phantomjs");
        System.setProperty("phantomjs.binary.path", resource.getPath());
        WebDriver driver = new PhantomJSDriver();
        driver.get("https://www.google.co.uk");
        Thread.sleep(1000);
        Assert.assertThat("Google", CoreMatchers.is(CoreMatchers.equalTo(driver.getTitle())));c:
        DriverUtility.captureScreen(driver);

    }
}


