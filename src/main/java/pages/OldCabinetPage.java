package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static libs.ActionsWithOurElements.*;

public class OldCabinetPage extends ParentPage {
    public OldCabinetPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(css = "[data-qaid='reg_element'] .x-header__controls-link-text")
    private WebElement myCabinet;

    @FindBy(css = ".x-header-popup__exit")
    private WebElement logOut;

    @FindBy(css = ".b-button__text.b-button__text_size_medium")
    private WebElement newCabinetButton;


    /**
     * Method checks the visiblity of image logo of the Cabinet
     * @return
     */
    public boolean checkMyCabinetIcon() {
        return isElementPresent(myCabinet);
    }

    /**
     * Methods redirects to the New Cabinet of the application
     */
    public void goToTheNewCabinet() {
        clickOnElement(newCabinetButton);
    }

}
