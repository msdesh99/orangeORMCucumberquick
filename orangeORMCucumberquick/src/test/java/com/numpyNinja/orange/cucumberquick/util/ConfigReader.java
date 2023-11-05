package com.numpyNinja.orange.cucumberquick.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigReader {
    static Properties prop;
	static FileInputStream fis;

    public static Properties initializeProperties() throws Exception {
    	File file = new File("src/test/resources/config/config.properties");    	
//    	File file = new File(System.getProperty("user.dir")+"src/test/resources/config/config.properties");    	
        
    	try {
			fis = new FileInputStream(file);
			prop = new Properties();
			prop.load(fis); //persistent set of properties loading from fis into properties object
		} catch (FileNotFoundException e) {
			throw new Exception("Property file Not Found\n" + e);
			//e.printStackTrace();
		}
    	finally {
    		fis.close();   	
    	}
    	return prop;    	
    }
    public static String getBrowserType() {
    	//System.out.println("getbro:" + prop.getProperty("browserType"));
		return prop.getProperty("browserType");   	
    }
    public static String getUrl() {
		return prop.getProperty("url");   	
    }
}
