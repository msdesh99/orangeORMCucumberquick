package com.numpyNinja.orange.cucumberquick.hooks;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import com.numpyNinja.orange.cucumberquick.driverFactory.DriverFactory;
import com.numpyNinja.orange.cucumberquick.util.AllActions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;

public class Hooks extends AllActions{
@Before("@login")
	public void set_drivers() {
		for(WebDriver driver: DriverFactory.getMapDrivers().values()) {
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		} 
	}
	
@After("@login")
	public void teardown() {
		//for(WebDriver driver: DriverFactory.getMapDrivers().values()) 
		     //driver.quit();
	} 	
}
