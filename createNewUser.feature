@tag
Feature: Create a New User

  @Scenario1
  Scenario: Visit the site’s backend and create a new user
    Given User is on login page with url "https://alchemy.hguy.co/jobs/wp-admin"
    When User logs in with "root" and "pa$$w0rd"
    Then User is successfully logged in
    When User clicks Users option from the left hand menu
    And User clicks Add New User button
    And User creates new User "Harinitest4", "aaaa4@aaa.com", "pa$$w0rd!"
    Then Verify if user "Harinitest4" with email "aaaa4@aaa.com" was added
    And Close the browser