package com.numpyNinja.orange.cucumberquick.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.numpyNinja.orange.cucumberquick.util.AllActions;


public class PersonDetailsPage extends AllActions {
	WebDriver driver;
	By locator;
	CalendarPage calendarPage;

	public PersonDetailsPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// @FindBy(xpath =
	// "//*[contains(@class,'oxd-date-input-icon')]//preceding::label[1]")
	@FindBy(xpath = "//*[contains(@class,'oxd-date-input-icon')]//preceding::div[1]")
	List<WebElement> calenderElement;

	// preceding::label[text()="License Expiry Date"]
	WebElement BirthDate;

	// [text()="License Expiry Date"]
	WebElement expiryDate;

	// *[contains(@class,'oxd-date-input-icon')]//preceding::label[1][text()="License
	// Expiry Date"]
	// ..//following::div/*[@class="oxd-icon bi-calendar oxd-date-input-icon"]

	public void SetDateFor(String type) {
		for (WebElement dateType : calenderElement) {
			if (dateType.getText().contentEquals(type)) {
				ClickElement(dateType, driver);
				locator = By.xpath("//label[text()='" + type + "']"
						+ "//..//following::*[contains(@class,'oxd-date-input-icon')]");
				// WebElement dateElement = CallDriverWait(driver, locator);
				ClickElement(CallDriverWait(driver, locator), driver);
				// ScrollByXYjs(driver, 0,270);
				ScrollToElementjs(driver, dateType);
				calendarPage = PageFactory.initElements(driver, CalendarPage.class);
				try {
					calendarPage.SetDMYOnCalendar(10, 10, 2001);
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			}
		}
	}

}