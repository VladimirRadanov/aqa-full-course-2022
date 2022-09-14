package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//TODO: load https://www.ukr.net/ or any mail service
//TODO: and login into mail
public class BaseWebTest {

    public void loadGooglePage() {
        ChromeDriver chromeDriver = null;
        try {
            WebDriverManager.chromedriver().setup();

            chromeDriver = new ChromeDriver();
            chromeDriver.get("https://ukr.net/");

            WebElement iFrameElement = chromeDriver.findElement(By.name("mail widget"));
            chromeDriver.switchTo().frame(iFrameElement);

            WebElement login = chromeDriver.findElement(By.name("login"));
            login.click();

            chromeDriver.switchTo().defaultContent();

            WebElement iFrameParent = chromeDriver.findElement(By.id("login-frame-wraper"));
        } finally {
            if (chromeDriver != null) {
                chromeDriver.quit();
            }
        }
    }
}


