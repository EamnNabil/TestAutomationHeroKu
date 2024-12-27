package InternetHeroKuAppPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UploadPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//input[@id='file-upload']")
    public WebElement chooseFileBtn;

    @FindBy(xpath = "//input[@id='file-submit']")
    public WebElement submitUploadBtn;

    @FindBy(tagName = "h3")
    public WebElement headerBeforeUpload;

    String imagePath = System.getProperty("user.dir") + "/src/test/resources/Selenium_Logo.png";

    public UploadPage(WebDriver driver) {
        super();
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10 sec timeout
        PageFactory.initElements(driver, this);
    }
    public void selectImage(){
        wait.until(ExpectedConditions.visibilityOf(chooseFileBtn));
        chooseFileBtn.sendKeys(imagePath);
    }
    public void clickUpload(){
        submitUploadBtn.click();
    }


}
