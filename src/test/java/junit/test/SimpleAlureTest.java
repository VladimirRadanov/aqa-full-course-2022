package junit.test;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;

public class SimpleAlureTest {

    @Test
    public void someTest() {
        someStep();
        someStepTwo();
    }

    @Step("Test step!")
    private void someStep() {
        System.out.println("aaa");
    }

    @Step("Test step!")
    private void someStepTwo() {
        System.out.println("bbb");
    }
}
