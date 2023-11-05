package com.numpyNinja.orange.cucumberquick.pages;

import java.time.Month;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.numpyNinja.orange.cucumberquick.util.AllActions;


public class CalendarPage extends AllActions {
	WebDriver driver;
	By locator;
	int monthDays;

	public CalendarPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	@FindBy(xpath = "//div[contains(@class,'oxd-calendar-selector-year')]")
	WebElement elementYear;

	@FindBy(xpath = "//div[contains(@class,'oxd-calendar-selector-month')]")
	WebElement elementMonth;

	public void SetDMYOnCalendar(int date, int month, int year) throws Exception {
		GetYear(year);
		GetMonth(month, year);
		GetDate(month, year, date);
	}

	public void GetYear(int year) throws Exception {
		locator = By.xpath("//div[contains(@class,'oxd-calendar-selector-year')]");
		CallDriverWait(driver, locator);
		ClickElement(elementYear, driver);
		ScrollToElementjs(driver, elementYear);

		if (ValidateYear(year)) {
			driver.findElement(By.xpath("//*[text()='" + year + "']")).click();
			ScrollToElementjs(driver, elementYear);
		}
	}

	public void GetMonth(int month, int year) {
		locator = By.xpath("//div[contains(@class,'oxd-calendar-selector-month')]");
		CallDriverWait(driver, locator);
		ClickElement(elementMonth, driver);
		ScrollToElementjs(driver, elementMonth);

		String monthSel = ValidateMonth(month);
		driver.findElement(By.xpath("//*[text()='" + monthSel + "']")).click();

		ScrollToElementjs(driver, elementMonth);
	}

	public void GetDate(int month, int year, int date) throws Exception {
		if (date > 0 && date <= (Month.of(month).length(year % 4 == 0 ? true : false))) {			
			locator = By.xpath("//div[contains(@class,'oxd-date-input-calendar')]");
			CallDriverWait(driver, locator);
			WebElement allDates = driver.findElement(By.xpath("//*[@class='oxd-date-input-calendar']"));
			ClickElement(allDates, driver);

			driver.findElement(By.xpath("//*[text()='" + date + "']")).click();
			return;
		} else
			throw new Exception("Invalid Date");
	}

	public String ValidateMonth(int month) {
		try {
			if (Month.of(month).name() != null) {
				WebElement allMonths = driver.findElement(By.xpath("//*[@role='menu']"));
				ClickElement(allMonths, driver);

				Pattern pattern = Pattern.compile(Month.of(month).name());
				Matcher matcher = pattern.matcher(allMonths.getText().toUpperCase());
				if (matcher.find()) {
					String monthSel = matcher.group().toLowerCase();
					return monthSel.substring(0, 1).toUpperCase().concat(monthSel.substring(1));
				}
			}
		} catch (Exception e) {
			System.err.println("Enter Valid Month");
			e.printStackTrace(System.err);
			return null;
		} finally {
			// driver.quit();
		}
		return null;
	}

	public boolean ValidateYear(int year) throws Exception {
		if (year > 0) {
			WebElement allYears = driver.findElement(By.xpath("//*[@role='menu']"));
			ClickElement(allYears, driver);

			Pattern pattern = Pattern.compile(Integer.toString(year));
			Matcher matcher = pattern.matcher(allYears.getText());
			if (matcher.find()) {
				//String dateSel = matcher.group();
				return true;
			} else
				throw new Exception("Year Invalid");
		} else
			throw new Exception("Year shouldn't be zero");
	}
}
