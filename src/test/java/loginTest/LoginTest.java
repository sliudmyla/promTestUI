package loginTest;

import org.junit.Assert;
import org.junit.Test;
import parentTest.ParentTest;

public class LoginTest extends ParentTest {

    @Test

    public void LoginWithCorrectData() {
        mainOutPage.openMainOutPage("https://my.prom.ua/");
        mainOutPage.selectLoginOption();
        loginPage.enterLoginName("x2982381@mvrht.net");
        loginPage.enterPassName("test");
        loginPage.clickOnSubmitButoon();

        oldCabinetPage.checkMyCabinetIcon();
        oldCabinetPage.goToTheNewCabinet();

        Assert.assertTrue("Logo is invisible", newCabinetPage.isPresentLogoNewCabinet());
    }

    @Test
    public void LoginWithInvalidLogin() {
        mainOutPage.openMainOutPage("https://my.prom.ua/");
        mainOutPage.selectLoginOption();
        loginPage.enterLoginName("x2982381@mvrht.net");
        loginPage.enterPassName("56789034");
        loginPage.clickOnSubmitButoon();

        Assert.assertTrue("No validation Message", loginPage.isValidateMessagePresent());

    }

    @Test
    public void LoginWithInvalidPassword() {
        mainOutPage.openMainOutPage("https://my.prom.ua/");
        mainOutPage.selectLoginOption();
        loginPage.enterLoginName("test01@testing.com");
        loginPage.enterPassName("test");
        loginPage.clickOnSubmitButoon();

        Assert.assertTrue("No validation Message", loginPage.isValidateMessagePresent());

    }

    @Test
    public void LoginWithEmptyFields() {
        mainOutPage.openMainOutPage("https://my.prom.ua/");
        mainOutPage.selectLoginOption();
        loginPage.clickOnEmptyFields();
        loginPage.clickOnSubmitButoon();

        Assert.assertTrue("No empty validation Messages", loginPage.isEmptyMessagesPresent());

    }
}
