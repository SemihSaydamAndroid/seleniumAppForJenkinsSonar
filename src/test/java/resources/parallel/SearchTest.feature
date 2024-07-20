@smoke
Feature: Search Scenarios
  Background:
    Given Go to n11 home page


  Scenario: Successfully search
    When Search the key from config
    * '20' saniye beklenir
    And Click on the search icon
    * '21' saniye beklenir
    * '23' saniye beklenir
    * '24' saniye beklenir
    * '28' saniye beklenir
    * '27' saniye beklenir
    Then Check that the current url contains the key value
    * '26' saniye beklenir
    * '25' saniye beklenir
    * '22' saniye beklenir
    Then Check that the necessary text fields are equal to the key value
    * '24' saniye beklenir
    * '23' saniye beklenir
#
#  Scenario: Unsuccessfully search
#    When Search "szymanski1907" value
#    And Click on the search icon
#    Then Check that the search not found field is displayed