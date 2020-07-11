package com.training.testrunner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/main/resources/com/training/features/registration.feature"},
		glue = {"com.training"}, 
		plugin = {
				"pretty", 
				"html:target/cucumber-html-report" , 
				"json:target/cucumber-json-report"
		}, 
		monochrome = true
		//,tags = {"@sanity","~@telecom"}

		)
public class TestRunnerTestNG extends AbstractTestNGCucumberTests {
}
