@Login
Feature: Login Scenarios
  Background:
    * Go to n11 login page

  Scenario: Successfully Login
    * Username is entered from config
    * Password is entered from config
    * Clicking on sign in button
    * Check that logged in successfully

#  Scenario: Empty Password
#    When Username is entered from config
#    And "" value is entered in password field
#    And Clicking on sign in button
#    Then Check that empty password error
#
#  Scenario: Max Character Email
#    When Username is entered from config
#    And "pointrtestn11com" value is entered in password field
#    And Clicking on sign in button
#    Then Check that max character password error
#
#  Scenario: Min Character Email
#    When Username is entered from config
#    And "test" value is entered in password field
#    And Clicking on sign in button
#    Then Check that min character password error
#
#  Scenario: Wrong Password
#    When Username is entered from config
#    And "Szymanski1905" value is entered in password field
#    And Clicking on sign in button
#    Then Check that wrong email or password error
#
#  Scenario: Empty Email
#    When "" value is entered in username field
#    And Password is entered from config
#    And Clicking on sign in button
#    Then Check that empty email error
#
#  Scenario: Wrong Email
#    When "denem@test.com" value is entered in username field
#    And Password is entered from config
#    And Clicking on sign in button
#    Then Check that wrong email or password error
#
#  Scenario: Invalid Email
#    When "invalid" value is entered in username field
#    And Password is entered from config
#    And Clicking on sign in button
#    Then Check that invalid email error