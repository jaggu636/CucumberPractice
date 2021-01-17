#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: Cucumber Practice

 * Scenario: Form Filling
    Given User entered personal details
    And User selected date of birth
    When User entered subjects
    Then User uploaded picture
    
* Scenario: Amazon Deals
 		Given User clicked on amazon deals
 		And User selected all department filters
 		
* Scenario: Flight Booking
 		Given Click on travel menu
		And Click on flights
		When Select Round Trip
		Then Select origin
		When Select destination
		Given Select monthDates
		And Select no of passengers
		Then Click search flights
		When Select departure times
		When Select airlines
		Then Select first result in flight results


	Scenario: Flight Booking
 		Given Click on All Laptops in Main menu
		When Select required filters
		And Print filtered results
		Then Select Price Range
		And Go to product display page
		Then Print Additional Cashback & Paytm Cash
		When Verify Overview
		Then Verify Manufacturing Info
		And Verify Return Policy
		When Enter Pincode to verify delivery
		Given Verify HDFC EMI 
		And Verify Product Price In PDP & Cart pages
		Then Print Product Quantity Left
		When Verify Cart Icon
		And Close Child & Switch To Parent Window
		Then Cart Value In Parent Page
		Given Navigate To Homepage

		
		
		
		
		
		
		
		
		
		