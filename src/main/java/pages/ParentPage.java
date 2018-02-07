package pages;

import libs.ActionsWithOurElements;
import libs.ConfigProperties;
import org.aeonbits.owner.ConfigFactory;
import org.apache.http.util.Asserts;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static libs.ActionsWithOurElements.webDriverWait20;

public class ParentPage {
    WebDriver webDriver;
    ActionsWithOurElements actionsWithOurElements;
    protected Logger logger;
    String expectedUrl;
    WebDriverWait webDriverWait;



    public ParentPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());
        PageFactory.initElements(webDriver, this);
        actionsWithOurElements = new ActionsWithOurElements(webDriver);
        webDriverWait20 = new WebDriverWait(webDriver, 20);

    }

}

