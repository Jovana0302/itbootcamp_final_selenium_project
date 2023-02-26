import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRoutesTests extends BasicTest {

    @Test(priority=1)
    @Description("TC1 Forbid visits to home url if not authenticated")
    public void forbidVisitsToHomeUrlIfNotAuthenticated() {
        driver.get(baseUrl + "/home");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
                "Unauthenticated visit to home url");
    }

    @Test(priority=2)
    @Description("TC2 Forbid visits to profile url if not authenticated")
    public void forbidVisitsToProfileUrlIfNotAuthenticated() {
        driver.get(baseUrl + "/profile");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
                "Unauthenticated visit to profile url");
    }

    @Test(priority=3)
    @Description("TC3 Forbid visits to admin cities url if not authenticated")
    public void forbidVisitsToAdminCitiesUrlIfNotAuthenticated() {
        driver.get(baseUrl + "/admin/cities");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
                "Unauthenticated visit to admin cities url");
    }

    @Test(priority=4)
    @Description("TC4 Forbid visits to admin users url if not authenticated")
    public void forbidVisitsToAdminUsersUrlIfNotAuthenticated() {
        driver.get(baseUrl + "/admin/users");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
                "Unauthenticated visit to admin users url");
    }

}
