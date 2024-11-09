Feature: Login

  Scenario Outline: Successful login with valid credentials
    Given the user is on the Signin page
    When enters valid credentials "<elementType>", "<usertype>", "<email>", "<password>"
    Then OtpEntering
    Then OpenAllTabs
    Then LogOutorLogOutCancel "<LogOutorNot>"

    Examples:
      | elementType | usertype | email                | password  |LogOutorNot|
      | Email       | Ind      | saleem@mailsac.com   | Agent@123 |No         |
