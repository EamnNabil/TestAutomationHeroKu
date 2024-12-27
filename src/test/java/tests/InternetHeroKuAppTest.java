package tests;

import InternetHeroKuAppPages.DynamicLoadingPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import InternetHeroKuAppPages.HomePage;
import InternetHeroKuAppPages.UploadPage;

public class InternetHeroKuAppTest extends BaseTest {

    @Test
    public void tc02_testFileUpload() {
        HomePage homePage = new HomePage(driver);
        UploadPage uploadPage = new UploadPage(driver);
        homePage.navigateToInternetHeroKuApp();
        homePage.clickFileUpLoad();
        uploadPage.selectImage();
        uploadPage.clickUpload();
        WebElement UploadSuccessMessage = uploadPage.headerBeforeUpload;  // Replace with actual locator
        String actualText = UploadSuccessMessage.getText();
        Assert.assertEquals(actualText, "File Uploaded!", "Upload failed or message mismatch");

    }

    @Test
    public void tc03_testDynamicLoading() {
        HomePage homePage = new HomePage(driver);
        DynamicLoadingPage dynamicLoadingPage = new DynamicLoadingPage(driver);

        homePage.navigateToInternetHeroKuApp();
        dynamicLoadingPage.clickDynamicLoading();
        dynamicLoadingPage.clickExample2();
        dynamicLoadingPage.clickStartLoading();
        dynamicLoadingPage.waitUntilLoadingIsFinished();

        WebElement LoadingSuccessMessage = dynamicLoadingPage.successMessage;
        String actualText = LoadingSuccessMessage.getText();
        Assert.assertEquals(actualText, "Hello World!", "Loading success message mismatch");
    }
}
