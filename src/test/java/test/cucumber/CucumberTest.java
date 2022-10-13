package test.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/feature",
    glue = "test",
    plugin = {"pretty", "json:target/cucumber-reports/Cucumber.json",
        "html:target/cucumber-report.html", "test.cucumber.MyCucuesPlugin"})
public class CucumberTest {
}
