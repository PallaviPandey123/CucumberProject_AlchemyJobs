@tag
Feature: Searching for jobs using XPath

  @Scenario2
  Scenario: Searching for jobs and applying to them using XPath
    Given User is on Alchemy Jobs page with URL "https://alchemy.hguy.co/jobs/"
    When User clicks Jobs link
    And User types in keywords to search for jobs
    And User filters job type to show only "Full Time" jobs
    And User finds a job to see the details
    Then User is taken to the Job Details page
    And User is allowed to apply for the job
    And Close the browser