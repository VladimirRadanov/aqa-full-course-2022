package main;

import org.junit.jupiter.api.AfterAll;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import selenium.driver.WebDriverFactory;
import selenium.pages.RozetkaPage;

public abstract class BaseTest {

    protected final RozetkaPage page;
    protected final WebDriver driver;

    public BaseTest() {
        this.driver = WebDriverFactory.getInstance().getActiveDriver();
        this.page = new RozetkaPage(driver);
    }

    @AfterAll
    public static void tearDown() {
        WebDriverFactory.getInstance().quitDriver();
    }

    @AfterSuite
    public void smth() {
        driver.quit();
    }
}
