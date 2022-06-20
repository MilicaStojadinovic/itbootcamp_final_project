package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BasicTest  {
    @Test (priority = 10)
    public void visitTheLoginPage () throws InterruptedException {

        navPage.getLanguageButton().click();
        navPage.getENLanguageButton().click();
        navPage.getLoginButton().click();
        Thread.sleep(2000);
        Assert.assertTrue(driver
                .getCurrentUrl()
                .contains("/login"),
                "[ERROR] Page url does not contains '/login'!");
    }
    @Test (priority = 20)
    public void checksInputTypes (){
        navPage.getLoginButton().click();
        Assert.assertEquals(
                loginPage.getEmailInput().getAttribute("type"),
                "email",
                "[ERROR] Input email is not type 'email'!");

        Assert.assertEquals(
                loginPage.getPasswordInput().getAttribute("type"),
                "password",
                "[ERROR] Input email is not type 'email'!");
    }
}
