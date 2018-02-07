package registrationTest;

import org.junit.Assert;
import org.junit.Test;
import parentTest.ParentTest;


public class RegistrationTest extends ParentTest {


    @Test //этот тест может быть запущен отдельно, с него можно начать метод

    public void validLoginRegistration() {

        String fakeNameF, fakeNameL, fakeCompany, fakeEmail;
        fakeNamePage.openFakeNamePage();
        fakeCompany = fakeNamePage.getCompany();
        fakeEmail = fakeNamePage.getEmail();

        mainOutPage.openMainOutPage("https://prom.ua");
        mainOutPage.selectRegistrationOption();

        registrationLoginPage.enterTextInputEmail(fakeEmail);
        registrationLoginPage.enterTextInputPassword(fakeCompany);
        registrationLoginPage.clickOnSubmitButton();

        validationPage.enterPhoneNumber();
        validationPage.enterCompanyName(fakeCompany);
        validationPage.selectTheServiceOfCompany();
        validationPage.checkAddedElement();
        validationPage.ClickFinishButton();

        Assert.assertTrue("My cabinet is not visible", oldCabinetPage.checkMyCabinetIcon());
    }
}
