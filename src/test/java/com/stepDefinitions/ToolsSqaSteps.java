package com.stepDefinitions;

import com.webpackages.FormFilling;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ToolsSqaSteps {

	@Given("User entered personal details")
	public void user_entered_personal_details() {
		FormFilling.personalDetails();
	}

	@And("User selected date of birth")
	public void user_selected_hobbies() {
		FormFilling.selectDOB();
	}

	@When("User entered subjects")
	public void user_uploaded_picture() {
		FormFilling.subjects();
	}
	
	@Then("User uploaded picture")
	public void user_entered_subjects() {
		FormFilling.uploadImage();
	}

	
	
}
