import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BasicTest {

    @Test
    @Description("Visit login page")
    public void tc1_visitLoginPage() {
        navPage.getLanguageButton().click();
        navPage.getEnglishLanguageButton().click();
        navPage.getLoginButton().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
                "Not on login page");
    }

    @Test
    @Description("Check input types")
    public void tc2_checkInputTypes() {
        navPage.getLoginButton().click();
        Assert.assertEquals(loginPage
                        .getEmailInput().getAttribute("type"),
                "email",
                "Wrong input type");
        Assert.assertEquals(loginPage
                        .getPasswordInput().getAttribute("type"),
                "password",
                "Wrong input type");
    }

    @Test
    @Description("Display error when user does not exist")
    public void tc3_displayErrorWhenUserDoesNotExist() {
        navPage.getLoginButton().click();
        loginPage.getEmailInput().sendKeys(
                "non-existing-user@gmal.com");
        loginPage.getPasswordInput().sendKeys(
                "password123");
        loginPage.getLoginButton()
                .click();
        messagePopUpPage.waitForErrorPopUpMessage();
        Assert.assertEquals(messagePopUpPage.getErrorMessage().getText(),
                "User does not exists",
                "Wrong error message");
//        does not exists - grammatical error (should be: does not exist)
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
                "Not on login page");
    }

    @Test
    @Description("Display error when password is wrong")
    public void tc4_displayErrorForWrongPassword() {
        navPage.getLoginButton().click();
        loginPage.getEmailInput().sendKeys(
                "admin@admin.com");
        loginPage.getPasswordInput().sendKeys(
                "password123");
        loginPage.getLoginButton()
                .click();
        messagePopUpPage.waitForErrorPopUpMessage();
        Assert.assertEquals(messagePopUpPage.getErrorMessage().getText(),
                "Wrong password",
                "Wrong error message");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
                "Not on login page");
    }

    @Test
    @Description("Login")
    public void tc5_login() throws InterruptedException {
        navPage.getLoginButton().click();
        loginPage.getEmailInput().sendKeys(
                "admin@admin.com");
        loginPage.getPasswordInput().sendKeys(
                "12345");
        loginPage.getLoginButton().click();
        Thread.sleep(500);
        Assert.assertTrue(driver.getCurrentUrl().contains("/home"),
                "Not on home page");
    }

    @Test
    @Description("Logout")
    public void tc6_logout() {
//        this method waits for the logout button to be visible
//        and returns the element
        navPage.getLogoutButton()
                .click();
    }

}
