package main;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class RozetkaCategoriesTests extends BaseTest {

    @ParameterizedTest
    @MethodSource("provideStringsForIsBlank")
    public void someTest(String paramOne, Boolean paramTwo) throws InterruptedException {
        System.out.println(paramOne);
        System.out.println(paramTwo);
    }

    private static Stream<Arguments> provideStringsForIsBlank() {
        return Stream.of(
                Arguments.of(null, true),
                Arguments.of("", true),
                Arguments.of("  ", true),
                Arguments.of("not blank", false)
        );
    }
}
