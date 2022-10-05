Feature: REST api tests

  Scenario: get a random user
    Given i create a "female_user" request
    And request "female_user" has header "f_test" = "f_test"
    When i execute "female_user" request
    Then response "female_user" contains "female"
