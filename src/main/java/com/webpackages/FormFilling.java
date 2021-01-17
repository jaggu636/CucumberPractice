package com.webpackages;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.utilities.DriverFactory;

public class FormFilling extends DriverFactory {

	public FormFilling() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//label[@id='userName-label']/following::input[@id='firstName']")
	public WebElement firstName;

	@FindBy(how = How.XPATH, using = "//label[@id='userName-label']/following::input[@id='lastName']")
	public WebElement lastName;

	@FindBy(how = How.XPATH, using = "//label[@id='userEmail-label']/following::input[@id='userEmail']")
	public WebElement email;

	@FindBy(how = How.XPATH, using = "//input[@value='Male']/following::label[1]")
	public WebElement male;

	@FindBy(how = How.XPATH, using = "//label[@id='userNumber-label']/following::input[@id='userNumber']")
	public WebElement mobileNumber;

	@FindBy(how = How.XPATH, using = "//label[@id='dateOfBirth-label']/following::input[@id='dateOfBirthInput']")
	public WebElement dobCalender;

	@FindBy(how = How.XPATH, using = "//input[@id='hobbies-checkbox-3']/following::label[1]")
	public WebElement musicChekbox;

	@FindBy(how = How.XPATH, using = "//div[@id='subjectsContainer']/div/div[1]")
	public WebElement subjects;

	@FindBy(how = How.XPATH, using = "//input[@id='subjectsInput']")
	public WebElement subjectsData;

	@FindBy(how = How.XPATH, using = "//div[starts-with(@class, 'subjects-auto-complete__menu-list')]/div")
	public List<WebElement> subjectAutoSuggestions;

	@FindBy(how = How.XPATH, using = "//label[@for='uploadPicture']")
	public WebElement selectImage;

	public static void personalDetails() {

		form.firstName.sendKeys("Jagadeesh");
		form.lastName.sendKeys("Kurry");
		form.male.click();
		form.email.sendKeys("j@gmail.com");
		form.mobileNumber.sendKeys("8123123123");
		form.musicChekbox.click();

	}

	public static void selectDOB() {

		driver.findElement(By.xpath("//input[@id='dateOfBirthInput']")).click();

		WebElement month = driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']"));
		Select selectMonth = new Select(month);
		selectMonth.selectByVisibleText("July");

		WebElement year = driver.findElement(By.xpath("//select[@class=\"react-datepicker__year-select\"]"));
		Select selectYear = new Select(year);
		selectYear.selectByValue("1991");

		List<WebElement> listOfDates = driver.findElements(By.xpath("//div[@class='react-datepicker__month']/div/div"));

		for (WebElement selectDate : listOfDates) {
			if (selectDate.getText().equals("18")) {
				selectDate.click();
				break;
			}
		}
	}

	public static void subjects() {

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		form.subjectsData.sendKeys("E");

		boolean status = false;
		for (WebElement ele : form.subjectAutoSuggestions) {

			if (ele.getText().equals("Chemistry")) {
				ele.click();
				status = true;
				break;
			}
		}
		if (status) {
			System.out.println("Subject Selected Successfully");
		} else {
			Assert.fail();
		}
	}

	public static void uploadImage() {

		// form.uploadImage.sendKeys("C:\\Users\\JK Images\\1.jpg");
		// form.selectImage.click();
		
		javaScriptClick(form.selectImage);
		
		try {
			Runtime.getRuntime().exec("E:\\Upload_Image.exe");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
