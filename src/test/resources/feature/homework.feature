# Task 1: INSTALL DOCKER
# Task 2: use randomuser.me to generate person data
# Task 3: google that person's name

Feature: person search

  Scenario: generate and search person
    Given A random person "person1" with gender "male"
    Given A random person "person2" with gender "female"
    Given save random user "person1" to DB
    Given save random user "person2" to DB
