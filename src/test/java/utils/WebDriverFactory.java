package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class WebDriverFactory {

    // Enum for Browser Types
    public enum BrowserType {
        CHROME,
        FIREFOX,
        EDGE,
        SAFARI
    }

    private final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private final BrowserType browserType;

    // Constructor to initialize browser type
    public WebDriverFactory(BrowserType browserType) {
        this.browserType = browserType;
    }

    // Method to create WebDriver based on the specified browser
    public WebDriver createDriver() {
        switch (browserType) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized"); // Start maximized
                driver.set(new ChromeDriver(chromeOptions));
                break;

            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--width=1920", "--height=1080");
                driver.set(new FirefoxDriver(firefoxOptions));
                break;

            case EDGE:
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--start-maximized");
                driver.set(new EdgeDriver(edgeOptions));
                break;

            case SAFARI:
                WebDriverManager.safaridriver().setup();
                driver.set(new SafariDriver());
                break;

            default:
                throw new IllegalArgumentException("Unsupported browser: " + browserType);
        }

        // Implicit wait (optional)
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        return driver.get();
    }

    // Quit the WebDriver instance
    public void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}

