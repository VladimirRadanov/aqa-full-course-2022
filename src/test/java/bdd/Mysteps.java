package bdd;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.driver.WebDriverFactory;

import java.time.Duration;

public class Mysteps {

    private WebDriver driver = WebDriverFactory.getInstance().getActiveDriver();

    @Given("load {string} page")
    public void myTestStep(String pageUrl) {
        driver.get(pageUrl);
    }

    @When("my current url is {string}")
    public void iHaveMyResult(String currentUrl) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.urlToBe(currentUrl));
    }

    @Then("quit driver")
    public void quitDriver() {
        WebDriverFactory.getInstance().quitDriver();
    }
}
