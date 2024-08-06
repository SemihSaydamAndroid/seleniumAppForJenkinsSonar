package parallel;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/resources/parallel/",
        plugin = {"json:target/cucumber-reports/cucumber.json", "pretty",
        "html:target/cucumber-reports/cucumberReport.html"},
        glue = {"parallel", "base"})

public class RunCucumberIT {

}