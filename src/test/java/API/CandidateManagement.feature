Feature: Create and Delete Candidate through API

  Scenario: Create New Candidate
    Given I am authenticated on the OrangeHRM API
    When I add a new candidate with valid details
    Then the candidate is successfully added

  Scenario: Delete an existing candidate
    Given I am authenticated on the OrangeHRM API
    When I delete the candidate with ID 123
    Then the candidate is successfully deleted