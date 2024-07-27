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
       loginPage.login();
    }
    @Step
    public void theUserEntersValidCredentials(String email, String pass) {
        loginPage.theUserEntersValidCredentials(email,pass);
    }

    @Step
    public void verifyHomePage() {

    }

    @Step
    public void userLogOfApplication() {
    }
}
