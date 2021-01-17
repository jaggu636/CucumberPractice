package com.stepDefinitions;

import com.webpackages.AmazonTodayDeals;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class AmazonDealsSteps {

	@Given("User clicked on amazon deals")
	public void user_clicked_on_amazon_deals() {
		AmazonTodayDeals.clickTodaysDeals();
	}

	@And("User selected all department filters")
	public void user_selected_all_department_filters() {
		AmazonTodayDeals.selectDepartmentFiltes();
	}
}
