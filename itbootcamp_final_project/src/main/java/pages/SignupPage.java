package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignupPage {
    private WebDriver driver;

    public SignupPage(WebDriver driver) {
        this.driver = driver;
    }

    //String url = "https://vue-demo.daniel-avellaneda.com/signup";
    public  WebElement getSignUpButton () {
        return driver
                .findElement(By.xpath("//*[contains(text(),'Sign Up')]"));
    }
    public WebElement getNameInput() {
        return driver.findElement(By.name("name"));
    }

    public WebElement getEmailInput() {
        return driver.findElement(By.name("email"));
    }

    public WebElement getPasswordInput() {
        return driver.findElement(By.name("password"));
    }

    public WebElement getConfirmPasswordInput() {
        return driver.findElement(By.name("confirmPassword"));
    }

    public WebElement getSignMeUpButton() {
        return driver.findElement(By.xpath("//*[contains(text(),'Sign me up')]"));
    }

    public void waitForSignupUrlToBeVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.urlContains("/signup"));
    }


}
