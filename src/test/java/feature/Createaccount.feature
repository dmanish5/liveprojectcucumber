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
Feature: Create account testing

  @tag1
  Scenario: Checking funtionality for create account page
    Given User should be on the main page of amazon url "https://www.amazon.ca/" and mouse hover on Hello,sign in Accounts & Lists
    When Click on Start here customer should navigate to Create account page of amazon
    And Enter Yourname,Mobilenumberoremail,Password,Passwordagain
    And Click on continue button
    Then If account already exist, one must get message as Are you returning customer else one must get verification OTP on his/her email id after entering OTP, one must create an account

   