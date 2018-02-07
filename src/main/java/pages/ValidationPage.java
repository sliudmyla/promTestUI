package pages;


        import org.junit.Assert;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.support.FindBy;

        import static libs.ActionsWithOurElements.*;

public class ValidationPage extends ParentPage{

    @FindBy (css = "[data-qaid='phone']")
    private WebElement phoneNumbeField;

    @FindBy (css = "[data-qaid='name']")
    private WebElement companyNameField;

    @FindBy (css = "[data-qaid='dd_checklist']")
    private WebElement dropDownmain;

    @FindBy (css = ".b-drop-down__list.black-color.js-dropdown li:first-child")
    private WebElement elementOfDropDown;

    @FindBy (css = ".b-drop-down__value")
    private WebElement elementPresent;

    @FindBy (css = "[data-qaid='enter_cabinet']")
    private WebElement finishButton;


    public ValidationPage(WebDriver webDriver) {
        super(webDriver);
    }

    /**
     * Method generate random number of the phone and enter it to the phone/mail field
     */
    public void enterPhoneNumber () {
        String tempNumber = "+38073" + generateRandomNumeric(7);

        enterTextIntoInput(phoneNumbeField,tempNumber);
    }

    /**
     * Method takes text and Enter it to the Company name field
     * @param companyName
     */
    public void enterCompanyName (String companyName) {
        enterTextIntoInput(companyNameField, companyName);
    }

    /**
     * Method select category in the drop down list
     */
    public void selectTheServiceOfCompany () {
        selectOptionsInDropDown(dropDownmain, elementOfDropDown);
    }

    /**
     * Method check for drop down: is it not empty
     */
    public void checkAddedElement () {
        isElementPresent(elementPresent);
    }


    /**
     * Method click on Finish button on the Confirm Page of the Created user
     */
    public void ClickFinishButton() {
        clickOnElement(finishButton);
    }

}
