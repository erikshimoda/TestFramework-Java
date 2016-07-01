package com.testframeworkdemo.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


//@RunWith(Cucumber.class)
//@CucumberOptions(features = "classpath:features"
//	, tags = {"@testeMobile"}
//	, monochrome = true
//	, plugin = { "pretty", "html:target/cucumber-html-report", "json:cucumber.json" }
//    , glue = "com.testframeworkdemo")
//public class RunGUIMobileTest extends AbstractTestNGCucumberTests {
//
//}

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "classpath:features"
		, plugin = { "pretty", "html:target/cucumber-html-report", "json:cucumber.json" }
		, monochrome = true
		, tags = { "@testeMobile" }
		, glue = { "com.testframeworkdemo" }
)

public class RunGUIMobileTest {
}