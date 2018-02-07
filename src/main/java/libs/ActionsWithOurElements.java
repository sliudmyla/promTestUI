package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;


public class ActionsWithOurElements {
    static WebDriver webDriver;
    static Logger logger;
    public static WebDriverWait webDriverWait20;
    static Actions builder;

    public ActionsWithOurElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        logger = Logger.getLogger("ActionsWithOurElements");
        webDriverWait20 = new WebDriverWait(webDriver, 20);
        builder = new Actions(webDriver);

    }

    /**
     * Method enter text into Input text area
     *
     * @param input
     * @param text
     */
    public static void enterTextIntoInput(WebElement input, String text) {
        try {
            input.clear();
            input.sendKeys(text);
            logger.info(text + " was succesfully inputed " + input);
        } catch (Exception e) {
            logErrorAndStopTest();
        }
    }

    /**
     * Method for click on the any Element
     *
     * @param button
     */
    public static void clickOnElement(WebElement button) {
        try {
            webDriverWait20.until(ExpectedConditions.visibilityOf(button));
            button.click();
            logger.info("Element was clicked on" + button);
        } catch (Exception e) {
            logErrorAndStopTest();
        }
    }

    /**
     * Method which moves pointer to the any element
     *
     * @param element
     */
    public static void moveToTheElement(WebElement element) {
        webDriverWait20.until(ExpectedConditions.visibilityOf(element));
        builder.moveToElement(element);
        clickOnElement(element);
    }

    /**
     * Method which check is Element Present
     *
     * @param element
     * @return
     */
    public static boolean isElementPresent(WebElement element) {
        try {
            boolean tempState = element.isDisplayed() && element.isEnabled();
            logger.info("Is Element Present? - " + tempState);
            return tempState;
        } catch (Exception e) {
            logger.info("Is Element Present? - False ");
            return false;
        }
    }

    /**
     * Method for selection option in the Drop Down list
     *
     * @param element
     * @param option
     */
    public static void selectOptionsInDropDown(WebElement element, WebElement option) {
        try {
            clickOnElement(element);
            clickOnElement(element);
            clickOnElement(option);
        } catch (Exception e) {
            logErrorAndStopTest();
        }
    }

    public static void logErrorAndStopTest() {
        logger.error("Cannot work with Element "); // log and concole
        Assert.fail("Cannot work with Element "); // get in the report
    }

    /**
     * Generate Random number with exact length
     *
     * @param length
     * @return
     */
    public static String generateRandomNumeric(int length) {
        try {
            String tempRandom = randomNumeric(length);
            return tempRandom;
        } catch (Exception e) {
            logErrorAndStopTest();
            logger.info("Cannot generate random");
            return "Cannot generate random";


        }
    }

    /**
     * Method which allow system click on element by JavaScript Code
     *
     * @param element
     */
    public static void hardClick(WebElement element) {
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", element);
    }

    /**
     * Method allows test to work with non opacity elements
     *
     * @param element
     */
    public static void changeOpacityOfElement(WebElement element) {
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].style.opacity=1", element);
    }

    /**
     * Method allow scroll to the needed element till it will be in view
     *
     * @param element
     */
    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}