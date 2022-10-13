package test.test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.Test;
import test.selenium.driver.WebDriverFactory;

public class SimpleAlureTest {

  @Test
  public void someTest() {
    WebDriverRunner.setWebDriver(WebDriverFactory.getInstance().getActiveDriver());
    WebDriverRunner.getWebDriver().get("https://rozetka.com.ua/");

    $("body > app-root > div > div > rz-header > rz-main-header > header > div > div > a > picture > img")
        .click();

  }
}
