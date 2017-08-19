package com.serviceinfotech.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

public class WebDriverManager {
    private static final String GECKO_DRIVER_PATH = "C:\\Installations\\Selenium\\geckodriver-v0.18.0-win64\\";
    private static WebDriver driver;

    public static WebDriver getFireFoxWebDriver()
    {
        System.setProperty("webdriver.gecko.driver", GECKO_DRIVER_PATH+"geckodriver.exe");
        if(driver==null)
        {
            driver = new FirefoxDriver();
        }

        return driver;
    }

    public static WebDriver getphantomjsdriver()
    {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        URL resource = classLoader.getResource("phantomjs/bin/"+"phantomjs.exe");
        System.setProperty("phantomjs.binary.path", resource.getPath());
         driver = new PhantomJSDriver();
        return driver;
    }


}
