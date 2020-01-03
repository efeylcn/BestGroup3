package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = {"html:target/cucumberHTML-report", "pretty", "json:target/cucumber.json"},
        features = {"src/test/resources/Features/UI_Post.feature"},
        glue = "stepDefs",
        dryRun = false,
        tags ="@tag=TEST-1"

)
public class UITestRunner {

}
