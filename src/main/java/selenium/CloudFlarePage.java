package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

// TODO: go to sign in form in cloudflare
// TODO: wait until sign in for is visible with explicit wait (web driver wait)
// TODO: fill in password filed
// TODO: check all password params to be green
public class CloudFlarePage {

    private final WebDriver driver;

    public CloudFlarePage(WebDriver driver) {
        this.driver = driver;
    }

    public void loadPage() {
        driver.get("https://www.cloudflare.com/");
    }

    public WebElement waitForAcceptCookiesBtn() {
        return new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("onetrust-accept-btn-handler")));
    }
}
