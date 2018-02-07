package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static libs.ActionsWithOurElements.*;

public class NewCabinetPage extends ParentPage {


    public NewCabinetPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(css = ".b-sidebar-header__logo")
    private WebElement newCabinetLogo;

    @FindBy(css = "[data-qaid='svg-goods'] .b-main-menu-new__icon")
    private WebElement serviceMenuButton;

    @FindBy(css = "[data-qaid='Товары и услуги']")
    private WebElement serviceAndGodsText;

    /**
     * Method check the main Logo of the New Cabinet Page
     *
     * @return
     */
    public boolean isPresentLogoNewCabinet() {
        return isElementPresent(newCabinetLogo);
    }

    /**
     * Method selects the sub-tab "Services" in the main menu
     */
    public void clickOnServiceInMenu() {
        clickOnElement(serviceAndGodsText);

    }
}
