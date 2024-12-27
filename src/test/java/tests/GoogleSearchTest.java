package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import GooglePage.GoogleHomePage;

public class GoogleSearchTest extends BaseTest {

    @Test
    public void tc01_testGoogleSearch() {
        GoogleHomePage googleHomePage = new GoogleHomePage(driver);

        googleHomePage.navigateToGoogle();
        googleHomePage.searchFor("selenium webdriver");

        String thirdResultTitle = googleHomePage.getThirdSearchResultTitle();
        System.out.println("Third Result: " + thirdResultTitle);

        Assert.assertTrue(thirdResultTitle.toLowerCase().contains("what is selenium webdriver"),
                "Third result does not contain expected text.");
    }
}
