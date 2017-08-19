package com.serviceinfotech.steps;

import com.serviceinfotech.utils.WebDriverManager;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java8.En;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.management.ManagementFactory;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;


public class FacebookSignupStepDef  implements En {
    static WebDriver webDriver;
    static WebDriverWait wait;

    @Before
    public void setUp()
    {
        webDriver = WebDriverManager.getphantomjsdriver();
        wait = new WebDriverWait(webDriver, 20);
        long threadId = Thread.currentThread().getId();
        String processName = ManagementFactory.getRuntimeMXBean().getName();
        System.out.println("FacebookSignupStepDef" + "Started in thread: " + threadId + ", in JVM: " + processName);
    }
    @After
    public void tearDown()
    {
        webDriver.quit();
    }

    public FacebookSignupStepDef() {
        Given("^I am on Facebook home page$", () -> {
            assertFalse(webDriver ==null);
            webDriver.get("https://www.facebook.com/");
            assertThat(webDriver.getTitle(), equalTo("Facebook – log in or sign up"));
        });
        When("^I click on Facebook Sign up$", () -> {


      });
        Then("^I go to Facebook Sign up Page$", () -> {

        });
    }
}
