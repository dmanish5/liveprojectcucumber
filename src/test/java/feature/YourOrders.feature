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
Feature: Your Orders feature


  @tag1
  Scenario: Checking functionality of Your Orders 
    Given User must be an existing customer with <email> and <password> and signed in url "https://www.amazon.ca/" and navigate to Your Orders page
    When Clickin on Your Order Option should navigate to your order history page
    And Clicking on Buy again should show reccomendations of purchase history
    And Clicking on Not Shipped Yet option should show pending order or display appriopriate message
    And Clicking on Cancelled order Option should show order cancelled in six months.
    Then Customer is happy

  