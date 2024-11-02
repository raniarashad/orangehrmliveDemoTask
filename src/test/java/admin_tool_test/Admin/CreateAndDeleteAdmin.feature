Feature: Adding new admin user

  Scenario Outline: Try to add new admin user
    Given Admin Sign in to website
    When Click on Admin tab on the left side menu
    Then Get the number of records found
    And Click on add button
    And Fill the required data "<EmployeeName>","<Username>","<Pass>","<ConfirmPass>",
    And Click on save button
    Then Verify that the number of records increased by one
    And Search with the username for the new user "<Username>"
    And Delete the new user "<Username>"
    And Click on Rest button to reset the search result
    Then Verify that the number of records decreased by one
    Examples:
      | EmployeeName   | Username       | Pass     | ConfirmPass |  |
      | Sara  Tencrady | employee.test3 | admin123 | admin123    |  |
