package API;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/API/CandidateManagement.feature"},
        glue = {"API", "admin_tool_test/commonsteps"},
       // tags = "@test",
            plugin = {"pretty", "html:target/cucumber-reports"},
        monochrome = true)
public class API_Runner {
}
