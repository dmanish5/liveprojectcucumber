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
Feature: Search Bar feature

  @tag1
  Scenario Outline: Checking functionality of Search bar feature
    Given User must be on the url "https://www.amazon.ca/"
    When User has the ability to <search> and should be navigated to the Search results page
    And User Should be allowed to click on next page
    And User Must be allowed to Filter item
    And User must have four to five options to select and you can sort by one parameter only.
    And Sorting and Filtering together
    And Sorting,Filtering and Pagination together
    Then User Should get Relevant Product,Product information,check that by default 60 products per page
    And Check Sorting,Filtering and Pagination

    

    
