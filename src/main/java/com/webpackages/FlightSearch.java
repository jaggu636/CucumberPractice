package com.webpackages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.utilities.DriverFactory;

public class FlightSearch extends DriverFactory {

	public FlightSearch() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//div[@class='select-passenger-item'][1]/span/div[2]")
	WebElement adultIncrement;
	@FindBy(how = How.XPATH, using = "//div[@class='select-passenger-item'][2]/span/div[2]")
	WebElement childIncrement;
	@FindBy(how = How.XPATH, using = "//div[@class='select-passenger-item'][3]/span/div[2]")
	WebElement infantIncrement;

	@FindBy(how = How.XPATH, using = "(//span[@class='total-choice'])[1]")
	WebElement adultCount;
	@FindBy(how = How.XPATH, using = "(//span[@class='total-choice'])[2]")
	WebElement childCount;
	@FindBy(how = How.XPATH, using = "(//span[@class='total-choice'])[3]")
	WebElement infantCount;

	public static void selectPassengerType(String passenger, int value) {
		System.out.println("I'm in select passengers Type");
		threadWait(3000);
		if (passenger.toLowerCase().equals("adult")) {
			typeOfPassengers(1, value - 1);
		} else if (passenger.toLowerCase().equals("child")) {
			typeOfPassengers(2, value);
		} else if (passenger.equalsIgnoreCase("infant")) {
			typeOfPassengers(3, value);
		}
	}

	public static void typeOfPassengers(int i, int value) {
		threadWait(2000);
		String passengerXpath = "(//img[@class='circle-choice plus'])[" + i + "]";
		WebElement ele = driver.findElement(By.xpath(passengerXpath));
		for (int j = 0; j < value; j++) {
			javaScriptClick(ele);
		}
	}

	@FindBy(how = How.XPATH, using = "(//div[contains(@class, 'Styles__ContentBoxContainer')]/a/div[2])[2]")
	WebElement travelMenu;

	@FindBy(how = How.XPATH, using = "//button[@type='button'][text() = 'Flights']")
	WebElement flightsMenu;

	@FindBy(how = How.XPATH, using = "//input[@id='ROUND_TRIP']")
	WebElement roundTrip;

	@FindBy(how = How.XPATH, using = "//input[@id='locationOrigin-input']")
	WebElement flightsFrom;

	@FindBy(how = How.XPATH, using = "//ul[@id='locationOrigin-menu']/li")
	List<WebElement> flightsFromList;

	@FindBy(how = How.XPATH, using = "//input[@id='locationDestination-input']")
	WebElement flightsTo;

	@FindBy(how = How.XPATH, using = "//ul[@id='locationDestination-menu']/li")
	List<WebElement> flightsToList;

	@FindBy(how = How.XPATH, using = "//input[@id='RangeDatePicker-Departing']")
	WebElement departureDate;

	@FindBy(how = How.XPATH, using = "//input[@id='RangeDatePicker-Returning']")
	WebElement returnDate;

	@FindBy(how = How.XPATH, using = "//img[@class='cal-icon next']")
	WebElement monthSelection;

	@FindBy(how = How.XPATH, using = "(//div[contains(@class, 'CalendarMonth_caption')]/strong)[2]")
	WebElement monthName;

	@FindBy(how = How.XPATH, using = "//table[@class='CalendarMonth_table CalendarMonth_table_1']/tbody/tr/td")
	List<WebElement> dates;

	@FindBy(how = How.XPATH, using = "//div[starts-with(@class, 'new-passenger-select')]")
	WebElement classPassengers;

	@FindBy(how = How.XPATH, using = "//div[@class='select-wrapper']//span[text() = 'Business']")
	WebElement businessClass;

	@FindBy(how = How.XPATH, using = "//input[@value='Search Flights']")
	WebElement searchFlights;

	@FindBy(how = How.XPATH, using = "//div[text() = 'Departure times']/following-sibling::div/div/input")
	List<WebElement> departureTimes;

	@FindBy(how = How.XPATH, using = "//div[contains(@class , 'auto-sort-flights')]/div[text() = 'flights found']")
	WebElement flightcount;

	@FindBy(how = How.XPATH, using = "//div[text() = 'Airlines']/following-sibling::div/div/input/following-sibling::div[2]")
	List<WebElement> airlines;

	@FindBy(how = How.XPATH, using = "//div[contains(@class, 'SegmentsListWrapperNew')]/div[1]")
	WebElement firstFlightResult;

	@FindBy(how = How.XPATH, using = "//button[text() = 'Continue with booking']")
	WebElement continueBooking;

	public static void clickOnTravel() {
		flights.travelMenu.click();
	}

	public static void clickOnFlights() {
		flights.flightsMenu.click();
	}

	public static void clickOnroundTrip() {
		if (flights.roundTrip.isSelected()) {
			System.out.println("Default selection is Roundtrip ");
		} else {
			flights.roundTrip.click();
		}
	}

	public static void selectOrigin() {
		flights.flightsFrom.click();
		flights.flightsFrom.clear();
		flights.flightsFrom.sendKeys("sing");

		System.out.println("Size of results for sing : " + flights.flightsFromList.size());

		boolean status = false;

		for (WebElement ele : flights.flightsFromList) {
			if (ele.getText().contains("Singapore Changi Airport")) {
				ele.click();
				status = true;
				break;
			}
		}
		if (status) {
			System.out.println("Origin Selected Successfully");
		} else {
			Assert.fail();
		}
	}

	public static void selectDestination() {

		flights.flightsTo.clear();
		flights.flightsTo.sendKeys("new");

		boolean status = false;
		for (WebElement ele : flights.flightsToList) {
			if (ele.getText().contains("Kennedy")) {
				ele.click();
				status = true;
				break;
			}
		}
		if (status) {
			System.out.println("Destination Selected Successfully");
		} else {
			Assert.fail();
		}
	}

	public static void selectDepartureMonthDates() {

		flights.departureDate.click();

		for (int i = 1; i < 12; i++) {

			if (flights.monthName.getText().equals("November 2021")) {
				System.out.println("Success");
				selectDepartureDate();
				break;
			} else {
				flights.monthSelection.click();
				threadWait(2000);
			}
		}
	}

	public static void selectReturnMonthDates() {
		threadWait(3000);
		flights.returnDate.click();

		for (int i = 1; i < 12; i++) {

			if (flights.monthName.getText().equals("November 2021")) {
				System.out.println("Success");
				selectReturnDate();
				break;
			} else {
				flights.monthSelection.click();
				threadWait(2000);

			}
		}
	}

	public static void selectDepartureDate() {

		for (WebElement departure : flights.dates) {
			if (departure.getText().equalsIgnoreCase("20")) {
				departure.click();
				System.out.println("Departure date selected");
				break;
			} else {
				System.out.println("Departure date not selected");
			}
		}
	}

	public static void selectReturnDate() {

		for (WebElement returnFlight : flights.dates) {
			if (returnFlight.getText().equalsIgnoreCase("22")) {
				returnFlight.click();
				System.out.println("Return date selected");
				break;
			} else {
				System.out.println("Return Flight date not selected");
			}
		}

	}

	// Code to Add Passenger Count
	public String passengerIncrement = "//div[@class='select-passenger-item'][value]/span/div[2]";

	public WebElement findPassengerType(String xpath, String value, String replaceValue) {

		System.out.println("Came to findPassenger");

		WebElement passengerType = driver.findElement(By.xpath(xpath.replace(value, replaceValue)));

		return passengerType;
	}

	public void incrementPassengers(int size, String number) {
		for (int i = 1; i <= size; i++) {
			
			// flights.findPassengerType(passengerIncrement, "value", number).click();

			javaScriptClick(findPassengerType(passengerIncrement, "value", number));
			System.out.println("Came to incrementPassenger");

		}
	}

	public static void classPassengers() {

		flights.classPassengers.click();
		flights.businessClass.click();
		// flights.incrementPassengers(1, "1");
		// flights.incrementPassengers(0, "2");
	}

	public static void clickSearchFlightsButton() {
		flights.searchFlights.click();
	}

	public static void getFlightsCount(WebElement count, String str) {
		String noOfFlights = count.getText().replaceAll("\\D+", "");
		System.out.println("No.fo "+ str + " is: " + noOfFlights);
	}

	public static void selectDepatureTimes() {

		
		
		threadWait(10000);
		getFlightsCount(flights.flightcount, "Results");

		WebElement night = driver.findElement(By.xpath("//input[@value='night']"));
		javaScriptClick(night);
		threadWait(5000);
		getFlightsCount(flights.flightcount, "Night Departure");
		
		/*
		 * for (int i = 1; i <= 3; i++) { WebElement departureTimes =
		 * driver.findElement(By.xpath(
		 * "//div[text() = 'Departure times']/following-sibling::div/div[" + i +
		 * "]/input[@type='checkbox']")); if
		 * (departureTimes.getText().equalsIgnoreCase("Morning")) {
		 * executor.executeScript("arguments[0].click();", departureTimes);
		 * takeScreenshot("Morning"); break; } }
		 */

	}

	public static void selectAirlines() {

		for (WebElement ele : flights.airlines) {
			if (ele.getText().equals("Singapore Airlines")) {
				ele.click();
//				executor.executeScript("arguments[0].click();", ele);
				threadWait(10000);
				getFlightsCount(flights.flightcount, "Singapore Airlines");
				break;
			}
			
		}
		
		
	}

	public static void selectFirstFlightResult() {
		flights.firstFlightResult.click();
	}

	public static void clickContinueBookingButton() {

		flights.continueBooking.click();
		threadWait(2000);
		flights.continueBooking.click();

	}

}
