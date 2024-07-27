package starter.steps;

import net.serenitybdd.annotations.Step;
import starter.pageObjects.LoginPage;

public class LoginSteps {

    LoginPage loginPage;

    @Step
    public void login() {
       loginPage.openLoginPage();
    }
    @Step
    public void theUserEntersValidCredentials(String userType,String email, String pass) throws InterruptedException {
        loginPage.enterCredentials(userType,email,pass);
        loginPage.openNewTabAndNavigateToEmail();
        String otp = loginPage.getOTP();
        loginPage.enterOTP(otp);
        loginPage.clickConfirmOTP();
    }


}
