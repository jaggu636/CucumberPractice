package com.cucumber.hooks;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.utilities.DriverFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends DriverFactory {

	public static void openBrowser(String browser) {
		
		switch (browser.toUpperCase()) {
		case "CHROME":
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "FIREFOX":
			System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("Unable to Open Browser");
			break;
		}
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		
		
	}
	
	public static void openURL(String	url) {
		
		if (url.toUpperCase().equals("AMAZON")) {
			driver.get("https://www.amazon.in/");
		}else if (url.toUpperCase().equals("FLIPKART")) {
			driver.get("https://www.flipkart.com/");
		}else if (url.toUpperCase().equals("TOOLSSQA")) {
			driver.get("https://demoqa.com/automation-practice-form");
		}else if (url.toUpperCase().equals("FLIGHTS")) {
			driver.get("https://www.dbs.com.sg/personal/marketplace/");
		}else if (url.toUpperCase().equals("PAYTM")) {
			driver.get("https://paytm.com/");
		}
		else {
			System.out.println("No URL Found");
		}
	}
	
	@Before
	public static void initBrowser() {
		openBrowser(browser);
		openURL(url);
		loadPages();
	}
	
	@After
	public static void tearDown() {
		//driver.close();
	}
}
