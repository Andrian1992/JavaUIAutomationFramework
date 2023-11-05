Feature:

  @run1
  Scenario Outline: An error message is displayed when using invalid <affectedAttribute> for login flow
    Given "/index.php?route=account/login&language=en-gb" endpoint is accessed
    When the login form is populated with following details:
      | <email>    |
      | <password> |
    And the "loginBtn" from "LoginPage" is clicked
    Then the following list of error messages is displayed:
      | Warning: No match for E-Mail Address and/or Password. |
    Examples:
      | email         | password   | affectedAttribute |
      | dasd@asda.asd | asdasd123! | password          |
      | dasd@asda.asd | asdasd123! | password          |

  @Regression
  Scenario Outline: Successful login is performed with valid credentials
    Given "/index.php?route=account/login&language=en-gb" endpoint is accessed
    When the following form from "LoginPage" is populated as follow:
      | userInput     | <username> |
      | passwordInput | <password> |
    And the "loginBtn" from "LoginPage" is clicked
    Then the current url contains "account" keyword
    Examples:
      | username                  | password        |
      | stephen.kuvalis@gmail.com | i17980hpxdzpnwd |
      | myong.turner@yahoo.com    | et2r07t95c5pll  |