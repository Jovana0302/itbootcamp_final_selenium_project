import jdk.jfr.Description;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CitiesTests extends BasicTest {

    @Test(priority=1)
    @Description("TC1 Visit admin cities page and list cities")
    public void visitAdminCitiesPageAndListCities() {
        navPage.getLoginButton().click();
        loginPage.getEmailInput()
                .sendKeys("admin@admin.com");
        loginPage.getPasswordInput()
                .sendKeys("12345");
        loginPage.getLoginButton()
                .click();
        navPage.getAdminButton()
                .click();
        navPage.getCitiesLink()
                .click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/admin/cities"),
                "Not on admin cities page");
    }

    @Test(priority=2)
    @Description("TC2 Check input types for create/edit new city")
    public void checkInputTypesForCreateEditNewCity() {
        navPage.getAdminButton()
                .click();
        navPage.getCitiesLink()
                .click();
        citiesPage.getNewItemButton()
                .click();
        citiesPage.waitForNewEditItemDialog();
        Assert.assertEquals(citiesPage.getNameInput().
                        getAttribute("type"), "text",
                "Wrong input type");
        citiesPage.getCancelButton().click();
    }

    @Test(priority=3)
    @Description("TC3 Create new city")
    public void createNewCity() {
        navPage.getAdminButton()
                .click();
        navPage.getCitiesLink()
                .click();
        citiesPage.getNewItemButton()
                .click();
        citiesPage.waitForNewEditItemDialog();
        citiesPage.getNameInput()
                .sendKeys("Jovana Cvetanovic's city");
        citiesPage.getSaveButton()
                .click();
        messagePopUpPage.waitForSuccessDialog();
        Assert.assertTrue(messagePopUpPage.getSuccessMessage()
                .getText().contains("Saved successfully"),
                "Wrong message");
    }

    @Test(priority=4)
    @Description("TC4 Edit city")
    public void editCity() {
        navPage.getAdminButton()
                .click();
        navPage.getCitiesLink()
                .click();
        citiesPage.getSearchInput()
                .sendKeys("Jovana Cvetanovic's city");
        citiesPage.waitForNumberOfRowsToBe(1);
        citiesPage.getEditButtonByRow(1)
                .click();
        citiesPage.getNameInput().sendKeys(Keys.CONTROL + "a");
        citiesPage.getNameInput().sendKeys(Keys.BACK_SPACE);
//        while(!citiesPage.getNameInput().getAttribute("value").equals("")){
//            citiesPage.getNameInput().sendKeys(Keys.BACK_SPACE);
//        }
        citiesPage.getNameInput()
                .sendKeys("Jovana Cvetanovic's city Edited");
        citiesPage.getSaveButton()
                .click();
        messagePopUpPage.waitForSuccessDialog();
        Assert.assertTrue(messagePopUpPage.getSuccessMessage()
                        .getText().contains("Saved successfully"),
                "Wrong message");
    }

    @Test(priority=5)
    @Description("TC5 Search city")
    public void searchCity() {
        navPage.getAdminButton()
                .click();
        navPage.getCitiesLink()
                .click();
        citiesPage.getSearchInput()
                .sendKeys("Jovana Cvetanovic's city Edited");
        citiesPage.waitForNumberOfRowsToBe(1);
        Assert.assertEquals(citiesPage
                        .getCellByRowAndColumn(1,2).getText(),
                "Jovana Cvetanovic's city Edited",
                "Wrong city");
    }

    @Test(priority=6)
    @Description("TC6 Delete city")
    public void deleteCity() {
        navPage.getAdminButton()
                .click();
        navPage.getCitiesLink()
                .click();
        citiesPage.getSearchInput()
                .sendKeys("Jovana Cvetanovic's city Edited");
        citiesPage.waitForNumberOfRowsToBe(1);
        Assert.assertEquals(citiesPage
                        .getCellByRowAndColumn(1,2).getText(),
                "Jovana Cvetanovic's city Edited",
                "Wrong city");
        citiesPage.getDeleteButtonByRow(1)
                .click();
        citiesPage.waitForDeleteDialog();
        citiesPage.getDeleteButton()
                .click();
        messagePopUpPage.waitForSuccessDialog();
        Assert.assertTrue(messagePopUpPage.getSuccessMessage()
                        .getText().contains("Deleted successfully"),
                "Wrong message");
    }

}
