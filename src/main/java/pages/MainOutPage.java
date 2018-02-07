package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static libs.ActionsWithOurElements.*;

public class MainOutPage extends ParentPage {

    @FindBy(css = "[data-qaid='reg_element']")
    private WebElement arrowForRegistration;

    @FindBy(css = "[data-qaid='reg_as_company_btn']")
    private WebElement registrationButton;

    @FindBy(css = "[data-qaid='auth_element']")
    private WebElement loginBitton;

    public MainOutPage(WebDriver webDriver) {
        super(webDriver);
    }

    /**
     * Method opens main page of the tested web-site
     * @param text
     */
    public void openMainOutPage(String text) {
        try {
            webDriver.get((text));
            logger.info("Login page was opened");
        } catch (Exception e) {
            logger.error("Can not open url");
            Assert.fail("Can not open url ");
        }
    }

    /**
     * Method open page for Login into the application
     */
    public void selectRegistrationOption() {
        moveToTheElement(arrowForRegistration);
        clickOnElement(registrationButton);
    }

    /**
     * Method open page for Registrate process into the application
     */
    public void selectLoginOption() {
        clickOnElement(loginBitton);
    }

}
