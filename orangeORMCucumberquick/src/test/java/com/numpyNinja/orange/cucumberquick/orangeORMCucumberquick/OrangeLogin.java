package com.numpyNinja.orange.cucumberquick.orangeORMCucumberquick;

import java.time.Duration;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.numpyNinja.orange.cucumberquick.pages.LoginPage;


public class OrangeLogin {
    WebDriver driver;
    String url;
    
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		driver = new ChromeDriver();
		url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		LoginPage loginPage;
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		String[] loginCred = {"Admin","admin123"};
		loginPage.SetLoginCred(loginCred);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		
	}

}
