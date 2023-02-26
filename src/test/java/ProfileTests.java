import jdk.jfr.Description;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTests extends BasicTest {

    @Test(priority=1)
    @Description("TC1 Visit profile page")
    public void visitProfilePage() throws InterruptedException {
        navPage.getLoginButton()
                .click();
        loginPage.getEmailInput().sendKeys(
                "admin@admin.com");
        loginPage.getPasswordInput().sendKeys(
                "12345");
        loginPage.getLoginButton()
                .click();
        navPage.waitForHomePage();
        driver.get(baseUrl + "/profile");
        Assert.assertTrue(driver.getCurrentUrl().contains("/profile"),
                "Not on profile page");
        Thread.sleep(500);
        Assert.assertEquals(profilePage.getEmailInput().getAttribute("value"),
                "admin@admin.com",
                "Wrong email address");
        navPage.getLogoutButton()
                .click();
    }

    @Test(priority=2)
    @Description("TC2 Check input types")
    public void checkInputTypes() throws InterruptedException {
        navPage.getLoginButton()
                .click();
        loginPage.getEmailInput().sendKeys(
                "admin@admin.com");
        loginPage.getPasswordInput().sendKeys(
                "12345");
        loginPage.getLoginButton()
                .click();
        navPage.getMyProfileLink()
                .click();
        Thread.sleep(500);
        Assert.assertEquals(profilePage.getEmailInput().getAttribute("type"),
                "email",
                "Wrong input type");
        Assert.assertEquals(profilePage.getEmailInput().getAttribute("disabled"),
                "true",
                "Input enabled");
        Assert.assertEquals(profilePage.getNameInput().getAttribute("type"),
                "text",
                "Wrong input type");
        Assert.assertEquals(profilePage.getCityInput().getAttribute("type"),
                "text",
                "Wrong input type");
        Assert.assertEquals(profilePage.getCountryInput().getAttribute("type"),
                "text",
                "Wrong input type");
        Assert.assertEquals(profilePage.getUrlTwitterInput().getAttribute("type"),
                "url",
                "Wrong input type");
        Assert.assertEquals(profilePage.getUrlGitHubInput().getAttribute("type"),
                "url",
                "Wrong input type");
        Assert.assertEquals(profilePage.getPhoneInput().getAttribute("type"),
                "tel",
                "Wrong input type");
        navPage.getLogoutButton()
                .click();
    }

    @Test(priority=3)
    @Description("TC3 Edit profile")
    public void editProfile() throws InterruptedException {
        navPage.getLoginButton()
                .click();
        loginPage.getEmailInput().sendKeys(
                "admin@admin.com");
        loginPage.getPasswordInput().sendKeys(
                "12345");
        loginPage.getLoginButton()
                .click();
        navPage.getMyProfileLink()
                .click();
        Thread.sleep(500);
        profilePage.getNameInput().sendKeys(Keys.CONTROL + "a");
        profilePage.getNameInput().sendKeys(Keys.BACK_SPACE);
        profilePage.getNameInput().sendKeys(
                "Jovana Cvetanovic");
        profilePage.getPhoneInput().sendKeys(Keys.CONTROL + "a");
        profilePage.getPhoneInput().sendKeys(Keys.BACK_SPACE);
        profilePage.getPhoneInput().sendKeys(
                "+38161283223");
        profilePage.getCityInput().sendKeys(Keys.CONTROL + "a");
        profilePage.getCityInput().sendKeys(Keys.BACK_SPACE);
        profilePage.getCityInput().sendKeys(
                "Bucaramanga");
        profilePage.getCityInput().sendKeys(Keys.ENTER);
        profilePage.getCountryInput().sendKeys(Keys.CONTROL + "a");
        profilePage.getCountryInput().sendKeys(Keys.BACK_SPACE);
        profilePage.getCountryInput().sendKeys(
                "Spain");
        profilePage.getCityInput().sendKeys(Keys.ENTER);
        profilePage.getUrlTwitterInput().sendKeys(Keys.CONTROL + "a");
        profilePage.getUrlTwitterInput().sendKeys(Keys.BACK_SPACE);
        profilePage.getUrlTwitterInput().sendKeys(
                "https://twitter.com/profile/milan1232");
        profilePage.getUrlGitHubInput().sendKeys(Keys.CONTROL + "a");
        profilePage.getUrlGitHubInput().sendKeys(Keys.BACK_SPACE);
        profilePage.getUrlGitHubInput().sendKeys(
                "https://github.com/Jovana0302");
        profilePage.getSaveButton()
                .click();
        messagePopUpPage.waitForSuccessDialog();
        Assert.assertTrue(messagePopUpPage.getSuccessMessage()
                        .getText().contains("Profile saved successfuly"),
                "Wrong message");
        Assert.assertEquals(profilePage.getEmailInput().getAttribute("value"),
                "admin@admin.com",
                "Email does not match entered email");
        Assert.assertEquals(profilePage.getNameInput().getAttribute("value"),
                "Jovana Cvetanovic",
                "Name does not match entered name");
        Assert.assertEquals(profilePage.getPhoneInput().getAttribute("value"),
                "+38161283223",
                "Phone does not match entered phone");
        Assert.assertEquals(profilePage.getCityInput().getAttribute("value"),
                "Bucaramanga",
                "City does not match entered city");
        Assert.assertEquals(profilePage.getCountryInput().getAttribute("value"),
                "Spain",
                "Country does not match entered country");
        Assert.assertEquals(profilePage.getUrlTwitterInput().getAttribute("value"),
                "https://twitter.com/profile/milan1232",
                "Twitter url does not match entered twitter url");
        Assert.assertEquals(profilePage.getUrlGitHubInput().getAttribute("value"),
                "https://github.com/Jovana0302",
                "GitHub url does not match entered GitHub url");
        navPage.getLogoutButton()
                .click();
    }

}
