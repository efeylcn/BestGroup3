package Pages.ServerPress.API.ServerPress.Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumberHTML-report", "pretty", "json:target/cucumber.json"},
        features ={"src/test/resources/UIFeatures"},//{"C:\\Users\\jan\\IdeaProjects\\API\\src\\test\\resources\\UIFeatures"},
        glue ="API/ServerPress/stepDefenitions",
                // "C:\\Users\\jan\\IdeaProjects\\API\\src\\test\\java\\API\\ServerPress\\stepDefenitions",
        //C:\Users\jan\IdeaProjects\API\src\test\resources\Configuration\configuration.properties
        dryRun = false,
        tags = {"@TEC-888"}
       // C:\Users\jan\IdeaProjects\API\
)
public class runnerCLass {


}
