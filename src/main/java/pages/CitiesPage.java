package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CitiesPage extends BasicPage {

    public CitiesPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getSearchInput(){
        return driver.findElement(By.id("search"));
    }

    public WebElement getNewItemButton(){
        return driver.findElement(By.className("btnNewItem"));
    }

    public void waitForNewEditItemDialog(){
        wait.until(ExpectedConditions.
                presenceOfElementLocated(By.className("dlgNewEditItem")));
    }

    public WebElement getNameInput(){
        return driver.findElement(By.id("name"));
    }

    public WebElement getCancelButton(){
        return driver.findElement(By.className("btnCancel"));
    }

    public WebElement getSaveButton(){
        return driver.findElement(By.className("btnSave"));
    }

    public void waitForDeleteDialog(){
        wait.until(ExpectedConditions.
                presenceOfElementLocated(By.className("v-dialog--active")));
    }

    public WebElement getDeleteButton(){
        return driver.findElement(By.xpath(
                "//*[contains(@class,'v-dialog--active')]//button[2]"));
    }

    public void waitForNumberOfRowsToBe(int rows){
        wait.until(ExpectedConditions.numberOfElementsToBe(
                By.xpath("//tbody/tr"), rows));
    }

    public WebElement getCellByRowAndColumn(int row, int column){
        return driver.findElement(By.xpath(
                "//tbody/tr["+row+"]/td["+column+"]"));
    }

    public WebElement getEditButtonByRow(int row){
        return driver.findElement(By.xpath(
                "//tbody/tr["+row+"]//button[@id='edit']"));
    }

    public WebElement getDeleteButtonByRow(int row){
        return driver.findElement(By.xpath(
                "//tbody/tr["+row+"]//button[@id='delete']"));
    }

}
