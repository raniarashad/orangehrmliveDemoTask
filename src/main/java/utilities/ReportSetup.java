package utilities;

import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ReportSetup {
    public static void addScreenshotAndLogStep(Scenario scenario, String step, WebDriver driver){
        scenario.log(step);
        try {
            ReportSetup.addScreenshot(scenario, driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void logStep(Scenario scenario, String step){
        scenario.log(step);
    }


    public static void addScreenshot(Scenario scenario, WebDriver driver) throws IOException {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        byte[] fileContent = FileUtils.readFileToByteArray(screenshot);
        scenario.attach(fileContent, "image/png", "screenshot");
    }
}
