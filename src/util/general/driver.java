package util.general;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import util.sharedData;

public class driver {

	public static WebDriver getAUT() {
		WebDriver appUnderTest = null;
		 try {
				if ( sharedData.browserUnderTest.trim().equalsIgnoreCase("Chrome") ) 
				{
				     System.setProperty("webdriver.chrome.driver", sharedData.chomeDriverPath );
				     sharedData.appInstance = new ChromeDriver();
				     sharedData.appInstance.get( util.sharedData.URLUnderTest );
			    	 sharedData.appInstance.manage().window().maximize();
			    	 sharedData.appInstance1 = sharedData.appInstance;
				     return sharedData.appInstance;
				}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} 
		 return null;
	}
	public static WebDriver getAUT( String enviorment ) 
	{
		WebDriver appUnderTest = null;
		 try {
				if ( sharedData.browserUnderTest.trim().equalsIgnoreCase("Chrome") ) {
					System.setProperty("webdriver.chrome.driver", sharedData.chomeDriverPath);
					sharedData.appInstance = new ChromeDriver();
					sharedData.appInstance.get(util.general.ExcelUtility.getValue(sharedData.autConfigurationSheetInstance, enviorment.trim(), 2));
					sharedData.appInstance.manage().window().maximize();
					return sharedData.appInstance;
				}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} 
		 return null;
	}

}
