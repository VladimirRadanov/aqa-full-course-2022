package cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/feature",
    glue = "bdd",
    plugin = {"pretty", "json:target/cucumber-reports/Cucumber.json",
        "html:target/cucumber-report.html", "cucumber.MyCucuesPlugin"})
@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("feature")
public class CucumberTest {
}
