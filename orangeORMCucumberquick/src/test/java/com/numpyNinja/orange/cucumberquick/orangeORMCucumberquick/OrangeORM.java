package com.numpyNinja.orange.cucumberquick.orangeORMCucumberquick;

import java.time.Duration;
import java.util.Iterator;
import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.numpyNinja.orange.cucumberquick.driverFactory.DriverFactory;
import com.numpyNinja.orange.cucumberquick.pages.IndexPage;
import com.numpyNinja.orange.cucumberquick.pages.LoginPage;
import com.numpyNinja.orange.cucumberquick.pages.PersonDetailsPage;
import com.numpyNinja.orange.cucumberquick.util.AllActions;


public class OrangeORM extends AllActions{
	WebDriver driver;
	WebElement element, elementYear, elementMonth, elementDate;
	JavascriptExecutor js;
	By locator;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		DriverFactory driverFactory = new DriverFactory();
		//driverFactory.initializeBrowser();
		
		//ThreadLocal<WebDriver> tdrivers =  driverFactory.getDrivers();
		//Iterator<ThreadLocal<WebDriver>> itr = Iterator.tdrivers;
		//driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		//String url = "https://juice-shop.herokuapp.com/#/login";
		String url="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		//String url = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";

		driver.get(url);
	
		LoginPage loginPage;
		IndexPage indexPage;
		
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		String[] loginCred= {"Admin","admin123"};
		loginPage.SetLoginCred(loginCred);
		
		indexPage = PageFactory.initElements(driver, IndexPage.class);
		indexPage.GetMenu("My Info");
		System.out.println("url: "+ driver.getCurrentUrl());

		driver.manage().window().maximize();

		PersonDetailsPage personDetailsPage;
		personDetailsPage = PageFactory.initElements(driver, PersonDetailsPage.class);
		//personDetailsPage.SetDateFor("License Expiry Date");
		personDetailsPage.SetDateFor("Date of Birth");


	}

	@After
	public void tearDown() throws Exception {
		//driver.quit();
	}

	@Test
	public void test() {
		//fail("Not yet implemented");
	}

}
