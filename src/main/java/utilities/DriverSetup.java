package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSetup
{
    public static WebDriver driver;
    public static void chromeDriverInitiate(String urlTxt) {
       /*
        String url = PropertyFileSetup.props.getProperty(urlTxt);
        System.setProperty(
                "webdriver.chrome.driver", System.getProperty("user.dir") + "/resources/driverbinaries/chromedriver.exe");
       */

       // ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.addArguments("--disable-site-isolation-trials");
        //chromeOptions.addArguments("--incognito");
        //chromeOptions.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.IGNORE);
        //driver = new ChromeDriver(chromeOptions);

    }
    public static void driverInitiate(String browser,String urlTxt)
    {
        String url = PropertyFileSetup.props.getProperty(urlTxt);
        if (browser.equals("chrome"))
        {
            WebDriverManager.chromedriver().setup();
           driver = new ChromeDriver();
            //ChromeOptions chromeOptions = new ChromeOptions();
            //chromeOptions.addArguments("--incognito");
           // driver = new ChromeDriver(chromeOptions);
        }
        else if (browser.equals("firefox"))
        {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        else if (browser.equals("edge"))
        {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        else
        {
            System.out.println("Browser is not Supported");
        }
        driver.manage().window().maximize();
        driver.get(url);
    }
}
