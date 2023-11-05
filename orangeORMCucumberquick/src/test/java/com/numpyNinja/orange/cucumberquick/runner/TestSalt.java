package com.numpyNinja.orange.cucumberquick.runner;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions.SnippetType;
/*
	@RunWith(Cucumber.class)
	@Suite.SuiteClasses({
		   JunitChromeRunner.class,
		   JunitEdge.class,
		   JunitFirefox.class
		})
	@io.cucumber.junit.CucumberOptions(
			//tags = ("(@smoke and @sanity) or (@valid and @regression) "),		//runs only juice
			features = {"classpath:com/numpyNinja/orange/cucumberquick/features"},
			glue = {"com/numpyNinja/orange/cucumberquick/steps"},
			plugin = {"pretty","summary", "html:target/cucumber/junit-rpt.html",
							"json:target/cucumber/report.json",
							"junit:target/cucumber/report.xml",
							"timeline: target/cucumber"},
			snippets = SnippetType.CAMELCASE,
			dryRun = false, //default
			monochrome = true,
			publish = true
			
		)*/
	public class TestSalt {

}
