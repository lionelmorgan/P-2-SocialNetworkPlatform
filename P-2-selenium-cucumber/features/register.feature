Feature: Register Page
  Scenario: Entering unused credentials will redirected user to the login page
    Given a user is on the register page
    When a user inputs unused credentials
    Then a user is redirected to the login page
  Scenario: entering used credentials will display an error message
    Given a user is on the register page
    When a user inputs used credentials
    Then an error message will be displayed