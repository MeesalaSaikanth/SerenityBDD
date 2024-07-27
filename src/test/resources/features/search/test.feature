Feature: Login

  Scenario Outline: Successful login with valid credentials
    Given the user is on the login page
    When the user enters valid credentials "<email>","<password>"
    Examples:
      | email            | password  |
      |rock2@mailsac.com | Admin@123 |