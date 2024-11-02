//package API;
//
//import io.cucumber.java.Before;
//import org.openqa.selenium.WebDriver;
//import utilities.Constants;
//import utilities.DriverSetup;
//import utilities.PropertyFileSetup;
//
//public class Hooks
//{
//    protected WebDriver driver;
//    @Before
//    public void initiateTest() throws Exception {
//        PropertyFileSetup.propInitiate();
//        if(Constants.environment.equals("staging1"))
//        {
//            DriverSetup.driverInitiate("chrome","AdminToolStagingURL");
//        }
//        else if(Constants.environment.equals("staging2"))
//        {
//            DriverSetup.driverInitiate("chrome","AdminToolStaging2URL");
//        }
//        else if (Constants.environment.equals("pre-production"))
//        {
//            DriverSetup.driverInitiate("chrome","AdminToolPreproductionURL");
//        }
//        else if(Constants.environment.equals("production"))
//        {
//            DriverSetup.driverInitiate("chrome","AdminToolProductionURL");
//        }
//        driver = DriverSetup.driver;
//    }
//
// //   @After
////    public void endTest()
////    {
////        driver.close();
////    }
//
//
//}
