package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NavPage {
    private WebDriver driver;

    public NavPage(WebDriver driver) {
        this.driver = driver;
    }
//String url = "https://vue-demo.daniel-avellaneda.com";
    public WebElement getHomeLink (){
        return driver.findElement(By.linkText("HOME"));
    }
    public WebElement getAboutLink (){
        return driver.findElement(By.linkText("ABOUT"));
    }
    public WebElement getMyProfileLink (){
        return driver.findElement(By.linkText("MY PROFILE"));
    }
    public WebElement getAdminButton (){
        return driver.findElement(By.className("btnAdmin"));
    }
    public WebElement getCitiesLink (){
        return driver.findElement(By.linkText("Cities"));
    }
    public WebElement getUsersLink (){
        return driver.findElement(By.linkText("Users"));
    }
    public WebElement getLoginButton (){
        return driver.findElement(By.className("btnLogin"));
    }
    public WebElement getLogoutButton (){
        return driver.findElement(By.className("btnLogout"));
    }
    public WebElement getLanguageButton (){
        return driver.findElement(By.className("btnLocaleActivation"));
    }
    public WebElement getENLanguageButton (){
        return driver.findElement(By.className("btnEN"));
    }
    public WebElement getESLanguageButton (){
        return driver.findElement(By.className("btnES"));
    }
    public WebElement getFRLanguageButton (){
        return driver.findElement(By.className("btnFR"));
    }
    public WebElement getCNLanguageButton (){
        return driver.findElement(By.className("btnCN"));
    }

}
