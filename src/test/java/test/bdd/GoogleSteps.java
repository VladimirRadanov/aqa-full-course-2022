package test.bdd;


import org.springframework.beans.factory.annotation.Autowired;
import test.dto.ResultsDto;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import test.main.util.DataHolder;
import org.openqa.selenium.WebDriver;
import test.selenium.GooglePage;
import test.selenium.driver.WebDriverFactory;

public class GoogleSteps {

    @Autowired
    private DataHolder dataHolder;

    private final static String SEARCH_PATTERN = "which country is %s";

    private WebDriver driver = WebDriverFactory.getInstance().getActiveDriver();
    private GooglePage googlePage = new GooglePage(driver);

    @When("I load google page")
    public void loadGooglePage() {
        googlePage.loadPage();
        googlePage.acceptCookies();
    }

    @When("I google for clients {string} nationality")
    public void googlePersonNationality(String alias) {
        ResultsDto person = dataHolder.get(alias, ResultsDto.class);
        String nat = person.getResults().get(0).getNat();
        googlePage.setSearchValue(String.format(SEARCH_PATTERN, nat));
        googlePage.pressSearchButton();
    }

    @Then("Some search result is displayed")
    public void someSearchResultIsDisplayed() {
        System.out.println(googlePage.getFullCountryName());
    }

    @When("I go back")
    public void iGoBack() {

        googlePage.goBack();
    }
}
