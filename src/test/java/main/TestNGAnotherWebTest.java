package main;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGAnotherWebTest extends BaseTest {

    @BeforeClass
    public static void setup() {
        System.out.println("===================");
    }

    @BeforeMethod
    public void beforeEachTest() {
        driver.get("https://google.com/");
    }

    @Test(dataProvider = "myProvider")
    public void testNgTest01(String input, String inputOther) {
        System.out.println(input.equals(inputOther));
    }

    @DataProvider(name = "myProvider")
    public Object[][] providerMethod() {
        return new Object[][]{
                {"value1", "value1"}, //run 1
                {"value2", "value1"}  //run 2
        };
    }

    @Test
    public void testNgTest02() {
        System.out.println("this is test NG test");
    }

    @Test
    public void testNgTest03() {
        driver.get("https://amazon.com/");
    }


}
