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
import static org.junit.Assert.assertTrue;

public class GitHubSignupStepDefinition implements En  {
    static WebDriver webdriver;
    static WebDriverWait wait;
    @Before
    public void setUp()
    {
        webdriver = WebDriverManager.getphantomjsdriver();
        wait = new WebDriverWait(webdriver, 20);
        long threadId = Thread.currentThread().getId();
        String processName = ManagementFactory.getRuntimeMXBean().getName();
        System.out.println("GitHubSignupStepDefinition" + "Started in thread: " + threadId + ", in JVM: " + processName);
    }
    @After
    public void tearDown()
    {
        webdriver.quit();
    }

    public GitHubSignupStepDefinition() {
            Given("^I am on Git hub home page$", () -> {
                assertFalse(webdriver ==null);
                webdriver.get("https://github.com");
                assertThat(webdriver.getTitle(), equalTo("The world's leading software development platform · GitHub"));

    });

        When("^I click on Sign up$", () -> {
            assertTrue(true);

        });
        Then("^I go to Sign up Page$", () -> {
            assertTrue(true);

        });
    }




}
