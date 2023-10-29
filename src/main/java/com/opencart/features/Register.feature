Feature: Register Flow Test Suite

  Scenario: Register page can be accessed from the Home page
    Given HomePage is displayed
    When registerLink from Header menu is clicked
    Then the current url contains "route=account/register" keyword

  Scenario: The Account Page URL is opened when the registration is successful
    Given "/index.php?route=account/register&language=en-gb" endpoint is accessed
    When the register form is populated with valid random data
    And Continue button is clicked
    Then the current url contains "route=account/success" keyword

  Scenario: User remains on registerPage when the continue button is not clicked
    Given "index.php?route=account/register&language=en-gb" endpoint is accessed
    When the register form is populated with valid random data
    Then the current url contains "route=account/register" keyword