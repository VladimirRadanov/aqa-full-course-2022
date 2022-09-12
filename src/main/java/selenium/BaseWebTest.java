package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

//TODO: load https://www.ukr.net/ or any mail service
//TODO: and login into mail
public class BaseWebTest {
    public WebDriver webDriver = null;

    String loginFrameName = "mail widget";
    String loginInputXPath = "//input[@name='login']";
    String passwordInputXPath = "//input[@name='password']";
    String emailAccountXPath = "//p[@class='account__email']";
    String inboxLinkXPath = "//a[@class='service__entry service__entry_mail']";

    public void loadGooglePage() {
        ChromeDriver chromeDriver = null;
        try {
            WebDriverManager.chromedriver().setup();

            chromeDriver = new ChromeDriver();
            chromeDriver.get("https://google.com/");

            List<WebElement> buttons = chromeDriver.findElements(By.tagName("button"));
            buttons.get(3).click();

            WebElement searchBar = chromeDriver.findElement(By.name("q"));
            searchBar.click();
            searchBar.sendKeys("test parametrization");
            WebElement searchButton = chromeDriver.findElement(By.name("btnK"));
            searchButton.click();
        } finally {
            if (chromeDriver != null) {
                chromeDriver.quit();
            }
        }
    }

    public void startWebBrowser() {
        try {
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void closeWebBrowser() {
        if (webDriver != null)
            try {
                webDriver.quit();
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    public void goToUrl(String url) {
        webDriver.get(url);
    }

    public void switchToLoginFrame() {
        webDriver.switchTo().frame(webDriver.findElement(By.name(loginFrameName)));
    }

    public void switchToLastTab() {
        ArrayList<String> tabs = new ArrayList<>(webDriver.getWindowHandles());
        webDriver.switchTo().window(tabs.get(tabs.size() - 1));
    }

    public void switchToDefaultContent() {
        webDriver.switchTo().defaultContent();
    }

    public void enterLoginPassword(String login, String password) {
        switchToLoginFrame();
        //enter login and password
        webDriver.findElement(By.xpath(loginInputXPath)).sendKeys(login);
        webDriver.findElement(By.xpath(passwordInputXPath)).sendKeys(password + Keys.ENTER);
        switchToDefaultContent();
    }

    public void checkEmailAccount(String login) {
//        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(3));
        Utilities.treadWaiter(2);
        switchToLoginFrame();

        /*WebElement loggedEmailElement = wait.until(ExpectedConditions.
                visibilityOf(webDriver.findElement(By.xpath(loggedEmailXPath))));*/

        String loggedEmail = webDriver.findElement(By.xpath(emailAccountXPath)).getText();

        if ((login + "@ukr.net").equals(loggedEmail)) System.out.println("Email account is CORRECT:\t" + loggedEmail);
        else System.out.println("Email account is INCORRECT:\t" + loggedEmail);

        switchToDefaultContent();
    }

    public void goToInbox() {
        switchToLoginFrame();
        webDriver.findElement(By.xpath(inboxLinkXPath)).click();
        switchToLastTab();
        switchToDefaultContent();
    }

    public void checkPageTitle(String login) {
        String pageTitle = webDriver.getTitle();

        if (pageTitle.contains(login)) System.out.println("Title is CORRECT:\t" + pageTitle);
        else System.out.println("Title is INCORRECT:\t" + pageTitle);
    }

}