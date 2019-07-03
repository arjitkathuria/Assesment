import org.testng.Assert;
import org.testng.annotations.Test;
import ui.pages.BaseRunner;
import ui.pages.HomePage;

public class HomeTestCases extends BaseRunner {
    HomePage homePage;

    @Test
    public void testHomePageUiElemnts() {
        homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isNavBarVisible(), "Navigation bar not visible in home page");
        int expectedNavLinks = 9;
        Assert.assertEquals(expectedNavLinks, homePage.getNavBarlinksSize(), "Size of Navbar links in home" +
                "page mismatch");
        Assert.assertTrue(homePage.isMashreqNewsFielsVisible(), "Mashreq news field not visible in homepage");
    }

    @Test
    public void testContactUsRedirection() {
        homePage = new HomePage(driver);
        homePage.clickOnContactUsLink();
        Assert.assertTrue(driver.getCurrentUrl().contains("contactus"), String.format("Current Url" +
                "is not Contact us page it is %s", driver.getCurrentUrl()));
    }
}
