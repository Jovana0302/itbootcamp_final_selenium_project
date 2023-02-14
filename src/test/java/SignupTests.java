import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignupTests extends BasicTest {

    @Test
    @Description("Visit signup page")
    public void tc1_visitSignupPage() {
        navPage.getSignupButton().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"),
                "Not on signup page");
    }

    @Test
    @Description("Check input types")
    public void tc2_checkInputTypes() {
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

    @Test
    @Description("Display error when user already exists")
    public void tc3_displayErrorWhenUserAlreadyExists() {
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

    @Test
    @Description("Signup")
    public void tc4_signup() {
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
