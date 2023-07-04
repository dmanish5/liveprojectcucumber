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
Feature: Payments feature Test
  

  @tag1
  Scenario: Checking functionality of Payments page
    Given User must be an existing customer with email and password and signed in url "https://www.amazon.ca/" and navigate to Your Payments page
    When Click on Your Payments option should navigate to payments option page to add payments
    And Click on add a credit or debit card button
    And Add Card number and Name on card,select expiry date and click on add you card
    Then Payment added
    


 
