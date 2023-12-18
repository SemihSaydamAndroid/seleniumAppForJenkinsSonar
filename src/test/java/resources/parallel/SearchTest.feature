@Search
Feature: Search Scenarios
  Background:
    Given Go to n11 home page


  Scenario: Successfully search
    When Search the key from config
    And Click on the search icon
    Then Check that the current url contains the key value
    Then Check that the necessary text fields are equal to the key value
#
#  Scenario: Unsuccessfully search
#    When Search "szymanski1907" value
#    And Click on the search icon
#    Then Check that the search not found field is displayed