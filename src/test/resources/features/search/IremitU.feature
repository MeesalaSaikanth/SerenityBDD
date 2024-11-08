Feature: Login

#  Scenario Outline: Successful login with valid credentials
#    Given the user is on the Signin page
#    When enters valid credentials "<elementType>", "<usertype>", "<email>", "<password>"
#    Then OtpEntering
#
#    Examples:
#      | elementType | usertype | email                | password  |
#      | Email       | Ind      | saleem@mailsac.com   | Agent@123 |

#  Scenario Outline: Successful login with valid credentials
#    Given the user is on the Signin page
#    When enters valid credentials "<elementType>", "<usertype>", "<email>", "<password>"
#    Then OtpEntering
#    Then SendMoney"<enteramount>","<country>","<PaymentType>"
#
#    Examples:
#      | elementType | usertype | email                | password   |enteramount |country  |PaymentType  |
#      | Email       | Ind      | ashok@mailsac.com    | Agent@123  |200         |india    |Bank Transfer|
  Scenario Outline: Successful login with valid credentials
    Given the user is on the Signin page
    When enters valid credentials "<elementType>", "<usertype>", "<email>", "<password>"
    Then OtpEntering
   # Then SendMoney "<enterAmount>", "<country>", "<paymentType>", "<SelectSelfOrOnbehalf>"
    Then Add_Benificiary "<SelfOrBuss>", "<BankName>", "<Accountnumbers>", "<Branchcode>"

    Examples:
      | elementType | usertype | email              | password  | SelfOrBuss  | BankName     | Accountnumbers    |Branchcode   || enterAmount | country | paymentType    |SelectSelfOrOnbehalf|
      | Email       | Ind      | saleem@mailsac.com | Agent@123 | Personal    | Axis Bank    | 1234567890        |Axis1234567  || 200         | india   | Bank Transfer  |self                |
