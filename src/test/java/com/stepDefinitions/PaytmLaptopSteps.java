package com.stepDefinitions;

import com.utilities.DriverFactory;
import com.webpackages.OrderLaptopInPaytm;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PaytmLaptopSteps extends DriverFactory {

	@Given("Click on All Laptops in Main menu")
	public void click_on_all_laptops_in_main_menu() {
		OrderLaptopInPaytm.goToLaptopsPage();
	}

	@When("Select required filters")
	public void select_filters() {
		OrderLaptopInPaytm.selectBrand();
		OrderLaptopInPaytm.selectRam();
		OrderLaptopInPaytm.selectProcessor();
		OrderLaptopInPaytm.selectScreenSize();
		OrderLaptopInPaytm.selectStorageCapacity();
	}

	@When("Print filtered results")
	public void print_filtered_results() {
		OrderLaptopInPaytm.printAsusFilteredResultsCount();
	}

	@Then("Select Price Range")
	public void select_price_range() {
		OrderLaptopInPaytm.selectPriceRange();
	}

	@Then("Go to product display page")
	public void go_to_product_display_page() {
		OrderLaptopInPaytm.NavigateToPDP();
	}

	@Then("Print Additional Cashback & Paytm Cash")
	public void print_additional_cashback_paytm_cash() {
		OrderLaptopInPaytm.printcashback();
		OrderLaptopInPaytm.printPaytmCash();
	}

	@When("Verify Overview")
	public void verify_overview() {
		// Code
	}

	@Then("Verify Manufacturing Info")
	public void verify_manufacturing_info() {
		OrderLaptopInPaytm.manufacturingInfo();
	}

	@Then("Verify Return Policy")
	public void verify_return_policy() {
		OrderLaptopInPaytm.returnPolicy();
	}

	@When("Enter Pincode to verify delivery")
	public void enter_pincode_to_verify_delivery() {
		OrderLaptopInPaytm.enterPincodeAndVerifyDelivery();
	}

	@Given("Verify HDFC EMI")
	public void verify_hdfc_emi() {
		OrderLaptopInPaytm.verifyEMI();
	}

	@Given("Verify Product Price In PDP & Cart pages")
	public void verify_product_price_in_pdp_cart_pages() {
		OrderLaptopInPaytm.verifyProductPriceInPDPcartPages();
	}

	@Then("Print Product Quantity Left")
	public void print_product_quantity_left() {
		OrderLaptopInPaytm.printProductQuantityLeft();
	}

	@When("Verify Cart Icon")
	public void verify_cart_icon() {
		OrderLaptopInPaytm.verifyCartIcon();
	}

	@When("Close Child & Switch To Parent Window")
	public void close_child_switch_to_parent_window() {
		OrderLaptopInPaytm.CloseChildAndSwitchToParentWindow();
	}

	@Then("Cart Value In Parent Page")
	public void cart_value_in_parent_page() {
		OrderLaptopInPaytm.cartValueInParentPage();
	}

	@Given("Navigate To Homepage")
	public void navigate_to_homepage() {
		OrderLaptopInPaytm.NavigateToHomepage();
	}
}
