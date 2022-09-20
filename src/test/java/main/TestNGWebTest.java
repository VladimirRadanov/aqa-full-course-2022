package main;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGWebTest extends BaseTest {

    @BeforeClass
    public static void setup() {
        System.out.println("===================");
    }

    @BeforeMethod
    public void beforeEachTest() {
        System.out.println(">>>>>>>");
    }

    @Test
    public void testNgTest01() {
        System.out.println("this is test NG test");
    }

    @Test
    public void testNgTest02() {
        System.out.println("this is test NG test");
    }

    @Test
    public void testNgTest03() {
        driver.get("https://twitter.com/");
    }

}
