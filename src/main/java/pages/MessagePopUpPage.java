package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MessagePopUpPage extends BasicPage {

    public MessagePopUpPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void waitForErrorPopUpMessage(){
        wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.className("error")));
    }

    public WebElement getErrorMessage(){
        return driver.findElement(
                By.xpath("//*[contains(@class,'error')]//li"));
    }

    public WebElement getErrorCloseButton(){
        return driver.findElement(
                By.xpath("//*[contains(@class,'error')]//button"));
    }

    public void waitForVerifyYourAccountDialog(){
        wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.className("v-dialog--active")));
    }

    public WebElement getVerifyAccountHeader(){
        return driver.findElement(By.className("dlgVerifyAccount"));
    }

    public WebElement getVerifyAccountCloseButton(){
        return driver.findElement(By.className("btnClose"));
    }

    public void waitForSuccessDialog(){
        wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.className("success")));
    }

    public WebElement getSuccessMessage(){
        return driver.findElement(By.xpath(
                "//*[contains(@class,'success')]/div"));
    }

}
