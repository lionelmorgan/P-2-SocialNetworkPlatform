Feature: Account Page
  Background: Logged in to account
    Given A user is on the login page
    When A user inputs correct credentials on the login form
    Then the user will be redirect to the user's account page
  Scenario: Update account first name
    Given a user is on the account page
    When a user inputs new first name
    Then Updated user text displays
  Scenario: Update account last name
    Given a user is on the account page
    When a user inputs new last name
    Then Updated user text displays
  Scenario: Update account with new username
    Given a user is on the account page
    When a user inputs new username
    Then Updated user text displays
  Scenario: Update account with used username
    Given a user is on the account page
    When a user inputs used username
    Then Username taken error displays
  Scenario: Update account Profile Picture
    Given a user is on the account page
    When a user inputs new Profile Picture
    Then Updated user text displays

