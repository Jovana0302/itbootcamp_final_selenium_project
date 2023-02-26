import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BasicTest {

    @Test(priority=1)
    @Description("TC1 Visit login page")
    public void visitLoginPage() {
        navPage.getLanguageButton().click();
        navPage.getEnglishLanguageButton().click();
        navPage.getLoginButton().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
                "Not on login page");
    }

    @Test(priority=2)
    @Description("TC2 Check input types")
    public void checkInputTypes() {
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

    @Test(priority=3)
    @Description("TC3 Display error when user does not exist")
    public void displayErrorWhenUserDoesNotExist() {
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

    @Test(priority=4)
    @Description("TC4 Display error when password is wrong")
    public void displayErrorForWrongPassword() {
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

    @Test(priority=5)
    @Description("TC5 Login")
    public void login() {
        navPage.getLoginButton().click();
        loginPage.getEmailInput().sendKeys(
                "admin@admin.com");
        loginPage.getPasswordInput().sendKeys(
                "12345");
        loginPage.getLoginButton().click();
        navPage.waitForHomePage();
        Assert.assertTrue(driver.getCurrentUrl().contains("/home"),
                "Not on home page");
    }

    @Test(priority=6)
    @Description("TC6 Logout")
    public void logout() {
//        this method waits for the logout button to be visible
//        and returns the element
        navPage.getLogoutButton()
                .click();
    }

}
