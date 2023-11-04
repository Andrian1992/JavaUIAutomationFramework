Feature: Register Flow Test Suite

  Background:
    Given "/index.php?route=account/register&language=en-gb" endpoint is accessed

  Scenario: Register page can be accessed from the Home page
    Given HomePage is displayed
    When registerLink from Header menu is clicked
    Then the current url contains "route=account/register" keyword

  Scenario: The Account Page URL is opened when the registration is successful
    When the register form is populated with valid random data
    And the "continueBtn" from "RegisterPage" is clicked
    Then the current url contains "route=account/register" keyword

  Scenario: User remains on registerPage when the continue button is not clicked
    When the register form is populated with valid random data
    Then the current url contains "route=account/register" keyword

  @run
  Scenario Outline: An error message is displayed when invalid <impacted attribute> is used for register flow
    Given "/index.php?route=account/register&language=en-gb" endpoint is accessed
    And the register form is populated with the following data:
      | firstName | <firstName>    |
      | lastName  | <lastName>     |
      | email     | <emailData>    |
      | password  | <passwordData> |
    And the "continueBtn" from "RegisterPage" is clicked
    Then the following list of error messages is displayed:
      | <impacted attribute> must be between 1 and 32 characters! |
    Examples:
      | impacted attribute | firstName                             | lastName         | emailData | passwordData |
      | First Name         | sdfsdfsdfsdfs654sd6f54s6asdasdasdd5f4 | Random           | RandomEmail    | Random       |
      | Last Name          | Andrei                                | asdafsdsdgsdgsdg | RandomEmail    | Random       |
