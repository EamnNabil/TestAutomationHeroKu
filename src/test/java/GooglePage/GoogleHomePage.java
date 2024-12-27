package GooglePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class GoogleHomePage  {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name = "q")
    private WebElement searchBox;

    @FindBy(xpath = "//ul[@jsname='bw4e9b']")
    private WebElement searchList;

    public GoogleHomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10 sec timeout
        PageFactory.initElements(driver, this);
    }

    public void navigateToGoogle() {
        driver.get("https://www.google.com/ncr");
    }

    public void searchFor(String searchTerm) {
        searchBox.sendKeys(searchTerm);
    }

    public String getThirdSearchResultTitle() {
        wait.until(ExpectedConditions.visibilityOf(searchList));
        List<WebElement> listItems = searchList.findElements(By.tagName("li"));
        return listItems.get(2).getText();
    }
}
