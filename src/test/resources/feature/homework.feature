# Task 1: INSTALL DOCKER
# Task 2: use randomuser.me to generate person data
# Task 3: google that person's name

Feature: person search

  Scenario: generate and search person
    Given A random person "person1" with gender "male"
    Given A random person "person2" with gender "female"
    When I load google page
    And I google for clients "person1" nationality
    Then Some search result is displayed
    When I go back
    And I google for clients "person2" nationality
    Then Some search result is displayed
