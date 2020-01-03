package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = {"html:target/cucumberHTML-report", "pretty", "json:target/cucumber.json"},
        features = {"src/test/resorces/uiFeatures/AddingOrder.feature"},
        glue = "stepDefs",
        dryRun = false,
        tags ="@tags=Test-12"

)
public class UITestRunner {

}
