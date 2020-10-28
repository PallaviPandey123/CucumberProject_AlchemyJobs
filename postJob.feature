@tag
Feature: Posting a job using parameterization

  @Scenario3
  Scenario: Post a job using details passed from the Feature file
    Given User goes to Alchemy Jobs page with URL "https://alchemy.hguy.co/jobs/"
    When User clicks Post A Job link
    And User adds a job with email "12346@aaa.com"
    And User enters a title "Harini6-Test Lead"
    And User enters a description "Test Expert6"
    And User enters an App email "test6@test.com"
    And User enters a company "IBM"
    And User submits the form
    Then User confirms job listing with title "Harini6-Test Lead" is shown
    And Close the browser