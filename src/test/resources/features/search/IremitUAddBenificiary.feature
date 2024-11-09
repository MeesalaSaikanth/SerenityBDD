Feature: Login

Scenario Outline: Successful login with valid credentials
Given the user is on the Signin page
When enters valid credentials "<elementType>", "<usertype>", "<email>", "<password>"
Then OtpEntering
Then Add_Benificiary "<SelfOrBuss>", "<BankName>", "<Accountnumbers>", "<Branchcode>", "<FirstName>", Last Name "<LastName>", Relation "<Relation>", Phone number "<PhoneNumber>", "<benificiaryemail>", and Address "<Address>"

Examples:
| elementType | usertype | email              | password  | SelfOrBuss | BankName     | Branchcode  | Accountnumbers   | FirstName | LastName | Relation | PhoneNumber |benificiaryemail               | Address              |
| Email       | Ind      | saleem@mailsac.com | Agent@123 | Personal   | Axis Bank    | Axis123456  | 57656123456      | Kula      | B        | Self     | 1234567758  | Axis1234567@mailsac.com       | Axisbank side        |
