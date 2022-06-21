package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTests extends BasicTest {
//    @Test(priority = 1)
    public void visitsTheSignUpPage() {
        signupPage.getSignMeUpButton().click();
        signupPage.waitForSignupUrlToBeVisible();
        Assert.assertTrue(driver
                        .getCurrentUrl()
                        .contains("/signup"),
                "[ERROR] Page url does not contains '/signup'!");
    }

//    @Test(priority = 2)
    public void checksInputTypes() {
        signupPage.getSignMeUpButton().click();
        Assert.assertEquals(
                signupPage.getEmailInput().getAttribute("type"),
                "email",
                "[ERROR] Input email is not type 'email'!");

        Assert.assertEquals(
                signupPage.getPasswordInput().getAttribute("type"),
                "password",
                "[ERROR] Input password is not type 'password'!");
        Assert.assertEquals(
                signupPage.getConfirmPasswordInput().getAttribute("type"),
                "password",
                "[ERROR] Input confirm password is not type 'password'!");

    }

//    @Test(priority = 3)
    public void displayErrorsWhenUserAlredyExists() {
        String name = "Another User";
        String email = "admin@admin.com";
        String password = "12345";
        String confirmPassword = "12345";

        signupPage.getSignUpButton().click();
        Assert.assertTrue(driver
                        .getCurrentUrl()
                        .contains("/signup"),
                "[ERROR] Page url does not contains '/signup'!");
        signupPage.getNameInput().sendKeys(name);
        signupPage.getEmailInput().sendKeys(email);
        signupPage.getPasswordInput().sendKeys(password);
        signupPage.getConfirmPasswordInput().sendKeys(confirmPassword);
        signupPage.getSignMeUpButton().click();
        messagePopUpPage.waitForEditDialogToBeVisible();
        Assert.assertTrue(
                messagePopUpPage.messageTitleEmailAlredyExists().getText()
                        .contains("E-mail already exists"),
                "[ERROR] Message pop up does not contains 'E-mail already exists'");
        Assert.assertTrue(driver
                        .getCurrentUrl()
                        .contains("/signup"),
                "[ERROR] Page url does not contains '/signup'!");

    }
//    @Test (priority = 4)
    public void signUp (){

        String name = "Milica Stojadinovic";
        String email = "milica.stojadinovic@itbootcamp.com";
        String password = "12345";
        String confirmPassword = "12345";

        signupPage.getSignUpButton().click();
        signupPage.getNameInput().sendKeys(name);
        signupPage.getEmailInput().sendKeys(email);
        signupPage.getPasswordInput().sendKeys(password);
        signupPage.getConfirmPasswordInput().sendKeys(confirmPassword);
        signupPage.getSignMeUpButton().click();
        messagePopUpPage.waitForVerifyDialogToBeVisible();

        Assert.assertTrue(
                messagePopUpPage.messageTitleVerifyAccount().getText()
                        .contains("IMPORTANT: Verify your account"),
                "[ERROR] Message pop up does not contains 'IMPORTANT: Verify your account'");
        messagePopUpPage.getCloseButton().click();
        navPage.getLogoutButton().click();

    }
}


