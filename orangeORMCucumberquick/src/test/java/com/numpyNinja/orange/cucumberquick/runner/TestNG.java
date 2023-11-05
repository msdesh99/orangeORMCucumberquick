package com.numpyNinja.orange.cucumberquick.runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//not working parallel with any other feature files or login, need to work on drivers for cross browser when login scenario added ****
//only to open url parallel is working  *****

//@RunWith(Cucumber.class)
@CucumberOptions(
		tags =("not @firefox and not @edge and not @invalid and not @smoke and not @valid"),
		//tags = ("@open or @smoke"),
		features = {"classpath:com/numpyNinja/orange/cucumberquick/features"},
		glue= {"com/numpyNinja/orange/cucumberquick/steps","com/numpyNinja/orange/cucumberquick/hooks"},
		plugin= {"pretty","timeline: target/cucumber"}
		) 
public class TestNG extends AbstractTestNGCucumberTests {
	@Override
	@DataProvider(parallel = false)
	public Object[][] scenarios(){
		return super.scenarios();
	}
}


