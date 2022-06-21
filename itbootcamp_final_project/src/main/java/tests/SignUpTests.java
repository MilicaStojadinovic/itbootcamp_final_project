package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTests extends BasicTest{
    @Test(priority = 1)
    public void visitsTheSignUpPage (){
        signupPage.getSignMeUpButton().click();
        signupPage.waitForSignupUrlToBeVisible();
        Assert.assertTrue(driver
                        .getCurrentUrl()
                        .contains("/signup"),
                "[ERROR] Page url does not contains '/signup'!");
    }
    @Test(priority = 2)
    public void checksInputTypes (){
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
    
}
