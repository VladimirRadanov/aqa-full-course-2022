package main;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RozetkaMainPageTests extends BaseTest {

    @BeforeEach
    public void preTest() {

    }

    @Test
    public void testRozetkaSearch() {
        page.loadPage();
        page.setSearchValue("Asus");
        page.performSearch();
        Assertions.assertTrue(page.getSearchResults().size() == 36, "Actual size:" + page.getSearchResults().size());
    }

    @Test
    public void testRozetkaCategories() {
        page.loadPage();
        page.switchToCategory("Ноутбуки та комп’ютери");
        Assertions.assertTrue(page.waitUntilUrl("https://rozetka.com.ua/ua/computers-notebooks/c80253/"), "URLs do not match!");
    }

    @AfterEach
    public void afterTest() throws InterruptedException {
        Thread.sleep(2000);
    }
}
