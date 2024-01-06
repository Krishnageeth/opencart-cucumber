package com.automation.opencart.testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {
		"features" }, glue = "com.automation.opencart.stepdefinitions", dryRun = false, monochrome = true, tags = "@Login or @RegisterAccount", plugin = {
				"html:reports/cucumber.html", "pretty", "json:reports/cucumber.json" })
public class TestRunner {
}
