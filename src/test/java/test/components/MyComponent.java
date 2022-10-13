package test.components;

import org.springframework.stereotype.Component;

@Component
public class MyComponent {

    public void printString(String s) {
        System.out.println(s);
    }
}
