@smoke
Feature: Search Scenarios
  Background:
    * Go to n11 home page


  Scenario: Successfully search
    Given Search the key from config
    When '20' saniye beklenir
    And Click on the search icon
    And '21' saniye beklenir
    And '23' saniye beklenir
    And '24' saniye beklenir
    And '28' saniye beklenir
    And '27' saniye beklenir
    And Check that the current url contains the key value
    And '26' saniye beklenir
    And '25' saniye beklenir
    And '22' saniye beklenir
    Then Check that the necessary text fields are equal to the key value
    And '24' saniye beklenir
    And '24' saniye beklenir
    And '23' saniye beklenir
#
#  Scenario: Unsuccessfully search
#    When Search "szymanski1907" value
#    And Click on the search icon
#    Then Check that the search not found field is displayed