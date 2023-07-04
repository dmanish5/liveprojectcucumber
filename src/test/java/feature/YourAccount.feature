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
Feature: Your account feature

  @tag1
  Scenario: Checking functionality of Your account feature
    Given User must be an existing customer and signed in url "https://www.amazon.ca/"
    When  Customer can mouse hover or click "Hello,sign in Accounts & Lists" with <email> and <password>
    And Verify hello message "Hello, manish Account & lists" 
    Then Customer must be able to see the options from the sublist

    