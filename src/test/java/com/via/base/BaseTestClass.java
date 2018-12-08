package com.via.base;

import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTestClass {
		protected static WebDriver driver;

		@BeforeSuite
		@Parameters({"browser","domain"})
	  	public void beforeSuite(String browser, String domain) {
			System.out.println("Init before class");
	  	if(browser.equalsIgnoreCase("chrome")){	
			System.setProperty("webdriver.chrome.driver", ".//src//test//resources//chromedriver.exe");
			driver = new ChromeDriver(new ChromeOptions().addArguments("start-maximized"));
	  	}
	  	else if(browser.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", ".//src//test//resources//geckodriver.exe");
			driver = new FirefoxDriver(new FirefoxOptions().addArguments("start-maximized"));
		}
		else
			driver = new HtmlUnitDriver(true);
			/*switch(browser){
			case "chrome":	
				System.setProperty("webdriver.chrome.driver", ".//src//test//resources//chromedriver.exe");
				driver = new ChromeDriver(new ChromeOptions().addArguments("start-maximized"));
				break;
			case "firefox":
				System.setProperty("webdriver.gecko.driver", ".//src//test//resources//geckodriver.exe");
				driver = new FirefoxDriver(new FirefoxOptions().addArguments("start-maximized"));
				break;
			default:
				driver = new HtmlUnitDriver(true);
			}*/
	  		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(domain);
		}
  
	  @AfterSuite
	  public void afterSuite() {
		  //driver.quit();
	  }
}
