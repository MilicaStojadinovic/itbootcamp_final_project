package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminCitiesTests extends BasicTest {
    @Test(priority = 1)
    public void visitsTheAdminCitiesPageAndListCities() {
        String adminemail = "admin@admin.com";
        String adminPassword = "12345";
        navPage.getLoginButton().click();
        loginPage.getEmailInput().sendKeys(adminemail);
        loginPage.getPasswordInput().sendKeys(adminPassword);
        loginPage.getLoginButton().click();
        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();
        citiesPage.waitForCitiesUrlToBeVisible();
        Assert.assertTrue(driver
                        .getCurrentUrl()
                        .contains("/admin/cities"),
                "[ERROR] Page url does not contains '/admin/cities'!");
    }
    @Test (priority = 2)
    public void checksInputTypesForCreateEditNewCity (){
        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();
        citiesPage.getNewItemButton().click();
        citiesPage.waitForNewItemDialogToBeVisible();
        Assert.assertEquals(
                citiesPage.getNameInput().getAttribute("type"),
                "text",
                "[ERROR] Input name is not type 'text'!");

    }
    @Test (priority = 3)
    public void createNewCity(){
        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();
        citiesPage.getNewItemButton().click();
        citiesPage.waitForNewItemDialogToBeVisible();
        citiesPage.getNameInput().sendKeys("S's city");
        citiesPage.getSaveButton().click();
        messagePopUpPage.waitForSuccessfullySavedDialogToBeVisible();
        Assert.assertTrue(
                messagePopUpPage.messageTitleSuccessfullySaved().getText()
                        .contains("Saved successfully"),
                "[ERROR] Message pop up does not contains 'Saved successfully'");

    }
}
