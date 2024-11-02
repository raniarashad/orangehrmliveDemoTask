package admin_tool_test.Admin;

import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

import utilities.DriverSetup;
import utilities.PropertyFileSetup;

public class Hooks {
    protected WebDriver driver;

    @Before
    public void initiateTest() throws Exception {
        PropertyFileSetup.propInitiate();

        DriverSetup.driverInitiate("chrome", "URL");

        driver = DriverSetup.driver;
    }

    //   @After
//    public void endTest()
//    {
//        driver.close();
//    }


}
