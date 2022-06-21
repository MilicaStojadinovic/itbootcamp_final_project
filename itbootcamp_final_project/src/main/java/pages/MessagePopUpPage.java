package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MessagePopUpPage {
    private WebDriver driver;

    public MessagePopUpPage(WebDriver driver) {
        this.driver = driver;
    }
    public void waitForEditDialogToBeVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.className("v-snack__content")));
    }
    public WebElement messageTitleWrongUser(){
        return driver.findElement(By.xpath("//*[contains(text(), 'User does not exists')]"));
    }
    public WebElement messageTitleWrongPassword(){
        return driver.findElement(By.xpath("//*[contains(text(), 'Wrong password')]"));
    }
    public WebElement getCloseButton (){
        return driver.findElement(By.xpath("//*[contains(text(), 'Close')]"));
    }
}
