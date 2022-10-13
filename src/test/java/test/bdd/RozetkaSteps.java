package test.bdd;

import static org.hamcrest.MatcherAssert.assertThat;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import test.main.util.DataHolder;
import test.selenium.driver.WebDriverFactory;
import test.selenium.pages.RozetkaPage;

public class RozetkaSteps {

  private final WebDriver driver = WebDriverFactory.getInstance().getActiveDriver();
  private RozetkaPage rozetkaPage = new RozetkaPage(driver);

  @Autowired
  private DataHolder dataHolder;

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

  @Then("i see at least {int} search results")
  public void checkResultsCount(int amount) {
    assertThat("Search results count doest not match exceed expected", rozetkaPage.getSearchResults().size(),
        Matchers.greaterThanOrEqualTo(amount));
  }
}
