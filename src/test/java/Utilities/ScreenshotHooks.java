package Utilities;

import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.junit.Cucumber;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import utilities.DriverSetup;
import utilities.PropertyFileSetup;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

public class ScreenshotHooks {
    protected static WebDriver driver;
    protected static Scenario scenario;

    public ScreenshotHooks() {
        driver = DriverSetup.driver;

    }



    public void takeScreenshotBeforeStep(Scenario scenario) {
        ScreenshotHooks.scenario = scenario;
        // Take screenshot before each step
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        saveScreenshotToFile(screenshot, "before_step_" + System.currentTimeMillis() + ".png");
    }

    public void takeScreenshotAfterStep(Scenario scenario) {
        ScreenshotHooks.scenario = scenario;
        // Take screenshot after each step
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        saveScreenshotToFile(screenshot, "AfterStep_" + System.currentTimeMillis() + ".png");
    }


    public void takeScreenshotAfterFilure() {

        // Take screenshot after each step
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        saveScreenshotToFile(screenshot, "Scenario failed " + System.currentTimeMillis() + ".png");
    }




    private void saveScreenshotToFile(byte[] screenshot, String fileName) {
        try {
            FileUtils.writeByteArrayToFile(new File(System.getProperty("user.dir")+"/src/test/ScreenShots/"+ Cucumber.class.getPackageName()+"."+this.scenario.getName()+"." + "_date"+ LocalDate.now()+"/"+ fileName ), screenshot);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
