package com.serviceinfotech;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(glue = "com.serviceinfotech.steps",
        features = "classpath:features/GitHubSignUp.feature",
        monochrome = true,
        format = { "pretty", "html:target/cucumber" }

)
public class GitHubScenarioRunner {
}
