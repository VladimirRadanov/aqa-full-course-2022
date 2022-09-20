package bdd;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import selenium.driver.WebDriverFactory;
import selenium.pages.RozetkaPage;

public class RozetkaSteps {

    private final WebDriver driver = WebDriverFactory.getInstance().getActiveDriver();
    private RozetkaPage rozetkaPage = new RozetkaPage(driver);

    @Given("load ROZETKA page")
    public void loadPage() {
        rozetkaPage.loadPage();
        rozetkaPage.waitUntilUrl(RozetkaPage.URL);
    }

    @Given("i search for {string}")
    public void iSearchFor(String searchValue) {
        rozetkaPage.setSearchValue(searchValue);
        rozetkaPage.performSearch();
    }

    @When("search is completed")
    public void searchIsCompleted() {
        rozetkaPage.waitForSearchResults(1);
    }

    @Then("i see at least {long} search results")
    public void checkResultsCount(long amount) {
        Assertions.assertEquals(amount, rozetkaPage.getSearchResults().size(),
                "Search results count doest not match exceed expected");
    }
}
