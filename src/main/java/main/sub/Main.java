package main.sub;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import selenium.CloudFlarePage;
import selenium.GooglePage;

public class Main {

    public static void main(String... args) {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        try {
            GooglePage googlePage = new GooglePage(driver);
            testGoogleOne(googlePage);
            testGoogleTwo(googlePage);
            cloudFlareCookiesTest(new CloudFlarePage(driver));
        } finally {
            driver.quit();
        }
    }

    public static void cloudFlareCookiesTest(CloudFlarePage cloudFlarePage) {
        cloudFlarePage.loadPage();
        cloudFlarePage.waitForAcceptCookiesBtn().click();
    }

    public static void testGoogleOne(GooglePage googlePage) {
        googlePage.loadPage();
        googlePage.acceptCookies();
        googlePage.setSearchValue("news Ukraine");
        googlePage.pressSearchButton();
    }

    public static void testGoogleTwo(GooglePage googlePage) {
        googlePage.loadPage();
        googlePage.setSearchValue("news World");
        googlePage.pressFeelingLucky();
    }

}