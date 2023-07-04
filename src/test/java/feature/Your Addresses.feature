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
@tag
Feature: Your Addresses feature

  @tag1
  Scenario: Checking functionality of Your Addresses feature
    Given User must be an existing customer with <email> and <password> and signed in url "https://www.amazon.ca/" and navigate to Your Addresses page
    When Click on Your Addresses option should navigate to add address option page
    And Click on Add Address should should navigate to address window
    And Enter Address details
    And Customer has option to make address as default by clicking it
    And Click on Add address button should save the address in the account
    Then the customer gets the suggestion of right address format but still customer should have choice to select

   
