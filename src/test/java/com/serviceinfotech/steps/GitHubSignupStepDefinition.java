package com.serviceinfotech.steps;

import com.serviceinfotech.utils.WebDriverManager;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java8.En;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class GitHubSignupStepDefinition implements En  {
    static WebDriver fireFoxWebDriver;
    static WebDriverWait wait;
    @Before
    public void setUp()
    {
        fireFoxWebDriver = WebDriverManager.getFireFoxWebDriver();
        wait = new WebDriverWait(fireFoxWebDriver, 20);
    }
    @After
    public void tearDown()
    {
        fireFoxWebDriver.quit();
    }

    public GitHubSignupStepDefinition() {
            Given("^I am on Git hub home page$", () -> {
                assertFalse(fireFoxWebDriver==null);
                fireFoxWebDriver.get("https://github.com");
                wait.until(ExpectedConditions.titleIs("The world's leading software development platform · GitHub"));
                assertThat(fireFoxWebDriver.findElement(By.linkText("Sign up")).getText(), equalTo("Sign up"));

    });

        When("^I click on Sign up$", () -> {
            assertTrue(true);

        });
        Then("^I go to Sign up Page$", () -> {
            assertTrue(true);

        });
    }




}
