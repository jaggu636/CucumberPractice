package com.stepDefinitions;

import com.webpackages.FlightSearch;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FlightBookingSteps {

	@Given("Click on travel menu")
	public void click_on_travel_menu() {
		FlightSearch.clickOnTravel();
	}

	@Given("Click on flights")
	public void click_on_flights() {
		FlightSearch.clickOnFlights();

	}
	
	@When("Select Round Trip")
	public void select_roundTrip() {
		FlightSearch.clickOnroundTrip();
	}

	@Then("Select origin")
	public void select_origin() {
		FlightSearch.selectOrigin();

	}

	@When("Select destination")
	public void select_destination() {
		FlightSearch.selectDestination();
	}

	@Given("Select monthDates")
	public void select_month_dates() {
		FlightSearch.selectDepartureMonthDates();
		FlightSearch.selectReturnMonthDates();
	}

	@Given("Select no of passengers")
	public void select_no_of_passengers() {
		FlightSearch.classPassengers();
	}

	@Then("Click search flights")
	public void click_search_flights() {
		FlightSearch.clickSearchFlightsButton();
	}

	@When("Select departure times")
	public void select_departure_times() {
		FlightSearch.selectDepatureTimes();
	}

	@When("Select airlines")
	public void select_airlines() {
		FlightSearch.selectAirlines();
	}

	@Then("Select first result in flight results")
	public void select_first_result_in_flight_results() {
		FlightSearch.selectFirstFlightResult();
	}
}
