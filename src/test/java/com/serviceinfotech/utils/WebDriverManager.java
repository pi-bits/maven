package com.serviceinfotech.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

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


}
