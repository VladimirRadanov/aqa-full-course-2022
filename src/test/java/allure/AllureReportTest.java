package allure;

import static org.junit.jupiter.api.Assertions.assertTrue;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import java.util.Random;
import org.junit.jupiter.api.Test;

public class AllureReportTest {

  @Test
  @Description("This test is here to show a successful flow")
  @Severity(SeverityLevel.BLOCKER)
  public void successfulTest() {
    meaninglessStep("thou  ");
    anotherMeaninglessStep("may pass!");
    assertTrue(randomNumber(false) <= 500);
  }

  @Test
  @Description("This test is here to show a failed flow")
  @Severity(SeverityLevel.CRITICAL)
  public void failedTest() {
    meaninglessStep("thou  ");
    anotherMeaninglessStep("shall not pass!");
    assertTrue(randomNumber(false) > 500);
  }

  @Test
  @Description("This test is here to show a broken flow")
  @Severity(SeverityLevel.MINOR)
  public void brokenTest() {
    meaninglessStep("Oh no ");
    anotherMeaninglessStep("I'm broken!");
    assertTrue(randomNumber(true) <= 500);
  }

  @Step("Meaningless step that prints things. Input: {input}")
  private void meaninglessStep(String input) {
    System.out.println("This methods just print stuff " + input);
  }

  @Step("The test says \"{input}\"")
  private void anotherMeaninglessStep(String input) {
    System.out.println("Another methods that just prints stuff " + input);
  }

  @Step("Generate random number which is nullable")
  private Integer randomNumber(boolean isNull) {
    if (isNull) {
      return null;
    } else {
      return new Random().nextInt(500);
    }
  }

}
