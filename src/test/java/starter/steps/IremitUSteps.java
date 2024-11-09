package starter.steps;

import net.serenitybdd.annotations.Step;
import starter.pageObjects.IremitU;


public class IremitUSteps {
    IremitU iremitu;

    @Step
    public void Signin() {
        iremitu.Signin();
    }

    @Step
    public void EntersValidCredentials(String elementType, String usertype, String email, String pass) {
        iremitu.EntersValidCredentials(elementType, usertype, email, pass);
    }
    @Step
    public void OtpEntering()throws InterruptedException{
        iremitu.OtpEntering();
    }
    @Step
    public void OpenAllTabs()throws InterruptedException{
        iremitu.OpenAllTabs();
    }
    @Step
    public void LogOutorLogOutCancel(String LogOutorNot)throws InterruptedException{
        iremitu.LogOutorLogOutCancel(LogOutorNot);
    }
    @Step
    public void Add_Benificiary(String SelfOrBuss, String BankName, String Branchcode, String Accountnumber, String Firstname, String Lastname, String Relation, String Phonenumber,
                                String benificiaryemail, String address) {
        iremitu.Add_Benificiary(SelfOrBuss, BankName, Branchcode, Accountnumber, Firstname, Lastname,
                Relation, Phonenumber, benificiaryemail, address);
    }
    @Step
    public void SendMoney(int enteramount, String country, String paymentType, String SelfOrOnbehalf,
                          String BenificiaryName, String Paymenttype, String PurposeofRemittance, String Sourceoffunds, String Remarks, String UsernameInput, String PasswordInput) throws InterruptedException {
        iremitu.SendMoney(enteramount, country, paymentType, SelfOrOnbehalf, BenificiaryName, Paymenttype, PurposeofRemittance, Sourceoffunds, Remarks, UsernameInput, PasswordInput);
    }
}