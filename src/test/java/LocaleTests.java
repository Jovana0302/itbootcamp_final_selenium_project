import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTests extends BasicTest {

    @Test(priority=1)
    @Description("TC1 Set locale to ES")
    public void setLocaleToES() {
        navPage.getLanguageButton().click();
        navPage.getSpanishLanguageButton().click();
        Assert.assertTrue(navPage.getLandingPageHeading()
                .getText().contains("Página de aterrizaje"),
                "Language not changed to Spanish");
//        Assert.assertEquals(navPage.getLandingPageHeading().getText(),
//                "Página de aterrizaje",
//                "Language not changed to Spanish");
    }

    @Test(priority=2)
    @Description("TC2 Set locale to EN")
    public void setLocaleToEN() {
        navPage.getLanguageButton().click();
        navPage.getEnglishLanguageButton().click();
        Assert.assertTrue(navPage.getLandingPageHeading()
                        .getText().contains("Landing"),
                "Language not changed to English");
//        Assert.assertEquals(navPage.getLandingPageHeading().getText(),
//                "Landing",
//                "Language not changed to English");
    }

    @Test(priority=3)
    @Description("TC3 Set locale to CN")
    public void setLocaleToCN() {
        navPage.getLanguageButton().click();
        navPage.getChineseLanguageButton().click();
        Assert.assertTrue(navPage.getLandingPageHeading()
                        .getText().contains("首页"),
                "Language not changed to Chinese");
//        Assert.assertEquals(navPage.getLandingPageHeading().getText(),
//                "首页",
//                "Language not changed to Chinese");
    }

    @Test(priority=4)
    @Description("TC4 Set locale to FR")
    public void setLocaleToFR() {
        navPage.getLanguageButton().click();
        navPage.getFrenchLanguageButton().click();
        Assert.assertTrue(navPage.getLandingPageHeading()
                        .getText().contains("Page d'atterrissage"),
                "Language not changed to French");
//        Assert.assertEquals(navPage.getLandingPageHeading().getText(),
//                "Page d'atterrissage",
//                "Language not changed to French");
    }

}
