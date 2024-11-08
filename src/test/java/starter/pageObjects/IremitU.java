package starter.pageObjects;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class IremitU extends PageObject {
    private String email;
    private String paymentType;
    @FindBy(xpath = "(//i[@aria-hidden='true' and contains(@class, 'mdi')])[7]")
    private WebElementFacade mobileIconField;

    @FindBy(xpath = "(//i[@aria-hidden='true' and contains(@class, 'mdi')])[6]")
    private WebElementFacade emailIconField;

    @FindBy(xpath = "(//div[@class=\"v-input--selection-controls__input\"]//following-sibling::div)[2]")
    public WebElementFacade userTypeField;

    @FindBy(xpath="//span[contains(text(), 'Confirm OTP')]")
    public WebElementFacade ConfirmOTP;

    @FindBy(xpath="(//i[contains(@class, 'mdi-arrow-right')])")
    public WebElementFacade arrow;

    @FindBy(id = "input-55")
    public WebElementFacade emailField;

    @FindBy(id = "input-69")
    public WebElementFacade passwordField;

    @FindBy(xpath = "//button[span[text()='Sign In']]")
    public WebElementFacade signInBtn;

    @FindBy(xpath = "//a[@href='/beneficiarysummary' and contains(@class, 'v-btn--outlined') and .//span[text()='view More']]")
    public WebElementFacade BeneficiaryClick;

    @FindBy(xpath = "//button[@type='button' and contains(@class, 'v-btn--has-bg') and .//span[text()=' Add Beneficiary ']]")
    public WebElementFacade AddBeneficiary;

    @FindBy(xpath = "//p[contains(@class, 'bg-primary-col') and text()=' Personal ']")
    public WebElementFacade PersonalField;

    @FindBy(xpath = "//p[contains(@class, 'bg-secondary') and text()=' Business ']")
    public WebElementFacade BusinessField;

    @FindBy(xpath = "//span[@class='v-btn__content' and text()=' Next '][1]")
    public WebElementFacade NextBtn1;

    @FindBy(xpath = "//input[@placeholder='Bank Name']")
    public WebElementFacade SelectBank;

    @FindBy(xpath = "//input[@placeholder='Branch Code']")
    public WebElementFacade BranchCode;

    @FindBy(xpath = "//input[@placeholder='Account Number']")
    public WebElementFacade AccountNumber;

    @FindBy(xpath = "/html/body/div/div[1]/div[1]/div/main/div/div/div[2]/div/div[2]/div/div[2]/div/div[2]/div[3]/div[6]/button[2]")
    public WebElementFacade NextBtn2;

    @FindBy(xpath = "//input[@placeholder='First Name']")
    public WebElementFacade FirstName;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    public WebElementFacade LastName;

    @FindBy(xpath = "//input[@placeholder='Select Relation']")
    public WebElementFacade RelationField;

    @FindBy(xpath = "//input[@class='input-tel__input']")
    public WebElementFacade PhoneNumber;

    @FindBy(xpath = "//input[@placeholder='E-mail']")
    public WebElementFacade Email;

    @FindBy(xpath = "//input[@placeholder='Enter Address']")
    public WebElementFacade Address;
//
    @FindBy(xpath = "/html/body/div/div[1]/div[1]/div/main/div/div/div[2]/div/div[2]/div/div[3]/div/div[2]/div/div[8]/button[2]/span")
    public WebElementFacade NextBtn3;

    @FindBy(xpath = "//div[text()='Submit']")
    public WebElementFacade SubmitBtn;

    @FindBy(xpath = "//li[contains(text(), 'Send Money')]")
    public WebElementFacade SendMoney;

    @FindBy(xpath= "//input[@id=\"sendAmount\"]")
    public WebElementFacade enteramountField;

    @FindBy(xpath= "//input[@id=\"PaymentMode\"]")
    public WebElementFacade PaymentModeField;

    @FindBy(xpath= "//input[@placeholder='Search country']")
    public WebElementFacade countryField;

    @FindBy(xpath = "//div[@class='v-list-item__title' and normalize-space(text())='Bank Transfer']")
    public WebElementFacade BankTransferField;

    @FindBy(xpath = "//div[@class='v-list-item__title' and normalize-space(text())='Cash Pay']")
    public WebElementFacade CashPayField;

    @FindBy(xpath = "//div[@class='v-list-item__title' and normalize-space(text())='Ewallet']")
    public WebElementFacade EwalletField;

    @FindBy(xpath= "//button/span[text()=' Send Money ']")
    public WebElementFacade SendMoneyButton;

    @FindBy(xpath= "//p[@class='label-text text-h6 mb-0 p-2 bg-secondary' and text()='On Behalf Of']")
    public WebElementFacade SelfOrOnbehalfField;

    @FindBy(xpath= "//button/span[text()=' Next ']")
    public WebElementFacade NextButton;

    public void Signin(){
        getDriver().get("https://online.remitrise.com/login");
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    public void EntersValidCredentials(String elementType, String usertype, String email, String pass) {
        this.email = email;
        if (elementType.equals("Mobile")) {
            $(mobileIconField).click();
        } else {
            $(emailIconField).click();
        }
        if (usertype.equals("Bus")) {
            $(mobileIconField).click();
        }

        $(emailField).sendKeys(email);
        $(arrow).click();
        $(passwordField).sendKeys(pass);
        $(signInBtn).click();
    }

    public void OtpEntering() throws InterruptedException {
        WebDriver driver = getDriver();
        ((JavascriptExecutor) driver).executeScript("window.open()");
        Set<String> handles = driver.getWindowHandles();
        String originalWindow = driver.getWindowHandle();
        String newTab = handles.stream().filter(handle -> !handle.equals(originalWindow)).findFirst().get();
        driver.switchTo().window(newTab);
        driver.get("https://mailsac.com/inbox/" +this.email);
        Thread.sleep(5000);
        driver.navigate().refresh();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> otpElements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*/tr[2]/td[3]")));
        if (!otpElements.isEmpty()) {
            otpElements.get(0).click();
        }

        WebElement otpElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(text(),'')])[28]")));
        String otpText = otpElement.getText();
        String otp = otpText.replaceAll("[^0-9]", "");

        driver.switchTo().window(originalWindow);

        for (int i = 0; i < otp.length(); i++) {
            String otpDigit = String.valueOf(otp.charAt(i));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-104--" + i))).sendKeys(otpDigit);
        }
        $(ConfirmOTP).click();
        Thread.sleep(2000);
    }
    public void SendMoney(int enteramount, String country, String paymentType, String SelfOrOnbehalf)throws InterruptedException {
        $(SendMoney).click();
        $(enteramountField).sendKeys("10000");
        Thread.sleep(2000);
        $(enteramountField).sendKeys(String.valueOf(enteramount));
        $(PaymentModeField).click();
        $(countryField).sendKeys(country);
        this.paymentType =paymentType;
        if (paymentType.equals("Bank Transfer")) {
            $(BankTransferField).click();
        } else if(paymentType.equals("Cash Pay")){
            $(CashPayField).click();
        } else if(paymentType.equals("Ewallet")){
            $(EwalletField).click();
        } else {
            System.out.println("Invalid payment type: " + paymentType);
        }
        $(SendMoneyButton).click();
        if (SelfOrOnbehalf.equals("Onbehalf")) {
            $(SelfOrOnbehalfField).click();
        }
        Thread.sleep(3000);
        $(NextButton).click();
        Thread.sleep(1000);
    }
    private String bankName;
    private String RelationOption;
    public void Add_Benificiary(String SelfOrBuss, String BankName, String Branchcode, String Accountnumber, String Firstname, String Lastname, String Relation, String Phonenumber, String benificiaryemail, String address) {
        this.RelationOption=Relation;
        this.bankName=BankName;
        $(BeneficiaryClick).click();
        $(AddBeneficiary).click();

        // Select Personal or Business
        if (SelfOrBuss.equals("Personal")) {
            $(PersonalField).click();
        } else {
            $(BusinessField).click();
        }
        $(NextBtn1).click();
       (SelectBank).click();
        $(By.xpath("//div[@class='v-list-item__title' and text()='"+ bankName + "']")).click();
        $(AccountNumber).sendKeys(Accountnumber);
        $(BranchCode).sendKeys(Branchcode);
        $(NextBtn2).click();
        $(FirstName).sendKeys(Firstname);
        $(LastName).sendKeys(Lastname);
        $(RelationField).click();
        $(By.xpath("//div[@class='v-list-item__title' and contains(.,'"+Relation+"')]")).click();
        $(PhoneNumber).sendKeys(Phonenumber);
        $(Email).sendKeys(benificiaryemail);
        $(Address).sendKeys(address);
        $(NextBtn3).click();
        $(SubmitBtn).click();
    }

}
