package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.JavascriptExecutor;

import static libs.ActionsWithOurElements.*;

public class NewServicePage extends ParentPage {
    public NewServicePage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(css = ".b-sliding-panel__close-btn")
    private WebElement bottonCloseRightMenu;

    @FindBy(css = "[data-qaid='product_name_input']")
    private WebElement serviceNameInput;

    @FindBy(css = ".cke_editable.cke_editable_themed.cke_contents_ltr")
    private WebElement serviceDescriptionInput;

    @FindBy(css = ".b-drop-down__value_type_ellipsis")
    private WebElement serviceCategoryDropDown;

    @FindBy(css = "[data-qaid='search_input']")
    private WebElement searchFieldInput;

    @FindBy(id = "225")
    private WebElement serviceCategoryOption;

    @FindBy(css = ".b-smart-selector__footer [data-qaid='save_btn'] .b-button__text")
    private WebElement serviceCategorySaveBtn;

    @FindBy(css = "[data-qaid='save_position_btn']")
    private WebElement savePositionBtn;

    @FindBy(css = "[data-qaid='Управление товарами и услугами']")
    private WebElement manageServiceAndGoods;

    /**
     * Method close the hint for the user
     */
    public void closeRightHint() {
        clickOnElement(bottonCloseRightMenu);
    }

    /**
     * Method generate service name and enter it to the Service name field
     *
     * @return
     */
    public String enterServiceName() {
        String generatedSpareName = "Service - " + generateRandomNumeric(5);
        enterTextIntoInput(serviceNameInput, generatedSpareName);
        return generatedSpareName;
    }

    /**
     * Method generate service description and enter it to the Service description field
     *
     * @param description
     */
    public void enterServiceDescription(String description) {
        webDriver.switchTo().defaultContent();
        webDriver.switchTo().frame(webDriver.findElement(By.cssSelector(".cke_wysiwyg_frame.cke_reset")));
        enterTextIntoInput(serviceDescriptionInput, description);
        webDriver.switchTo().defaultContent();
    }

    /**
     * Method selects category for the created Service
     *
     * @param searchText
     */
    public void selectServiceCategory1(String searchText) {
        clickOnElement(serviceCategoryDropDown);
        enterTextIntoInput(searchFieldInput, searchText);
        changeOpacityOfElement(serviceCategoryOption);
        clickOnElement(serviceCategoryOption);
        scrollToElement(serviceCategorySaveBtn);
        clickOnElement(serviceCategorySaveBtn);
    }

    /**
     * Method save changes for just created Service
     */
    public void saveNewService() {
        clickOnElement(savePositionBtn);
    }

    /**
     * Method allows test return into the main "Service and Goods" page
     */
    public void returnToServiceslist() {
        clickOnElement(manageServiceAndGoods);
    }
}
