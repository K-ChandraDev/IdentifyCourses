Feature: Searching Language Learning and extracting details

  Scenario: Extract and display language and level information
    Given the user is on the homepage
    When the user searches for language learning courses
    And they extract all available languages and their total counts
    And they extract all different levels and their total counts

  @smoke
  Scenario: Extract and display language and level information
    Given the user is on the homepage
    When the user searches for language learning courses
