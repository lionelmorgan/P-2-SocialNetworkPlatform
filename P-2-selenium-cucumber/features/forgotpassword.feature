Feature: Login and Forgot Password Page
  Scenario: Clicking the Forgot Password Link will take user to the forgot password page
    Given A user is on the login page
    When A user clicks the forgot password link
    Then user will be redirected to the forgot password page
  Scenario: Clicking the Send button will send the user an email with a temporary password
    Given A user is on the forgot password page
    When A user enters an existing email
    Then user clicks send and will be sent a temporary password