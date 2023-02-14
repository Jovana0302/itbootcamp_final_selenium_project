import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTests extends BasicTest {

    @Test
    @Description("Set locale to ES")
    public void tc1_setLocaleToES() {
        navPage.getLanguageButton().click();
        navPage.getSpanishLanguageButton().click();
        Assert.assertTrue(navPage.getLandingPageHeading()
                .getText().contains("Página de aterrizaje"),
                "Language not changed to Spanish");
//        Assert.assertEquals(navPage.getLandingPageHeading().getText(),
//                "Página de aterrizaje",
//                "Language not changed to Spanish");
    }

    @Test
    @Description("Set locale to EN")
    public void tc2_setLocaleToEN() {
        navPage.getLanguageButton().click();
        navPage.getEnglishLanguageButton().click();
        Assert.assertTrue(navPage.getLandingPageHeading()
                        .getText().contains("Landing"),
                "Language not changed to English");
//        Assert.assertEquals(navPage.getLandingPageHeading().getText(),
//                "Landing",
//                "Language not changed to English");
    }

    @Test
    @Description("Set locale to CN")
    public void tc3_setLocaleToCN() {
        navPage.getLanguageButton().click();
        navPage.getChineseLanguageButton().click();
        Assert.assertTrue(navPage.getLandingPageHeading()
                        .getText().contains("首页"),
                "Language not changed to Chinese");
//        Assert.assertEquals(navPage.getLandingPageHeading().getText(),
//                "首页",
//                "Language not changed to Chinese");
    }

    @Test
    @Description("Set locale to FR")
    public void tc4_setLocaleToFR() {
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
