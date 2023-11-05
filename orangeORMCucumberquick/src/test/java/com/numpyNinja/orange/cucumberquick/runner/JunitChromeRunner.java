package com.numpyNinja.orange.cucumberquick.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


//@RunWith(Cucumber.class)
@CucumberOptions(
		//tags =("not @firefox and not @edge and @smoke"),
		tags="@tag1",
		features = {"classpath:com/numpyNinja/orange/cucumberquick/features"},
		glue= {"com/numpyNinja/orange/cucumberquick/steps"},
		plugin= {"pretty", "timeline: target/cucumber"},
		dryRun=false
		)
public class JunitChromeRunner { // extends AbstractTestNGCucumberTests {
	/*@Override
	@DataProvider(parallel = false)
	public Object[][] scenarios(){
		return super.scenarios();
	}*/
}


