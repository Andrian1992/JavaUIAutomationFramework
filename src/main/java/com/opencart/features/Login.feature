Feature:

  @run1
  Scenario Outline: An error message is displayed when using invalid <affectedAttribute> for login flow
    Given "/index.php?route=account/login&language=en-gb" endpoint is accessed
    When the login form is populated with following details:
      | <email>    |
      | <password> |
    And the login button is clicked (nu este definit)!!
    Then the following list of error messages is displayed:
      | Warning: No match for E-Mail Address and/or Password. |
    Examples:
      | email         | password   |affectedAttribute|
      | dasd@asda.asd | asdasd123! |password|
      | dasd@asda.asd | asdasd123! |password|

