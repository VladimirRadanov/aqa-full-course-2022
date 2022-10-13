package test.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GooglePage {

    private final WebDriver driver;

    public GooglePage(WebDriver driver) {
        this.driver = driver;
    }

    public void loadPage() {
        driver.get("https://google.com/");
    }

    public void setSearchValue(String searchContent) {
        WebElement searchQueue = driver.findElement(By.name("q"));
        searchQueue.clear();
        searchQueue.sendKeys(searchContent);
    }

    public void pressSearchButton() {
        clickSuitable(driver.findElements(By.name("btnK")));
    }

    public void pressFeelingLucky() {
        clickSuitable(driver.findElements(By.name("btnI")));
    }

    public void acceptCookies() {
        driver.findElements(By.tagName("button")).get(3).click();
    }

    public void declineCookies() {
        driver.findElements(By.tagName("button")).get(2).click();
    }

    public String getFullCountryName() {
        return driver.findElement(By.xpath("//div[@data-tts='answers']/div")).getText();
    }

    private void clickSuitable(List<WebElement> buttons) {
        for (WebElement button : buttons) {
            try {
                button.click();
                break;
            } catch (Exception e) {

            }
        }
    }

    public void goBack() {
        driver.navigate().back();
    }
}
