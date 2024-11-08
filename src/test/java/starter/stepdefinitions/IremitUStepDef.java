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
    @Then("SendMoney {string}, {string}, {string}, {string}")
    public void sendMoney(String enterAmount, String country, String paymentType, String SelfOrOnbehalf) throws InterruptedException{
    // Convert the enterAmount to an integer
    int amount = Integer.parseInt(enterAmount); // Convert from String to int
    IremitUSteps.SendMoney(amount, country, paymentType, SelfOrOnbehalf);
    }
    @Then("Add_Benificiary {string}, {string}, {string}, {string}")
    public void Add_Benificiary(String SelfOrBuss, String BankName, String Accountnumber, String Branchcode) throws InterruptedException{
        int Accountnumbers = Integer.parseInt(Accountnumber);
        IremitUSteps.Add_Benificiary(SelfOrBuss, BankName, Accountnumbers, Branchcode);
    }
}