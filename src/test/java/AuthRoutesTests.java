import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRoutesTests extends BasicTest {

    @Test
    @Description("Forbid visits to home url if not authenticated")
    public void tc1_forbidVisitsToHomeUrlIfNotAuthenticated() {
        driver.get(baseUrl + "/home");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
                "Unauthenticated visit to home url");
    }

    @Test
    @Description("Forbid visits to profile url if not authenticated")
    public void tc2_forbidVisitsToProfileUrlIfNotAuthenticated() {
        driver.get(baseUrl + "/profile");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
                "Unauthenticated visit to profile url");
    }

    @Test
    @Description("Forbid visits to admin cities url if not authenticated")
    public void tc3_forbidVisitsToAdminCitiesUrlIfNotAuthenticated() {
        driver.get(baseUrl + "/admin/cities");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
                "Unauthenticated visit to admin cities url");
    }

    @Test
    @Description("Forbid visits to admin users url if not authenticated")
    public void tc4_forbidVisitsToAdminUsersUrlIfNotAuthenticated() {
        driver.get(baseUrl + "/admin/users");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
                "Unauthenticated visit to admin users url");
    }

}
