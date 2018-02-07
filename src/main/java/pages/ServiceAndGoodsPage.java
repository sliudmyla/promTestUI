package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static libs.ActionsWithOurElements.*;

public class ServiceAndGoodsPage extends ParentPage {
    public ServiceAndGoodsPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//*[contains(text(), 'Добавить позицию')]")
    private WebElement addNewServiceButton;

    @FindBy(css = ".b-sliding-panel__close-btn")
    private WebElement bottonCloseRightMenu;

    // "//*[contains(text(),'"++"')]")


    /**
     * Method select option which redirects to the page of the Creating new Service
     */
    public void clickAddNewService() {
        clickOnElement(addNewServiceButton);
    }

    /**
     * Method close application hint for the user
     */
    public void closeRightHint() {
        clickOnElement(bottonCloseRightMenu);
    }

    /**
     * Method select option which redirects to the page of the Editing Service page
     *
     * @param nameService
     */
    public void selectServiceForEdit(String nameService) {
        clickOnElement(webDriver.findElement(By.xpath("//*[contains(text(),'" + nameService + "')]")));
    }

    /**
     * Method return "true" option if new Service added to te list of Services
     * Method return "false" option id new Service is not added to the list of Services
     *
     * @param nameService
     * @return
     */
    public boolean isNewServiceAdded(String nameService) {
        return webDriver.findElement(By.xpath("//*[contains(text(),'" + nameService + "')]")).getText().equals(nameService);
    }


    /**
     * Method return "true" option if  Service deleted from  list of Services
     * Method return "false" option id Service is not  deleted from  list of Services
     *
     * @param nameService
     * @return
     */
    public boolean isServiceDeleted(String nameService) {
        return (!webDriver.findElement(By.xpath("//*[contains(text(),'" + nameService + "')]")).getText().equals(nameService));
    }


}
