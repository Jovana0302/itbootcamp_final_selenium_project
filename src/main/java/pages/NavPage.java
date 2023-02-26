package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavPage extends BasicPage {

    public NavPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getHomeLink(){
        return driver.findElement(
                By.xpath("//*[@class='v-toolbar__content']//a[1]"));
    }

    public WebElement getAboutLink(){
        return driver.findElement(
                By.xpath("//*[@class='v-toolbar__content']//a[2]"));
    }

    public WebElement getLoginButton(){
        return driver.findElement(
                By.xpath("//*[@class='v-toolbar__content']//a[3]"));
    }

    public WebElement getSignupButton(){
        return driver.findElement(
                By.xpath("//*[@class='v-toolbar__content']//a[4]"));
    }

    public WebElement getMyProfileLink(){
        return driver.findElement(By.className("btnProfile"));
    }

    public WebElement getAdminButton(){
        return driver.findElement(By.className("btnAdmin"));
    }

    public WebElement getCitiesLink(){
        return driver.findElement(By.className("btnAdminCities"));
    }

    public WebElement getUsersLink(){
        return driver.findElement(By.className("btnAdminUsers"));
    }

    public WebElement getLogoutButton(){
        return wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.className("btnLogout")));
    }

    public WebElement getLanguageButton(){
        return driver.findElement(By.className("btnLocaleActivation"));
    }

    public WebElement getEnglishLanguageButton(){
        return driver.findElement(By.className("btnEN"));
    }

    public WebElement getSpanishLanguageButton(){
        return driver.findElement(By.className("btnES"));
    }

    public WebElement getFrenchLanguageButton(){
        return driver.findElement(By.className("btnFR"));
    }

    public WebElement getChineseLanguageButton(){
        return driver.findElement(By.className("btnCN"));
    }

    public WebElement getLandingPageHeading(){
        return driver.findElement(By.tagName("h1"));
    }

    public void waitForHomePage(){
        wait.until(ExpectedConditions.urlContains("/home"));
    }

}
