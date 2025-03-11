@smoke @ignore
Feature: Search Scenarios
  Background:
    * Go to n11 home page


  Scenario: Successfully search
    Given Search the key from config
    When '20' saniye beklenir
    And Click on the search icon
    And Check that the current url contains the key value
    Then Check that the necessary text fields are equal to the key value

  @ignore
  Scenario: Successfully search
    Given Search the key from config
    When '20' saniye beklenir
    And Click on the search icon
    And Check that the current url contains the key value
    Then Check that the necessary text fields are equal to the key value
