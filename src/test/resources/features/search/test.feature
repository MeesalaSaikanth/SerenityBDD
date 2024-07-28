Feature: Login

  Scenario Outline: Successful login with valid credentials
    Given the user is on the login page
    When the user enters valid credentials "<userType>""<email>","<password>" and validate the otp

    Examples:
      | email            | password  | userType   |
      |rock1@mailsac.com | Admin@123 | Business   |


