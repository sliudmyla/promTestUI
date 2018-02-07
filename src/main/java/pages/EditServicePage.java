package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static libs.ActionsWithOurElements.*;

public class EditServicePage extends ParentPage {
    public EditServicePage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(css = "[data-qaid='product_name_input']")
    private WebElement serviceNameInput;

    @FindBy(css = ".b-product-edit__tag-creator [data-qaid='add_tag_block'] [data-qaid='add_tag_icon']")
    private WebElement servceTagAdd;

    @FindBy(css = "[data-qaid='search_tag_input']")
    private WebElement serviceTagInput;

    @FindBy(css = "[data-qaid='new_tag_link']")
    private WebElement createTagLink;

    @FindBy(css = ".b-multiselect-creator__action [data-qaid='save_btn']")
    private WebElement addTagButton;

    @FindBy(css = "[data-qaid='product_price_input']")
    private WebElement servicePrice;

    @FindBy(css = "[data-qaid='save_position_btn']")
    private WebElement savePositionBtn;

    @FindBy(css = "[data-qaid='Управление товарами и услугами']")
    private WebElement manageServiceAndGoods;

    @FindBy(css = ".b-product-edit .b-product-edit__inline-btn .b-button__text")
    private WebElement deletePosition;

    @FindBy(css = "[data-qaid='delete_btn']")
    private WebElement confirmDeleteButton;

    /**
     * Method generates random name for Service and enter it in return for the existed name
     * @return
     */
    public String editServiceName() {
        String generatedSpareName = "Service - " + generateRandomNumeric(5);
        enterTextIntoInput(serviceNameInput, generatedSpareName);
        return generatedSpareName;
    }

    /**
     * Method takes text and create new tag for Service with such text
     * @param tagText
     */
    public void addNewTag(String tagText) {
        clickOnElement(servceTagAdd);
        clickOnElement(serviceTagInput);
        enterTextIntoInput(serviceTagInput, tagText);
        hardClick(createTagLink);
        hardClick(addTagButton);
    }

    /**
     * Method enter price to the selected Service
     * @param priceAmount
     */
    public void enterPrice(String priceAmount) {
        enterTextIntoInput(servicePrice, priceAmount);
    }

    /**
     * Method save changes with just edited data
     */
    public void saveChanges() {
        clickOnElement(savePositionBtn);
    }

    /**
     * Method allow test return to the Main page "Services and Goods"
     */
    public void returnToServiceslist() {
        clickOnElement(manageServiceAndGoods);
    }

    /**
     * Method delete selected Service from the profile
     */
    public void deleteService() {
        clickOnElement(deletePosition);
        hardClick(confirmDeleteButton);
    }


}
