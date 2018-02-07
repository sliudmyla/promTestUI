package ServiceTest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import parentTest.ParentTest;

public class AddServiceTest extends ParentTest {
    String nameService;

    @Test

    public void addNewService() {
        mainOutPage.openMainOutPage("https://prom.ua");
        mainOutPage.selectLoginOption();
        loginPage.enterLoginName("x2982381@mvrht.net");
        loginPage.enterPassName("test");
        loginPage.clickOnSubmitButoon();

        oldCabinetPage.checkMyCabinetIcon();
        oldCabinetPage.goToTheNewCabinet();

        Assert.assertTrue("Logo is invisible", newCabinetPage.isPresentLogoNewCabinet());

        newCabinetPage.clickOnServiceInMenu();

        serviceAndGoodsPage.closeRightHint();
        serviceAndGoodsPage.clickAddNewService();
        newServicePage.closeRightHint();
        nameService = newServicePage.enterServiceName();
        newServicePage.enterServiceDescription("Service Description 1");
        newServicePage.selectServiceCategory1("Продукты питания, общее");

        newServicePage.saveNewService();
        newServicePage.closeRightHint();
        newServicePage.returnToServiceslist();

        Assert.assertTrue("Service is not added", serviceAndGoodsPage.isNewServiceAdded(nameService));
    }

    @After

    public void cleanGeneratedServices() {
        serviceAndGoodsPage.selectServiceForEdit(nameService);
        editServicePage.deleteService();

        Assert.assertTrue("Service is added", serviceAndGoodsPage.isServiceDeleted(nameService));
    }

}
