Feature: To test the login functionality of the opencart application

  Background: 
    Given user should have access to opencart application

  @Login
  Scenario: Check whether the user able to login with valid credentials
    When user enters the username and password
    And user clicks on the login button
    Then user redirects to the opencart homepage

