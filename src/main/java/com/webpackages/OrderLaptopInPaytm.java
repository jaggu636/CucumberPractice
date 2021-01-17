package com.webpackages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.utilities.DriverFactory;

public class OrderLaptopInPaytm extends DriverFactory {

	public OrderLaptopInPaytm() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "(//div[@id='app']//following::i[@class='iconMenu cursor'])[1]")
	WebElement iconMenu;

	@FindBy(how = How.XPATH, using = "//a[text() = 'All Laptops']")
	WebElement allLaptops;

	@FindBy(how = How.XPATH, using = "//div[@class='wZpk']/div/div/div/div[1]")
	List<WebElement> filtersMenu;

	@FindBy(how = How.XPATH, using = "//div[@class='DMLK']/div/div/label/span[2]")
	List<WebElement> individualFilter;

	@FindBy(how = How.XPATH, using = "//div[@class='wZpk']/div/div/div/div[1]/following::div[1]")
	WebElement filterBox;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Min']")
	WebElement minimumPrice;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Max']")
	WebElement maximumPrice;

	@FindBy(how = How.XPATH, using = "//div[@class='_1EI9 CtZB']")
	WebElement filteredResultsCount;

	@FindBy(how = How.XPATH, using = "//div[@class='_1kMS']")
	WebElement productPLP;

	@FindBy(how = How.XPATH, using = "//div[@class='_2viE']")
	WebElement productName;

	@FindBy(how = How.XPATH, using = "//div[@class='DoG0']")
	WebElement additionalCashback;

	@FindBy(how = How.XPATH, using = "//div[@class='_2csj']")
	WebElement paytmCash;

	@FindBy(how = How.XPATH, using = "//div[@class='_3cBS']/span[2]")
	WebElement changePincodeButton;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Enter Pincode']")
	WebElement enterPincode;

	@FindBy(how = How.XPATH, using = "//div[@class='_15EQ']")
	WebElement delvieredBy;

	@FindBy(how = How.XPATH, using = "//span[text()='Select EMI']")
	WebElement selectEMIbutton;

	@FindBy(how = How.XPATH, using = "//span[text()='HDFC Bank Credit Card']")
	WebElement hdfcCreditCard;

	@FindBy(how = How.XPATH, using = "(//div[@class='_2hgP'])[2]/div[3]")
	WebElement EMIperMonthFor6Months;

	@FindBy(how = How.XPATH, using = "//i[@class='iconCross']")
	WebElement closeEMIWindow;

	@FindBy(how = How.XPATH, using = "//span[text() = 'Buy Now']")
	WebElement buyNowButton;

	@FindBy(how = How.XPATH, using = "//span[@class = '_1V3w']")
	WebElement productPricePDP;

	@FindBy(how = How.XPATH, using = "//div[@class = '_7l_E']")
	WebElement productPriceCart;

	@FindBy(how = How.XPATH, using = "//div[@class = '_3jbi']")
	WebElement productQuantity;

	@FindBy(how = How.XPATH, using = "//a[text() = 'Continue Shopping']")
	WebElement continueShoppingButton;

	@FindBy(how = How.XPATH, using = "//div[@class = '_3vET']")
	WebElement cartQuantity;

	@FindBy(how = How.XPATH, using = "//div[@class='KYSE']")
	WebElement productAmountUnderCartIcon;

	@FindBy(how = How.XPATH, using = "//div[@class='_3pg_']")
	WebElement cartIcon;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, '_39Hp')]")
	WebElement cartValue;

	@FindBy(how = How.XPATH, using = "//a[@class='_2Y-B']/i")
	WebElement paytmLogo;

	@FindBy(how = How.XPATH, using = "(//div[text()='Return Policy'])[1]")
	WebElement returnPolicyButton;

	@FindBy(how = How.XPATH, using = "//div[@class='FqsW']//div[text() = 'Return Policy']/following::div[1]")
	WebElement returnPolicy;

	@FindBy(how = How.XPATH, using = "//div[text()='overview']")
	WebElement overView;
	
	@FindBy(how = How.XPATH, using = "//div[text()='Manufacturing Info']")
	WebElement manufacturingInfo;
	
	@FindBy(how = How.XPATH, using = "//div[@class='_3uhD']")
	WebElement countryOfOrigin;
	
	@FindBy(how = How.XPATH, using = "//div[@class='_28Ki']/i/following-sibling::h2[text() = 'Manufacturer Details']")
	WebElement manufacturerDetails;
	
	@FindBy(how = How.XPATH, using = "//div[text() = 'Manufactured By']/following-sibling::div")
	WebElement manufactureredBy;

	public static void goToLaptopsPage() {
		paytm.iconMenu.click();
		paytm.allLaptops.click();
	}

	public static String filterContent = "//div[text() = 'dummyName1']/i/following::div[@class='DMLK'][1]";

	public static WebElement filterType1(String xpath, String dummyName1, String replaceValue) {
		WebElement filter = driver.findElement(By.xpath(xpath.replace(dummyName1, replaceValue)));
		return filter;
	}

	public static String filterMinusPlus = "//div[text() = 'dummyName2']/i";

	public static WebElement filterType2(String xpath, String dummyName2, String replaceValue) {
		WebElement filter = driver.findElement(By.xpath(xpath.replace(dummyName2, replaceValue)));
		return filter;
	}

	public static void selectFilters(String name, String FilterOptions) {

		WebElement filterContentBox = filterType1(filterContent, "dummyName1", name);
		WebElement filterPlusMinusIcon = filterType2(filterMinusPlus, "dummyName2", name);
		// Expand Filter
		if (filterContentBox.isDisplayed()) {
			threadWait(3000);
		} else {
			filterPlusMinusIcon.click();
			threadWait(3000);
		}
		// Select Individual Filters
		for (WebElement filter : paytm.individualFilter) {
			if (filter.getText().equals(FilterOptions)) {
				filter.click();
				threadWait(3000);
				break;
			}
		}
	}

	public static String filterPlusMinus = "//div[text() = 'dummyName']/i";

	public static WebElement filterType(String xpath, String dummyName, String replaceValue) {
		WebElement filter = driver.findElement(By.xpath(xpath.replace(dummyName, replaceValue)));
		return filter;
	}

	public static void selectFilter(String name, String filterOptions) {
		WebElement filterName = filterType(filterPlusMinus, "dummyName", name);
		// Expand Filter
		if (name.equals("Brand")) {
			doubleClick(filterName);
			threadWait(3000);
		} else if (name.equals("RAM")) {
			doubleClick(filterName);
			threadWait(3000);
		} else {
			filterName.click();
			threadWait(3000);
		}
		// Select Individual Filters
		for (WebElement filter : paytm.individualFilter) {
			if (filter.getText().equals(filterOptions)) {
				filter.click();
				threadWait(3000);
				break;
			}
		}
	}

	public static void selectBrand() {
		selectFilters("Brand", "Asus");
		System.out.println("Asus Selected Successfully");
	}

	public static void selectRam() {
		selectFilters("RAM", "16 GB");
		System.out.println("16GB RAM Selected Successfully");
	}

	public static void selectProcessor() {
		selectFilters("Processor", "Intel Core i7");
		System.out.println("i7 Processor Selected Successfully");
	}

	public static void selectScreenSize() {
		selectFilters("Screen Size (Inch)", "15.1 - 16 inch");
		System.out.println("Screensize Selected Successfully");
	}

	public static void selectStorageCapacity() {
		selectFilters("Storage Capacity", "1 TB SSD");
		System.out.println("1TB SSD Selected Successfully");
	}

	public static void printAsusFilteredResultsCount() {
		String count = paytm.filteredResultsCount.getText().replaceAll("\\D+", "");
		System.out.println("Asus Filtered Results Count is: " + count);
	}

	public static void priceRange(String minAmount, String maxAmount) {
		paytm.minimumPrice.clear();
		paytm.minimumPrice.sendKeys(minAmount);
		threadWait(3000);
		paytm.maximumPrice.clear();
		paytm.maximumPrice.sendKeys(maxAmount);
	}

	public static void selectPriceRange() {
		priceRange("145000 ", "180000");
		threadWait(5000);
	}

	public static void NavigateToPDP() {
		paytm.productPLP.click();
		handleWindows();
	}

	public static void printcashback() {
		threadWait(5000);
		try {
			if (paytm.additionalCashback.isDisplayed()) {
				String cashback = paytm.additionalCashback.getText().replaceAll("\\D+", "");
				System.out.println(cashback + "% Cashback applicable");
			} else {
				System.out.println("Cashback field not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void printPaytmCash() {
		String cash = paytm.paytmCash.getText().replaceAll("\\D+", "");
		System.out.println("Paytm Cash Worth Rupees" + cash);
	}

	public static void returnPolicy() {
		paytm.returnPolicyButton.click();
		String policy = paytm.returnPolicy.getText();
		System.out.println("Return Policy: " + policy);
	}

	public static void enterPincodeAndVerifyDelivery() {
		javaScriptClick(paytm.changePincodeButton);
		paytm.enterPincode.click();
		paytm.enterPincode.sendKeys("500089");
		paytm.enterPincode.sendKeys(Keys.ENTER);
		threadWait(3000);
		System.out.println(paytm.delvieredBy.getText());
		threadWait(3000);
	}

	public static void verifyEMI() {
		try {
			if (paytm.selectEMIbutton.isDisplayed()) {

				javaScriptClick(paytm.selectEMIbutton);
				threadWait(5000);
				WebElement frames = driver.findElement(By.xpath("(//iframe)[1]"));
				driver.switchTo().frame(frames);
				System.out.println("Navigated to EMI side panel");
				javaScriptClick(paytm.hdfcCreditCard);
				threadWait(3000);
				System.out.println("EMI Amount to be paid for 6 Months is: " + paytm.EMIperMonthFor6Months.getText());
				driver.switchTo().defaultContent();
				paytm.closeEMIWindow.click();

			} else {
				System.out.println("Select EMI  button not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		/*
		 * Set<String> allWindows = driver.getWindowHandles();
		 * System.out.println("Count of windows:" + allWindows.size());
		 * 
		 * for(String curWindow : allWindows){ if (paytm.hdfcCreditCard.isDisplayed()) {
		 * driver.switchTo().window(curWindow); javaScriptClick(paytm.hdfcCreditCard);
		 * //paytm.hdfcCreditCard.click();
		 * System.out.println("EMI Amount to be paid for 6 Months is: " +
		 * paytm.EMIperMonthFor6Months.getText()); paytm.closeEMIWindow.click(); break;
		 * }else { System.out.println("Not found"); }
		 * 
		 * }
		 */
		// handleWindows();
		// driver.switchTo().activeElement();
		// threadWait(3000);
		// mouseHover(paytm.hdfcCreditCard);

	}

	public static void verifyProductPriceInPDPcartPages() {
		String pdpPrice = paytm.productPricePDP.getText();
		paytm.buyNowButton.click();
		threadWait(3000);
		String cartPrice = paytm.productPriceCart.getText();
		if (pdpPrice.equals(cartPrice)) {
			System.out.println("Product price in PDP & Cart got matched");
		} else {
			System.out.println("Product price in PDP & Cart are mismatched");
		}
	}

	public static void printProductQuantityLeft() {
		System.out.println(paytm.productQuantity.getText());
		paytm.continueShoppingButton.click();
	}

	public static void verifyCartIcon() {
		threadWait(3000);
		System.out.println("Number of Items in Cart: " + paytm.cartQuantity.getText());
		mouseHover(paytm.cartQuantity);
		takeScreenshot("Aet");
		System.out.println(
				"Product Amount under Cart Icon: " + paytm.productAmountUnderCartIcon.getText().replaceAll("\\D+", ""));
	}

	public static void CloseChildAndSwitchToParentWindow() {
		driver.close();
		switchToParent();
	}

	public static void cartValueInParentPage() {
		threadWait(3000);
		System.out.println(paytm.cartValue.getText());
	}

	public static void NavigateToHomepage() {
		paytm.paytmLogo.click();
		threadWait(3000);
		String title = driver.getTitle();
		System.out.println("Title of Paytmall Page is: " + title);
	}

	public static void manufacturingInfo() {
		paytm.manufacturingInfo.click();
		System.out.println(paytm.countryOfOrigin.getText());
		if (paytm.manufacturerDetails.isDisplayed()) {
			paytm.manufacturerDetails.click();
		} else {
			System.out.println("Manufacturer Details got expanded already");
		}
		System.out.println("Manufactured by: " + paytm.manufactureredBy.getText());

	}
}
