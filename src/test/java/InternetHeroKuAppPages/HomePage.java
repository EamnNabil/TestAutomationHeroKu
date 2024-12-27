package InternetHeroKuAppPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//li/a[@href='/upload']")
    public WebElement fileUploadBtn;

    @FindBy(xpath = "//li/a[@href='/dynamic_loading']")
    public WebElement dynamicLoadingBtn;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10 sec timeout
        PageFactory.initElements(driver, this);
    }
    public void navigateToInternetHeroKuApp() {
        driver.get("https://the-internet.herokuapp.com/");
    }
    public void clickFileUpLoad(){
        fileUploadBtn.click();
    }
    public void clickDynamicLoad(){dynamicLoadingBtn.click();}

}
