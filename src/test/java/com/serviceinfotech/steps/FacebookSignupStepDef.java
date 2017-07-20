package com.serviceinfotech.steps;

import com.serviceinfotech.utils.WebDriverManager;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java8.En;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;


public class FacebookSignupStepDef  implements En {
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

    public FacebookSignupStepDef() {
        Given("^I am on Facebook home page$", () -> {
            assertFalse(fireFoxWebDriver==null);
            fireFoxWebDriver.get("https://www.facebook.com/");
            assertThat(fireFoxWebDriver.findElement(By.linkText("Sign Up")).getText(), equalTo("Sign Up"));
        });
        When("^I click on Facebook Sign up$", () -> {

            fireFoxWebDriver.findElement(By.linkText("Sign Up")).click();
      });
        Then("^I go to Facebook Sign up Page$", () -> {
            wait.until(ExpectedConditions.titleIs("Sign up for Facebook | Facebook"));
            assertThat(fireFoxWebDriver.getTitle(),equalTo("Sign up for Facebook | Facebook"));
        });
    }
}
