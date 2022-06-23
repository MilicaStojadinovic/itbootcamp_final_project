package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CitiesPage {
    private WebDriver driver;

    public CitiesPage(WebDriver driver) {
        this.driver = driver;
    }

    //String url = "https://vue-demo.daniel-avellaneda.com/signup/admin/cities";
    public WebElement getNewItemButton() {
        return driver.findElement(By.xpath("//*[contains(text(),' New Item ')]"));
    }
    public WebElement getNameInput() {
        return driver.findElement(By.name("name"));
    }

    public WebElement getSearchInput() {
        return driver.findElement(By.name("search"));
    }
    public void waitForCitiesUrlToBeVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.urlContains("/admin/cities"));
    }
    public void waitForEditDialogToBeVisible() {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.id("edit")));

    }
    public void waitForNewItemDialogToBeVisible() {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//*[contains(text(),'Cancel')]")));

    }
    public void waitForDeleteDialogToBeVisible() {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.id("delete")));

    }
    public WebElement getSaveButton() {
        return driver.findElement(By.className("btnSave"));
    }
    public WebElement getDeleteButton() {
        return driver.findElement(By.id("delete"));
    }
    public void waitForSpecificNumberOfRows(int rowNumbers) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions
                .numberOfElementsToBe(By.xpath("//tbody/tr"), rowNumbers));

    }
    public WebElement getTableCell (int rowIndex, int columnIndex) {
       return driver.findElement(By.xpath("//tbody/tr["+rowIndex+"]/td["+columnIndex+"]"));
    }
    public WebElement getEditByRowNumber(int rowNumber){
       return driver.findElements(By.id("edit")).get(rowNumber);
    }
    public WebElement getDeleteByRowNumber(int rowNumber){
        return driver.findElements(By.id("delete")).get(rowNumber);
    }






}
