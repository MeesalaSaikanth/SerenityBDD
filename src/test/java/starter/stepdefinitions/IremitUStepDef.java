package starter.stepdefinitions;

import io.cucumber.java.en.*;
import net.serenitybdd.annotations.Steps;
import starter.steps.IremitUSteps;

public class IremitUStepDef {

    @Steps
    IremitUSteps IremitUSteps;

    @Given("the user is on the Signin page")
    public void theUserIsOnTheSigninPage() {
        IremitUSteps.Signin();
    }


    @When("enters valid credentials {string}, {string}, {string}, {string}")
    public void EntersValidCredentials(String arg0, String arg1, String arg2, String arg3) {
        IremitUSteps.EntersValidCredentials(arg0, arg1, arg2, arg3);
    }

    @Then("OtpEntering")
    public void OtpEntering()throws InterruptedException{
        IremitUSteps.OtpEntering();
    }
    @Then("OpenAllTabs")
    public void OpenAllTabs()throws InterruptedException{
        IremitUSteps.OpenAllTabs();
    }
    @Then("LogOutorLogOutCancel {string}")
    public void LogOutorLogOutCancel(String LogOutorNot)throws InterruptedException{
        IremitUSteps.LogOutorLogOutCancel(LogOutorNot);
    }
    @Then("Add_Benificiary {string}, {string}, {string}, {string}, {string}, Last Name {string}, Relation {string}, Phone number {string}, {string}, and Address {string}")
    public void add_benificiary(String SelfOrBuss, String BankName, String Branchcode, String Accountnumber, String FirstName, String LastName, String Relation, String PhoneNumber, String Email, String Address) {
    IremitUSteps.Add_Benificiary(SelfOrBuss, BankName, Branchcode, Accountnumber, FirstName, LastName, Relation, PhoneNumber, Email, Address);
    }
    @And("SendMoney {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void sendMoney(String enteramount, String country, String paymentType, String SelfOrOnbehalf, String BenificiaryName, String Paymenttype, String PurposeofRemittance, String Sourceoffunds, String Remarks, String UsernameInput, String PasswordInput) throws InterruptedException {
    // Convert the entered amount to an integer
        int amount = Integer.parseInt(enteramount);
    IremitUSteps.SendMoney(amount, country, paymentType, SelfOrOnbehalf, BenificiaryName, Paymenttype, PurposeofRemittance, Sourceoffunds, Remarks, UsernameInput, PasswordInput);
    }
}