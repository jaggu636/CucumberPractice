package com.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.webpackages.AmazonTodayDeals;
import com.webpackages.FlightSearch;
import com.webpackages.FormFilling;
import com.webpackages.OrderLaptopInPaytm;

public class DriverFactory {

	public static WebDriver driver;
	public static String browser = System.getProperty("browser");
	public static String url = System.getProperty("url");
	public static FormFilling form;
	public static AmazonTodayDeals deals;
	public static JavascriptExecutor executor;
	public static FlightSearch flights;
	public static WebDriverWait wait;
	public static OrderLaptopInPaytm paytm;
	public static Actions actions;
	public static String parent;

	public static void loadPages() {

		form = new FormFilling();
		deals = new AmazonTodayDeals();
		flights = new FlightSearch();
		paytm = new OrderLaptopInPaytm();
	}

	public static void threadWait(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void takeScreenshot(String name) {

		// Call Webdriver to click the screenshot.
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// Store the screenshot in current project directory.
		File desFile = new File("./ScreenShots/" + name + ".png");
		if (!desFile.exists()) {
			try {
				desFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// Copy file at Destination
		try {
			FileHandler.copy(srcFile, desFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void doubleClick(WebElement ele) {
		actions = new Actions(driver);
		actions.doubleClick(ele).build().perform();
	}

	public static void mouseHover(WebElement ele) {
		actions = new Actions(driver);
		actions.moveToElement(ele).build().perform();
	}

	public static void javaScriptClick(WebElement ele) {
		executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", ele);
	}

	public static void handleWindows() {

		parent = driver.getWindowHandle();
		System.out.println("Parent tab name is :" + parent);

		Set<String> childs = driver.getWindowHandles();
		Iterator<String> ite = childs.iterator();
		while (ite.hasNext()) {
			System.out.println("Child tab name is :" + ite.next());
			String child = ite.next();
			if (!parent.equals(child)) {
				driver.switchTo().window(child);
			}
		}
	}

	public static void switchToParent() {
		driver.switchTo().window(parent);
	}
}
