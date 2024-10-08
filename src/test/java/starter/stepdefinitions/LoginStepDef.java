package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.steps.LoginSteps;

public class LoginStepDef {

    @Steps
    LoginSteps loginSteps;

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        loginSteps.login();
    }


    @When("the user enters valid credentials {string}{string},{string} and validate the otp")
    public void theUserEntersValidCredentialsAndValidateTheOtp(String arg0, String arg1, String arg2) throws InterruptedException {
        loginSteps.theUserEntersValidCredentials(arg0,arg1,arg2);
    }
}
