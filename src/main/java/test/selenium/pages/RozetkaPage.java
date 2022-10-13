package test.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class RozetkaPage {

    private final WebDriver driver;
    public final static String URL = "https://rozetka.com.ua/ua/";

    public RozetkaPage(WebDriver driver) {
        this.driver = driver;
    }

    public void loadPage() {
        driver.get(URL);
    }

    public void setSearchValue(String searchValue) {
        WebElement searchContainer = driver.findElement(By.name("search"));
        searchContainer.clear();
        searchContainer.sendKeys(searchValue);
    }

    public void performSearch() {
        WebElement searchContainer = driver.findElement(By.name("search"));
        searchContainer.sendKeys(Keys.RETURN);
    }

    public void switchToCategory(String categoryName) {
        WebElement catElement = driver.findElement(By.linkText(categoryName));
        catElement.click();
    }

    public void waitForSearchResults(int amount) {
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.numberOfElementsToBeMoreThan(
                        By.className("catalog-grid__cell"), amount));
    }

    public List<WebElement> getSearchResults() {
        return new WebDriverWait(driver, Duration.ofSeconds(45))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("catalog-grid__cell")));
    }

    public boolean waitUntilUrl(String expectedUrl) {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlToBe(expectedUrl));
    }
}
