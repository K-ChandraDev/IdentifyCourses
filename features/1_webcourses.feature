Feature: Searching and Filtering Web Development Courses

  Scenario: Filter Web Development Courses by Level and Language
    Given the user is on the homepage of the Coursera website
    When the user searches for web development courses
    And the user clicks the first webcourse and get the details
    And the user clicks the second webcourse and get the details

  @regression
  Scenario: Filter Web Development Courses by Level and Language
    Given the user is on the homepage of the Coursera website
    When the user searches for web development courses
    And the user clicks the first webcourse and get the details
    And the user clicks the second webcourse and get the details

  @smoke
  Scenario: Filter Web Development Courses by Level and Language
    Given the user is on the homepage of the Coursera website
    When the user searches for web development courses
