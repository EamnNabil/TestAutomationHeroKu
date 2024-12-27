package listeners;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotListener implements ITestListener {

    private WebDriver driver;

    public ScreenshotListener() {
    }

    @Override
    public void onTestStart(ITestResult result) {
        driver = (WebDriver) result.getTestContext().getAttribute("driver");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        if (driver != null) {
            // Take screenshot on failure
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String destFile = "screenshots/" + result.getName() + "_" + timestamp + ".png";
            File destFileObj = new File(destFile);

            try {
                FileUtils.copyFile(srcFile, destFileObj);
                Reporter.log("Screenshot saved at: " + destFileObj.getAbsolutePath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // Can log or handle success scenario if needed
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // Can log or handle skipped tests if needed
    }

    @Override
    public void onStart(ITestContext context) {
        // Optional: Setup tasks before all tests
    }

    @Override
    public void onFinish(ITestContext context) {
        // Optional: Cleanup after all tests
    }


}
