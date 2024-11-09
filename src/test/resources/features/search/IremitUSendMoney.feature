Feature: Login

  Scenario Outline: Successful login with valid credentials
    Given the user is on the Signin page
    When enters valid credentials "<elementType>", "<usertype>", "<email>", "<password>"
    Then OtpEntering
    And SendMoney "<enterAmount>", "<country>", "<paymentType>", "<SelectSelfOrOnbehalf>", "<BenificiaryName>", "<Paymenttype>", "<PurposeofRemittance>", "<Sourceoffunds>", "<Remarks>", "<UsernameInput>", "<PasswordInput>"
    Examples:
      | elementType | usertype | email              | password  | enterAmount | country | paymentType    | SelectSelfOrOnbehalf | BenificiaryName | Paymenttype            | PurposeofRemittance    | Sourceoffunds           | Remarks | UsernameInput | PasswordInput |
      | Email       | Ind      | saleem@mailsac.com | Agent@123 | 200         | india   | Bank Transfer  | self                 | kalam           | FPX (Internet Banking) | Bills Payment          | Allowance And Commission| Test    | Msk@1         | Msk@1         |
