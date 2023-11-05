package com.numpyNinja.orange.cucumberquick.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.numpyNinja.orange.cucumberquick.util.AllActions;

public class LoginPage extends AllActions {
	WebDriver driver;
	JavascriptExecutor js;

	public LoginPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@name='username']")
	WebElement userElement;

	@FindBy(xpath = "//*[@name='password']")
	WebElement passwordElement;

	@FindBy(xpath = "//*[@type='submit']")
	WebElement submitElement;

	public void SetLoginCred(String[] loginCred) {
		userElement.clear();
		userElement.sendKeys(loginCred[0]);
		passwordElement.clear();
		passwordElement.sendKeys(loginCred[1]);

		ClickArrElement(this.driver, new WebElement[] { userElement, passwordElement });
		submitElement.submit();
	}
}
