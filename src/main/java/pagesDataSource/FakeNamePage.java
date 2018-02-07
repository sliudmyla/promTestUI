package pagesDataSource;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static libs.ActionsWithOurElements.*;

public class FakeNamePage extends DataSourceParentPage {

    @FindBy(css = ".b1 .btn-primary")
    private WebElement buttonGenerate;

    public FakeNamePage(WebDriver webDriver) {
        super(webDriver);
    }


    /**
     * Open Random Fake Name Generator
     */
    public void openFakeNamePage() {
        try {
            webDriver.get(("http://listofrandomnames.com/index.cfm?generated"));
            clickOnElement(buttonGenerate);
            logger.info("Generator page was opened and click ");
        } catch (Exception e) {
            logger.error("Can not open Generator and click ");
            Assert.fail("Can not open Generator and click  ");                         }
    }

    public String getFakeFirstName () {
        String firstName = webDriver.findElement(By.cssSelector("#nameres li:first-child .firstname")).getText();
        return firstName;
    }
    public String getFakeLastName () {
        String lastName = webDriver.findElement(By.cssSelector("#nameres li:first-child .lastname")).getText();
        return lastName;
    }
    public String getEmail () {
        String email = getFakeFirstName() + "." + getFakeLastName() + generateRandomNumeric(2) + "@mail.com";
        return email;
    }

    public String getCompany () {
        String company = getFakeLastName() + "LLC";
        return company;
    }
}
