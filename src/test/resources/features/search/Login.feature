Feature: Login

  Scenario Outline: Successful login with valid credentials
    Given the user is on the login page
    When the user enters valid credentials "<userType>" "<email>" "<password>" and validates the OTP

    Examples:
      | userType    | email            | password  |
      | Individual  | rock2@mailsac.com| Admin@123 |
