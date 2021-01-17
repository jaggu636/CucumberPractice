package com.webpackages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample {
	public static WebDriver driver;

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\ZCucumberPractice\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		/*
		 * String s = "Brand       d4   +"; String x = s.replace("+", "1");
		 * System.out.println(x);
		 */		
		driver.get("https://paytmmall.com/laptops-glpid-6453?src=store&from=storefront&page=1");
		
		List<WebElement> element = driver.findElements(By.xpath("//div[@class='wZpk']/div/div/div/div[1]/i"));
		
		for (WebElement ele : element) {
			String str = ele.getText();
			System.out.println("JK" + str);
		}
	}

}
