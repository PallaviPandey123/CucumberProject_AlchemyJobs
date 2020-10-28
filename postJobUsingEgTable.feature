@Scenario4
Feature: Using Examples table to post a job

 @Tag
  Scenario Outline: Rewrite activity 3 using a Scenario Outline and Examples table to post a job
    Given User goes to Alchemy Jobs page with URL "https://alchemy.hguy.co/jobs/"
    When User clicks Post A Job link 
    And User adds a job with email "<email>"
    And User enters a title "<title>"
    And User enters a description "<description>"
    And User enters an App email "<App email>"
    And User enters a company "<company>"
    And User submits the form
    Then User confirms job listing with title "<title>" is shown
    And Close the browser

    Examples: 
      | email  | title | description  | App email  | company  |
      | 12343@aaa.com | H3-Lead | Test Expert3 | test3@test.com | IBM  |
      | 12344@aaa.com | H4-Lead | Test Expert4 | test4@test.com | IBM  |
