import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignupTests extends BasicTest {

    @Test(priority=1)
    @Description("TC1 Visit signup page")
    public void visitSignupPage() {
        navPage.getSignupButton().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"),
                "Not on signup page");
    }

    @Test(priority=2)
    @Description("TC2 Check input types")
    public void checkInputTypes() {
        navPage.getSignupButton().click();
        Assert.assertEquals(signupPage
                        .getEmailInput().getAttribute("type"),
                "email",
                "Wrong input type");
        Assert.assertEquals(signupPage
                        .getPasswordInput().getAttribute("type"),
                "password",
                "Wrong input type");
        Assert.assertEquals(signupPage
                        .getConfirmPasswordInput().getAttribute("type"),
                "password",
                "Wrong input type");
    }

    @Test(priority=3)
    @Description("TC3 Display error when user already exists")
    public void displayErrorWhenUserAlreadyExists() {
        navPage.getSignupButton().click();
        Assert.assertTrue(driver.getCurrentUrl()
                        .contains("/signup"),
                "Not on signup page");
        signupPage.getNameInput()
                .sendKeys("Another User");
        signupPage.getEmailInput()
                .sendKeys("admin@admin.com");
        signupPage.getPasswordInput()
                .sendKeys("12345");
        signupPage.getConfirmPasswordInput()
                .sendKeys("12345");
        signupPage.getSignMeUpButton()
                .click();
        messagePopUpPage.waitForErrorPopUpMessage();
        Assert.assertEquals(messagePopUpPage.getErrorMessage().getText(),
                "E-mail already exists",
                "Wrong error message");
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"),
                "Not on signup page");
    }

    @Test(priority=4)
    @Description("TC4 Signup")
    public void signup() {
        navPage.getSignupButton().click();
        signupPage.getNameInput()
                .sendKeys("Jovana Cvetanovic");
        signupPage.getEmailInput()
                .sendKeys("jovana.cvetanovic@itbootcamp.rs");
        signupPage.getPasswordInput()
                .sendKeys("12345");
        signupPage.getConfirmPasswordInput()
                .sendKeys("12345");
        signupPage.getSignMeUpButton()
                .click();
        messagePopUpPage.waitForVerifyYourAccountDialog();
        Assert.assertEquals(messagePopUpPage.getVerifyAccountHeader().getText(),
                "IMPORTANT: Verify your account",
                "Wrong message");
        messagePopUpPage.getVerifyAccountCloseButton()
                .click();
        navPage.getLogoutButton()
                .click();
    }

}
