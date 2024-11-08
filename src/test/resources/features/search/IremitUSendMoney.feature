Feature: Login

  Scenario Outline: Successful login with valid credentials
    Given the user is on the Signin page
    When enters valid credentials "<elementType>", "<usertype>", "<email>", "<password>"
    Then OtpEntering
    Then SendMoney "<enterAmount>", "<country>", "<paymentType>", "<SelectSelfOrOnbehalf>"
    Examples:
      | elementType | usertype | email              | password  | enterAmount | country | paymentType    |SelectSelfOrOnbehalf|
      | Email       | Ind      | saleem@mailsac.com | Agent@123 | 200         | india   | Bank Transfer  |self                |
