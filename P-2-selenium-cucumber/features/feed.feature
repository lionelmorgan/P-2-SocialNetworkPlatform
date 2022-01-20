Feature: Feed Page
  Background: Logged in to account
    Given A user is on the login page
    When A user inputs correct credentials on the login form
    Then the user will be redirect to the user's account page
    Given a user is on the account page
    When a user clicks on the feed page
    Then the user is redirected to the feed page
  Scenario: A user can see the feed page
    Given a user is on the feed page
  Scenario: A user can go to another user's account page
    Given a user is on the feed page
    When A user clicks on the username of a user
    Then The user is brought to that user's account page