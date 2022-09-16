package selenium.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverContainer {

    private final static WebDriverContainer instance = new WebDriverContainer();
    private final WebDriver driver;

    private WebDriverContainer() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    public static WebDriverContainer getInstance() {
        return instance;
    }

    public WebDriver getDriver() {
        return this.driver;
    }
}
