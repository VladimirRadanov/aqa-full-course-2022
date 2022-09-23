Feature: REST api tests

  Scenario: get a random user
    Given an Http client "apache client"
    When i create a "female_user" request
    When i create a "male_user" request
    When request "male_user" has header "test" = "test"
    When request "female_user" has header "f_test" = "f_test"
    When i execute "female_user" request with "apache client" as "female_response"
    When i execute "male_user" request with "apache client" as "male_response"
    Then response "female_response" contains "female"
    Then response "male_response" contains "female"
