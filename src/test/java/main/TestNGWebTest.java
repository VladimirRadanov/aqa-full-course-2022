package main;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//TODO: add amazon.com tests like Rozetka tests
public class TestNGWebTest {

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
        System.out.println("this is test NG test");
        Assert.assertEquals(1, 0);
    }
}
