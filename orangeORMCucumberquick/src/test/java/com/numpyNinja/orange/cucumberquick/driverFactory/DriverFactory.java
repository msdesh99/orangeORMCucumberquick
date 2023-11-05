package com.numpyNinja.orange.cucumberquick.driverFactory;

/*Reference: 
      https://www.youtube.com/watch?v=vhykyolIucs&list=PLnxpMuIcxn1Q1NZhwHeVVCgJHro9xjrTb&index=16
      Cucumber Tutorial | Cucumber BDD Framework Creation
*/
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.numpyNinja.orange.cucumberquick.util.ConfigReader;

public class DriverFactory {
 	static Properties prop;
	static String allBrowsers;
 
    public static HashMap<String, WebDriver> dMap = new HashMap<String,WebDriver>();
    public static ThreadLocal<WebDriver> tDriver; 
    
	public WebDriver SingleDriver(String selectedBrowser) throws Exception {
		prop = new Properties();
		prop = ConfigReader.initializeProperties();		
			if(selectedBrowser.toLowerCase().contentEquals("chrome")) {
				tDriver = new ThreadLocal<>();
				tDriver.set(new ChromeDriver());
			}
			else if(selectedBrowser.toLowerCase().contentEquals("firefox")) {
				tDriver = new ThreadLocal<WebDriver>();
				tDriver.set(new FirefoxDriver());
			}
			else if(selectedBrowser.toLowerCase().contentEquals("edge")) {
				tDriver = new ThreadLocal<WebDriver>();
				tDriver.set(new EdgeDriver());
			}
			else throw new Exception("Browser not supported"); 		
			dMap.put(selectedBrowser.toLowerCase(),tDriver.get());			
		return getDriver();
	}	
	  public static WebDriver getDriver() {
			return tDriver.get();	   
		   }	
		    public static HashMap<String, WebDriver> getMapDrivers(){
			   return dMap;
		   }

}
