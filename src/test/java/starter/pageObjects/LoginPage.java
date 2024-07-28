package starter.pageObjects;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.findby.By;
import org.openqa.selenium.JavascriptExecutor;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class LoginPage extends PageObject {

    @FindBy(id = "input-22")
    WebElementFacade userTypeField;

    @FindBy(id = "input-28")
    WebElementFacade emailField;

    @FindBy(id = "input-32")
    WebElementFacade passwordField;

    @FindBy(xpath = "//button[@class='btn-primary mt-3 text-capitalize v-btn v-btn--block v-btn--is-elevated v-btn--has-bg v-btn--rounded theme--light v-size--default primary']")
    WebElementFacade signInBtn;

    @FindBy(xpath = "//*/tr[2]/td[3]")
    List<WebElementFacade> otpElements;

    @FindBy(xpath = "(//div[contains(text(),'')])[28]")
    WebElementFacade otpElement;

    @FindBy(xpath = "//span[contains(text(), 'Confirm OTP')]")
    WebElementFacade confirmOtpButton;

    @FindBy(id = "input-57--")
    WebElementFacade OtpDigit;

    public void openLoginPage() {
        getDriver().get("https://qrateonline-uat.qqpay.my/login");
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
    }

    public void enterCredentials(String userType, String email, String pass) {
        $(userTypeField).sendKeys(userType);
        $(emailField).sendKeys(email);
        $(passwordField).sendKeys(pass);
        $(signInBtn).click();
    }

    public void openNewTabAndNavigateToEmail() {
        String email = emailField.getValue(); // Fetch the email from the emailField
        ((JavascriptExecutor) getDriver()).executeScript("window.open()");
        Set<String> handles = getDriver().getWindowHandles();
        String originalWindow = getDriver().getWindowHandle();
        String newTab = handles.stream().filter(handle -> !handle.equals(originalWindow)).findFirst().get();
        getDriver().switchTo().window(newTab);
        getDriver().get("https://mailsac.com/inbox/" + email);
        Serenity.takeScreenshot();
        waitABit(5000);
        getDriver().navigate().refresh();
    }

    public String getOTP() throws InterruptedException {
        Thread.sleep(3000); // Wait for the email to load
        if (!otpElements.isEmpty()) {
            otpElements.get(0).click();
        } else {
            throw new RuntimeException("OTP element not found.");
        }
        waitABit(2000);
        String otpText = otpElement.getText();
        return otpText.replaceAll("[^0-9]", ""); // Extract OTP from text
    }

    public void enterOTP(String otp) throws InterruptedException {
        getDriver().switchTo().window(getDriver().getWindowHandles().iterator().next()); // Switch back to original tab
        Thread.sleep(2000); // Wait for the OTP input fields to be ready
        for (int i = 0; i < otp.length(); i++) {
            String otpDigit = String.valueOf(otp.charAt(i));
            $(By.xpath("//input[@id='input-57--" + i + "']")).sendKeys(otpDigit);
        }
    }

    public void clickConfirmOTP() {
        $(confirmOtpButton).click();
        waitABit(5000);
    }
}
