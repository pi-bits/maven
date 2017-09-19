package com.serviceinfotech.ui;

import com.serviceinfotech.utils.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

@Ignore
public class SeleniumTest {
    private static final String GECKO_DRIVER_PATH = "C:\\Installations\\Selenium\\geckodriver-v0.18.0-win64\\";
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp() throws Exception {
        driver = WebDriverManager.getFireFoxWebDriver();
        wait = new WebDriverWait(driver, 20);
    }

    @Test
    public void launchFireFoxWithGitHubLoginPage() throws Exception {
        assertFalse(driver==null);
        driver.get("https://github.com/login");
        wait.until(ExpectedConditions.titleIs("Sign in to GitHub · GitHub"));
        assertThat(driver.findElement(By.className("auth-form-header")).getText(), equalTo("Sign in to GitHub"));
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
