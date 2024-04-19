Feature: Error Handling in Form Submission

  Scenario: Fill Form with invalid input and capture error message
    Given the user nagivate to Coursera page
    When the user navigates to the Enterprise section
    And the user fills the Form with invalid email
    Then the user should capture and display the error message

  @smoke
  Scenario: Fill Form with invalid input and capture error message
    Given the user nagivate to Coursera page
    When the user navigates to the Enterprise section
