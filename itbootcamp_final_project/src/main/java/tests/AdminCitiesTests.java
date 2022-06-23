package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
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

    @Test(priority = 2)
    public void checksInputTypesForCreateEditNewCity() {
        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();
        citiesPage.getNewItemButton().click();
        citiesPage.waitForNewItemDialogToBeVisible();
        Assert.assertEquals(
                citiesPage.getNameInput().getAttribute("type"),
                "text",
                "[ERROR] Input name is not type 'text'!");

    }

    @Test(priority = 3)
    public void createNewCity() {
        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();
        citiesPage.getNewItemButton().click();
        citiesPage.waitForNewItemDialogToBeVisible();
        citiesPage.getNameInput().sendKeys("Milica Stojadinovic's city");
        citiesPage.getSaveButton().click();
        messagePopUpPage.waitForSuccessfullySavedDialogToBeVisible();
        Assert.assertTrue(
                messagePopUpPage.messageTitleSuccessfullySaved().getText()
                        .contains("Saved successfully"),
                "[ERROR] Message pop up does not contains 'Saved successfully'");

    }

    @Test(priority = 4)
    public void editCity() {
        String oldCityName = "Milica Stojadinovic's city";
        String newCityName = "Milica Stojadinovic's city Edited";
        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();
        citiesPage.getSearchInput().sendKeys(oldCityName);
        citiesPage.waitForSpecificNumberOfRows(1);
        citiesPage.getEditByRowNumber(1).click();
        citiesPage.getNameInput().sendKeys(Keys.CONTROL + "a");
        citiesPage.getNameInput().sendKeys(newCityName);
        citiesPage.getSaveButton().click();
        messagePopUpPage.waitForSuccessfullySavedDialogToBeVisible();
        Assert.assertTrue(
                messagePopUpPage.messageTitleSuccessfullySaved().getText()
                        .contains("Saved successfully"),
                "[ERROR] Message pop up does not contains 'Saved successfully'");
    }

    @Test(priority = 5)
    public void searchCity() {
        String cityName = "Milica Stojadinovic's city Edited";
        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();
        citiesPage.getSearchInput().sendKeys(cityName);
        citiesPage.waitForSpecificNumberOfRows(1);
        citiesPage.getEditByRowNumber(1).click();
        citiesPage.waitForNameInputDialogToBeVisible();
        Assert.assertTrue(
                citiesPage.getTableCell(1,2).getText()
                        .contains("Milica Stojadinovic's city Edited"),
                "[ERROR] Name input dose not contains 'Milica Stojadinovic's city Edited'");
    }
    @Test (priority = 6)
    public void deleteCity(){
        String cityName = "Milica Stojadinovic's city Edited";
        navPage.getAdminButton().click();
        navPage.getCitiesLink().click();
        citiesPage.getSearchInput().sendKeys(cityName);
        citiesPage.waitForSpecificNumberOfRows(1);
        citiesPage.getEditByRowNumber(1).click();
        citiesPage.waitForNameInputDialogToBeVisible();
        Assert.assertTrue(
                citiesPage.getTableCell(1,2).getText()
                        .contains("Milica Stojadinovic's city Edited"),
                "[ERROR] Name input dose not contains 'Milica Stojadinovic's city Edited'");
        citiesPage.getCancelButton().click();
        citiesPage.getDeleteByRowNumber(1).click();
        citiesPage.waitForDeleteDialogToBeVisible();
        citiesPage.getDialogDeleteButton().click();
        messagePopUpPage.waitForDeleteDialogToBeVisible();
        Assert.assertTrue(
                messagePopUpPage.messageTitleSuccessfullyDeleted().getText()
                        .contains("Deleted successfully"),
                "[ERROR] Message pop up dose not contains 'Deleted successfully'");

    }

}

