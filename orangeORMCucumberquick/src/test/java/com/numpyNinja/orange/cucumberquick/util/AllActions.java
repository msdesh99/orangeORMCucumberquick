package com.numpyNinja.orange.cucumberquick.util;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AllActions {
	static JavascriptExecutor js;
	static Actions action;

	public static void ClickElement(WebElement element, WebDriver driver) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	public static void ClickArrElement(WebDriver driver, WebElement[] element) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();arguments[1].click();", element[0], element[1]);
	}

	public WebElement FindElementWithLocator(WebDriver driver, By locator) {
		return new WebDriverWait(driver, Duration.ofSeconds(3))
				.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public WebElement CallDriverWait(WebDriver driver, By locator) {
		return new WebDriverWait(driver, Duration.ofSeconds(6))
				.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public static void ScrollToElementjs(WebDriver driver, WebElement element) {
		js.executeScript("arguments[0].scrollIntoView(true);", element);

	}

	/*
	 * public static void ScrollToLocatorjs(WebDriver driver, By locator) { js =
	 * (JavascriptExecutor) driver;
	 * js.executeScript("arguments[0].scrollIntoView(true);", locator); }
	 */
	public static void ScrollByXYjs(WebDriver driver, int hori, int vert) {
		js = (JavascriptExecutor) driver;
		// js.executeScript("window.scrollBy(top:hori,vert)", "");
		js.executeScript("window.scrollBy(0,document.body.scrollHeight+1200)");
		// js.executeScript("window.scrollBy(0,270)", "");

	}

	public static void ScrollToLocatorActions(WebDriver driver, int x, int y) {
		action = new Actions(driver);
		// action.moveByOffset(0, 270);
		action.scrollByAmount(0, 270);
	}
}
