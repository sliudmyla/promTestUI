package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static libs.ActionsWithOurElements.*;


public class RegistrationLoginPage extends ParentPage {

    @FindBy(css = "#join-now-tabbed-first .lp-input [type='email']")
    private WebElement emailField;

    @FindBy(css = "#join-now-tabbed-first .lp-input [type='password']")
    private WebElement passwordField;

    @FindBy(css = "#join-now-tabbed-first [type='submit']")
    private WebElement createSiteButton;

    public RegistrationLoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void enterTextInputEmail(String login) {
        enterTextIntoInput(emailField, login);
    }

    public void enterTextInputPassword(String password) {
        enterTextIntoInput(passwordField, password);
    }

    public void clickOnSubmitButton() {
        clickOnElement(createSiteButton);
    }


}
