package parentTest;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;
import pagesDataSource.FakeNamePage;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ParentTest {


    public WebDriver webDriver;
    public Logger log;
    String browser = System.getProperty("browser"); //name of browser for launch
    protected MainOutPage mainOutPage;
    protected FakeNamePage fakeNamePage;
    protected RegistrationLoginPage registrationLoginPage;
    protected ValidationPage validationPage;
    protected OldCabinetPage oldCabinetPage;
    protected NewCabinetPage newCabinetPage;
    protected ServiceAndGoodsPage serviceAndGoodsPage;
    protected LoginPage loginPage;
    protected NewServicePage newServicePage;
    protected EditServicePage editServicePage;


    @Before

    public void setUp() {
        log = Logger.getLogger(getClass());
        setBrowser();
        mainOutPage = new MainOutPage(webDriver);
        fakeNamePage = new FakeNamePage(webDriver);
        registrationLoginPage = new RegistrationLoginPage(webDriver);
        validationPage = new ValidationPage(webDriver);
        oldCabinetPage = new OldCabinetPage(webDriver);
        newCabinetPage = new NewCabinetPage(webDriver);
        serviceAndGoodsPage = new ServiceAndGoodsPage(webDriver);
        loginPage = new LoginPage(webDriver);
        newServicePage = new NewServicePage(webDriver);
        editServicePage = new EditServicePage(webDriver);


        webDriver.manage().window().maximize(); //open window full screen
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    private void setBrowser() {
        try {
            File fileFF = new File("./drivers/chromedriver.exe");
            System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath());
            webDriver = new ChromeDriver();
        } catch (Exception e) {
            Assert.fail("Can not open browser " + browser);
        }
    }

    @After
    public void tearDown() {
        webDriver.quit(); // Закриє браузер
    }

}

