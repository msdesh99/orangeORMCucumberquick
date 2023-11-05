package com.numpyNinja.orange.cucumberquick.steps;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.numpyNinja.orange.cucumberquick.driverFactory.DriverFactory;
import com.numpyNinja.orange.cucumberquick.pages.LoginPage;
import com.numpyNinja.orange.cucumberquick.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class LoginStep {
    WebDriver driver;
    String url;
    LoginPage loginPage;
    
	@Given("open url with {string} browser")
	public void open_url_with_browser(String string) throws Exception{
		DriverFactory driverFactory = new DriverFactory();
		driver = driverFactory.SingleDriver(string);
		url = ConfigReader.getUrl();
		driver.get(url);
   }	
	@Given("Send Login {string} with password {string}")
	public void send_login_with_password(String name, String password) {
		for(WebDriver driver: DriverFactory.getMapDrivers().values()) {
			//System.out.println("in map: "+driver.getClass());
			loginPage = PageFactory.initElements(driver, LoginPage.class);
			loginPage.SetLoginCred(new String[] {name,password});
		}
	}
	@Then("click Login Password Submit")
	public void click_login_password_submit() {
		//System.out.println("nothing to do");
	}
	@Then("I verify the {string} in step")
	public void i_verify_the_in_step(String string) {
		//for(WebDriver driver: DriverFactory.getMapDrivers().values())
		 //System.out.println("currentUrl: "+driver.getCurrentUrl());	
	}

}
	
	



