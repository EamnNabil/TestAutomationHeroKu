package tests;

import listeners.ScreenshotListener;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import utils.WebDriverFactory;
import utils.WebDriverFactory.BrowserType;

@Listeners(ScreenshotListener.class)
public class BaseTest {
    protected WebDriver driver;
    private WebDriverFactory webDriverFactory;

    @BeforeMethod
    public void setUp(ITestContext context) {
        if (driver == null) {
            webDriverFactory = new WebDriverFactory(BrowserType.CHROME);  // BrowserType is passed here
            driver = webDriverFactory.createDriver();
        }

        context.setAttribute("driver", driver);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            webDriverFactory.quitDriver();
        }
    }
}
