package starter.steps;

import net.serenitybdd.annotations.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import starter.pageObjects.IremitU;

import static org.assertj.core.api.Assertions.assertThat;

public class IremitUSteps {
    private static final Logger log = LoggerFactory.getLogger(IremitUSteps.class);
    IremitU iremitu;

    @Step
    public void Signin() {
        iremitu.Signin();
    }

    @Step
    public void EntersValidCredentials(String elementType, String usertype, String email, String pass) {
        iremitu.EntersValidCredentials(elementType, usertype, email, pass);
    }
    @Step
    public void OtpEntering()throws InterruptedException{
        iremitu.OtpEntering();
    }
    @Step
    public void Add_Benificiary(String SelfOrBuss, String BankName, String Branchcode, String Accountnumber, String Firstname, String Lastname, String Relation, String Phonenumber,
                                String benificiaryemail, String address) {
        iremitu.Add_Benificiary(SelfOrBuss, BankName, Branchcode, Accountnumber, Firstname, Lastname,
                Relation, Phonenumber, benificiaryemail, address);
    }
    @Step
    public void SendMoney(int enterAmount, String country, String paymentType, String SelfOrOnbehalf)throws InterruptedException{
        iremitu.SendMoney (enterAmount, country, paymentType, SelfOrOnbehalf);
    }
    @Step
    public void verifyHomePage() {

    }

    @Step
    public void userLogOfApplication() {
    }
}