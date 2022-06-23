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
        Assert.assertTrue(driver
                        .getCurrentUrl()
                        .contains("/admin/cities"),
                "[ERROR] Page url does not contains '/admin/cities'!");
    }
}
