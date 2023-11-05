package com.numpyNinja.orange.cucumberquick.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.numpyNinja.orange.cucumberquick.util.AllActions;

public class IndexPage extends AllActions {
//ds-algo	//div[@class="card-body d-flex flex-column"]/*[@class="card-title" and text()="Data Structures-Introduction"]
	//url = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
	WebDriver driver;
    
	public IndexPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
//	@FindBy(xpath="//*[text()='My Info']")
//	WebElement myInfoElement;

	@FindBy(css="ul.oxd-main-menu>li>a>span")
	List<WebElement> allMenu;

	//@FindBy(css="ul.oxd-main-menu>li>a>span[text()='Admin']") //not working for text()
	//@FindBy(xpath="//ul[@class=\"oxd-main-menu\"]/li/a/span[text()='Admin']")
	WebElement menu;

public void GetMenu(String menuOption){
	              for (WebElement option: allMenu) {
	            	  if(option.getText().contentEquals(menuOption)) {
	          	          ClickElement(option,driver);
	            		  By locator = By.xpath("//span[text()='"+menuOption+"']");
	            		  menu = FindElementWithLocator(this.driver, locator);
	            		  System.out.println("in indexmenu: "+menu.getText());
	            		  break;
	            	  }
	              }	
}

}
