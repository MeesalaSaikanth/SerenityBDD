package starter.steps;

import net.serenitybdd.annotations.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import starter.pageObjects.LoginPage;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginSteps {

    private static final Logger log = LoggerFactory.getLogger(LoginSteps.class);
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
