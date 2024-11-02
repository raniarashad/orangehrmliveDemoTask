package admin_tool_test.Admin;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/admin_tool_test/Admin/CreateAndDeleteAdmin.feature"},
        glue = {"admin_tool_test.Admin", "admin_tool_test/commonsteps"},
       // tags = "@test",
            plugin = {"pretty", "html:target/cucumber-reports"},
        monochrome = true)
public class Runner {
}
