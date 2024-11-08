package starter.stepdefinitions;

import io.cucumber.java.en.Given;
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
    @Then("Add_Benificiary {string}, {string}, {string}, {string}, {string}, Last Name {string}, Relation {string}, Phone number {string}, {string}, and Address {string}")
    public void add_benificiary(String SelfOrBuss, String BankName, String Branchcode, String Accountnumber, String FirstName, String LastName, String Relation, String PhoneNumber, String Email, String Address) {
    IremitUSteps.Add_Benificiary(SelfOrBuss, BankName, Branchcode, Accountnumber, FirstName, LastName, Relation, PhoneNumber, Email, Address);
    }
    @Then("SendMoney {string}, {string}, {string}, {string}")
    public void sendMoney(String enterAmount, String country, String paymentType, String SelfOrOnbehalf) throws InterruptedException{
        int amount = Integer.parseInt(enterAmount);// Convert from String to int
        IremitUSteps.SendMoney(amount, country, paymentType, SelfOrOnbehalf);
    }



}