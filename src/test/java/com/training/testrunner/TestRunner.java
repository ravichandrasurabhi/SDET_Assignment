package com.training.testrunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


// this is junit 
@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/main/resources/com/training/features"},
		glue = {"com.training.steps"}, 
		plugin = {
					"pretty", 
					"html:target/cucumber-html-report" , 
					"json:target/cucumber-json-report"
				}, 
		monochrome = true
)
public class TestRunner {
	// this class will not have any code 
}
