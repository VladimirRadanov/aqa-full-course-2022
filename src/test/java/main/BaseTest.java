package main;

import org.junit.jupiter.api.AfterAll;
import selenium.driver.WebDriverFactory;
import selenium.pages.RozetkaPage;

public abstract class BaseTest {

    protected final RozetkaPage page;

    public BaseTest() {
        this.page = new RozetkaPage(WebDriverFactory.getInstance().getActiveDriver());
    }

    @AfterAll
    public static void tearDown() {
        WebDriverFactory.getInstance().quitDriver();
    }
}
