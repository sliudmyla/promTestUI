package pages;

import javafx.scene.Parent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static libs.ActionsWithOurElements.*;

public class LoginPage extends ParentPage {

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(css = "[data-qaid='phone-email-input-field']")
    private WebElement inputForLoginName;

    @FindBy(css = "[data-qaid='password-input-field']")
    private WebElement inputForPassName;

    @FindBy(id = "submit_login_button")
    private WebElement loginButton;

    @FindBy(css = "[data-qaid='password-validation-error'] .b-input-error__body")
    private WebElement validateMessagePass;

    @FindBy(css = "[data-qaid='phone-email-validation-error'] .b-input-error__body")
    private WebElement emptyEmailMessage;

    @FindBy(css = "[data-qaid='password-validation-error'] .b-input-error__body")
    private WebElement emptyPassMessage;

    public void enterLoginName(String login) {
        enterTextIntoInput(inputForLoginName, login);
    }

    public void enterPassName(String pass) {
        enterTextIntoInput(inputForPassName, pass);
    }

    public void clickOnSubmitButoon() {
        clickOnElement(loginButton);
    }

    /**
     * Method check the validated message, which should appears when user
     * enter incorrect Login of Password
     * @return
     */
    public boolean isValidateMessagePresent() {
        webDriverWait20.until(ExpectedConditions.visibilityOf(validateMessagePass));
        return validateMessagePass.getText()
                .equals("Неправильный номер телефона/email или пароль. Для осуществления входа при помощи номера телефона, он должен быть привязан к учетной записи в кабинете пользователя.");
    }

    public void clickOnEmptyFields() {
        clickOnElement(inputForLoginName);
        clickOnElement(inputForPassName);
    }

    /**
     * Method check the validated message, which should appears when user
     * try to login without entering any data
     * @return
     */
    public boolean isEmptyMessagesPresent() {
        webDriverWait20.until(ExpectedConditions.visibilityOf(emptyEmailMessage));
        webDriverWait20.until(ExpectedConditions.visibilityOf(emptyPassMessage));
        boolean tempEmail = emptyEmailMessage.getText().equals("Это обязательное поле.");
        boolean tempPass = emptyPassMessage.getText().equals("Это обязательное поле.");
        return tempEmail && tempPass;
    }

}
