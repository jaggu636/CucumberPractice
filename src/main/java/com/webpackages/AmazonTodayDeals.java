package com.webpackages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.utilities.DriverFactory;

public class AmazonTodayDeals extends DriverFactory {

	public AmazonTodayDeals() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'Today')]")
	WebElement todaysDeals;

	@FindBy(how = How.XPATH, using = "//div[starts-with(@class , 'a-row a-expander-container')]/span/div/label/input")
	List<WebElement> departmentFilters;

	public static void clickTodaysDeals() {
		deals.todaysDeals.click();
	}

	public static void selectDepartmentFiltes() {

		for (int i = 1; i < deals.departmentFilters.size(); i++) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			WebElement ele = driver.findElement(By.xpath(
					"//div[starts-with(@class , 'a-row a-expander-container')]/span[" + i + "]/div/label/input"));
			ele.click();
		}
	}
}
