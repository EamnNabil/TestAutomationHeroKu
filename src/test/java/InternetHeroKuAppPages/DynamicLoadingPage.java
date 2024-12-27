package InternetHeroKuAppPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicLoadingPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//li/a[@href='/dynamic_loading']")
    public WebElement dynamicLoadingBtn;

    @FindBy(xpath = "//a[@href='/dynamic_loading/2']")
    public WebElement example2Link;

    @FindBy(xpath = "//div[@id='start']/button")
    public WebElement startBtn;

    @FindBy(xpath = "//div[@id='loading']/img")
    public WebElement loadingImage;

    @FindBy(xpath = "//h4[text()='Hello World!']")
    public WebElement successMessage;

    public DynamicLoadingPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10 sec timeout
        PageFactory.initElements(driver, this);
    }

    public void clickDynamicLoading() {
        dynamicLoadingBtn.click();
    }
    public void clickExample2(){
        wait.until(ExpectedConditions.visibilityOf(example2Link));
        example2Link.click();
    }
    public void clickStartLoading() {
        wait.until(ExpectedConditions.elementToBeClickable(startBtn));
        startBtn.click();
    }
    public void waitUntilLoadingIsFinished() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading")));
     //   wait.until(ExpectedConditions.visibilityOf(successMessage));

    }
}
