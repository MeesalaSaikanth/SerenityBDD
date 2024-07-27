package starter.pageObjects;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import java.time.Duration;

public class LoginPage extends PageObject {

    public static @FindBy(id = "input-22") WebElementFacade userTypeField;
    public static @FindBy(id = "input-28") WebElementFacade emailField;
    public static @FindBy(id = "input-32") WebElementFacade passwordField;
    public static @FindBy(xpath = "//button[@class='btn-primary mt-3 text-capitalize v-btn v-btn--block v-btn--is-elevated v-btn--has-bg v-btn--rounded theme--light v-size--default primary']") WebElementFacade signInBtn;

    public void login() {
        getDriver().get("https://qrateonline-uat.qqpay.my/login");
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
        public void theUserEntersValidCredentials(String email, String pass) {
        $(userTypeField).sendKeys("Individual");
        $(emailField).sendKeys(email);
        $(passwordField).sendKeys(pass);
        $(signInBtn).click();
    }
}
