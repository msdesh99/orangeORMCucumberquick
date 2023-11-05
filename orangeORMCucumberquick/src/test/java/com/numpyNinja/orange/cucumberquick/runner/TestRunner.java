package com.numpyNinja.orange.cucumberquick.runner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.numpyNinja.orange.cucumberquick.driverFactory.DriverFactory;

import io.cucumber.testng.AbstractTestNGCucumberTests;

public class TestRunner extends AbstractTestNGCucumberTests {
	@DataProvider(parallel = false)
	public Object[][] scenarios(){
		return super.scenarios();
	}
	@BeforeTest
	@Parameters({"browser"})
	public void SetBrowser(String browser) throws Exception {
		DriverFactory driverFactory = new DriverFactory();
		WebDriver driver = driverFactory.SingleDriver(browser);
	}
	

}
