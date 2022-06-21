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
}
