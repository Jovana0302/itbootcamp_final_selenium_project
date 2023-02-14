import jdk.jfr.Description;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CitiesTests extends BasicTest {

    @Test
    @Description("Visit admin cities page and list cities")
    public void tc1_visitAdminCitiesPageAndListCities() {
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

    @Test
    @Description("Check input types for create/edit new city")
    public void tc2_checkInputTypesForCreateEditNewCity() {
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

    @Test
    @Description("Create new city")
    public void tc3_createNewCity() {
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

    @Test
    @Description("Edit city")
    public void tc4_editCity() {
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

    @Test
    @Description("Search city")
    public void tc5_searchCity() {
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

    @Test
    @Description("Delete city")
    public void tc6_deleteCity() {
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
