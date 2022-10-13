package test.selenium.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverFactory {

    private WebDriver driver;

    private final static WebDriverFactory instance = new WebDriverFactory();

    private WebDriverFactory() {
        WebDriverManager.chromedriver().setup();
    }

    public static WebDriverFactory getInstance() {
        return instance;
    }

    public WebDriver getActiveDriver() {
        if (driver != null) {
            return driver;
        } else {
            return getDriver();
        }
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    private WebDriver getDriver() {
        this.driver = new ChromeDriver();
        return driver;
    }

}
