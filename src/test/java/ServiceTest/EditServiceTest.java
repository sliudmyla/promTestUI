package ServiceTest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import parentTest.ParentTest;

public class EditServiceTest extends ParentTest {
    String nameService, editedName;

    @Test

    public void EditService() {
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

        serviceAndGoodsPage.selectServiceForEdit(nameService);

        editedName = editServicePage.editServiceName();
        editServicePage.addNewTag("first tag");
        editServicePage.enterPrice("200");
        editServicePage.saveChanges();
        editServicePage.returnToServiceslist();

        Assert.assertTrue("Service is not added", serviceAndGoodsPage.isNewServiceAdded(editedName));

    }

    @After

    public void cleanGeneratedServices() {
        serviceAndGoodsPage.selectServiceForEdit(editedName);
        editServicePage.deleteService();

        Assert.assertTrue("Service is added", serviceAndGoodsPage.isServiceDeleted(editedName));
    }

}
