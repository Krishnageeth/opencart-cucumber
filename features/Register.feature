Feature: To test the Register functionality of the application

  Background: 
    Given user should have access to opencart application

  @RegisterAccount
  Scenario Outline: Check whether the user able to register with valid details
    When user enters the "<firstname>", "<lastname>", "<email>" ,and "<password>"
    And user agrees the privacy policy
    And user clicks on contine button
    Then user verifies the registered account

    Examples: 
      | firstname | lastname | email                    | password |
      | Krishna   | Geeth    | krishnageeth18@gmail.com | xyz900@  |
