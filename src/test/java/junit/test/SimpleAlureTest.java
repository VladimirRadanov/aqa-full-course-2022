package junit.test;

import org.junit.jupiter.api.Test;

public class SimpleAlureTest {

    public void someTest() {
        someStep();
        someStepTwo();
    }

    private void someStep() {
        System.out.println("aaa");
    }

    private void someStepTwo() {
        System.out.println("bbb");
    }
}
