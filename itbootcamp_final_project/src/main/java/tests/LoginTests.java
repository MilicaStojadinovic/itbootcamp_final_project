package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BasicTest {
    @Test(priority = 1)
    public void visitTheLoginPage() throws InterruptedException {

        navPage.getLanguageButton().click();
        navPage.getENLanguageButton().click();
        navPage.getLoginButton().click();
        Thread.sleep(2000);
        Assert.assertTrue(driver
                        .getCurrentUrl()
                        .contains("/login"),
                "[ERROR] Page url does not contains '/login'!");
    }

    @Test(priority = 2)
    public void checksInputTypes() {
        navPage.getLoginButton().click();
        Assert.assertEquals(
                loginPage.getEmailInput().getAttribute("type"),
                "email",
                "[ERROR] Input email is not type 'email'!");

        Assert.assertEquals(
                loginPage.getPasswordInput().getAttribute("type"),
                "password",
                "[ERROR] Input email is not type 'password'!");
    }

    @Test(priority = 3)
    public void displaysErrorsWhenUserDoesNotExist() {
        String email = "non-existing-user@gmal.com";
        String password = "password123";
        navPage.getLoginButton().click();
        loginPage.getEmailInput().sendKeys(email);
        loginPage.getPasswordInput().sendKeys(password);
        loginPage.getLoginButton().click();
        messagePopUpPage.waitForEditDialogToBeVisible();
        Assert.assertTrue(
                messagePopUpPage.messageTitleWrongUser().getText()
                        .contains("User does not exists"),
                "[ERROR] Message pop up does not contains 'User does not exists'");
        Assert.assertTrue(driver
                        .getCurrentUrl()
                        .contains("/login"),
                "[ERROR] Page url does not contains '/login'!");
    }

    @Test(priority = 4)
    public void displaysErrorsWhenPasswordIsWrong() {
        String email = "admin@admin.com";
        String password = "password123";
        navPage.getLoginButton().click();
        loginPage.getEmailInput().sendKeys(email);
        loginPage.getPasswordInput().sendKeys(password);
        loginPage.getLoginButton().click();
        messagePopUpPage.waitForEditDialogToBeVisible();
        Assert.assertTrue(
                messagePopUpPage.messageTitleWrongPassword().getText()
                        .contains("Wrong password"),
                "[ERROR] Message pop up dose not contains 'Wrong password'");
        Assert.assertTrue(driver
                        .getCurrentUrl()
                        .contains("/login"),
                "[ERROR] Page url does not contains '/login'!");
    }

    @Test(priority = 5)
    public void login() throws InterruptedException {
        String email = "admin@admin.com";
        String password = "12345";
        navPage.getLoginButton().click();
        loginPage.getEmailInput().sendKeys(email);
        loginPage.getPasswordInput().sendKeys(password);
        loginPage.getLoginButton().click();
        loginPage.waitForHomeUrlToBeVisible();
        Assert.assertTrue(driver
                        .getCurrentUrl()
                        .contains("/home"),
                "[ERROR] Page url does not contains '/home'!");
    }

    @Test(priority = 6)
    public void logout() {
        loginPage.waitForLogoutButtonToBeVisible();
        navPage.getLogoutButton().click();

    }

}
