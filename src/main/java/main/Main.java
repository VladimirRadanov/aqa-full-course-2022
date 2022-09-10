package main;

import selenium.BaseWebTest;
import selenium.Utilities;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String... args) {
        //test data:
        String url = "https://ukr.net";
        String login = "tft";
        String password = "p@ssw0rd2022";

        BaseWebTest baseWebTest = new BaseWebTest();

        baseWebTest.startWebBrowser();
        baseWebTest.goToUrl(url);
        baseWebTest.enterLoginPassword(login, password);
        baseWebTest.checkEmailAccount(login);
        baseWebTest.goToInbox();
        baseWebTest.checkPageTitle(login);
//        Utilities.treadWaiter(3);
        baseWebTest.closeWebBrowser();
    }

    public static void someMethod() throws FileNotFoundException {
        someMethod("some_string");
    }

    public static void someMethod(String input) {
        someMethod(input, 0);
    }

    public static void someMethod(String input, int amount) {
        someMethod(input, amount, false);
    }

    public static void someMethod(String input, int amount, boolean isTrue) {

    }

    public static class A {
        public void smth() {
            System.out.println("this is A");
        }
    }

    public static class B extends A {

    }

    public static class C extends B {
        @Override
        public void smth() {
            System.out.println("this is C");
        }
    }

    public static class D extends C {

    }
}