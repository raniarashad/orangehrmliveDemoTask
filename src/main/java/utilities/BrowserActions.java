package utilities;


import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class BrowserActions  {
    private static final Duration timeOut = Duration.ofSeconds(60);
    private static int counterOfActions = 0;


    public static void waitUntilWebElementIsPresent(By element, WebDriver driver){
            WebDriverWait wait = new WebDriverWait(driver, timeOut);
            try {
                wait.until(ExpectedConditions.visibilityOfElementLocated(element));
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());

            }
    }


    public static void waitUntilWebElementIsNotPresent(By element, WebDriver driver){
            WebDriverWait wait = new WebDriverWait(driver, timeOut);
            try {
                wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
    }

    public static String getdateOfToday(){
        // Get the current date
        LocalDate today = LocalDate.now();

        // Format the date to display only the date portion
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = today.format(formatter);
        return formattedDate;
    }




    public static void waitUntilWebElementBrClickable(By element, WebDriver driver){
            WebDriverWait wait = new WebDriverWait(driver, timeOut);
            try {
                wait.until(ExpectedConditions.elementToBeClickable(element));
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
    }

    public static void waitUntilWebElementBeNotClickable(By element, WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        try {
            wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(element)));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public static String waitThenGetWebElementAttribute(By element, WebDriver driver,String Attribute){
        BrowserActions.waitUntilWebElementIsPresent(element , driver);
        String AttributeOfElement= "";
        try {
             AttributeOfElement = driver.findElement(element).getAttribute(Attribute);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        takeScreenshot();

        return AttributeOfElement;
    }
    public static void waitUntilWebElementBeClickableThenClick(By element, WebDriver driver) throws InterruptedException {
        Thread.sleep(200);

        BrowserActions.waitUntilWebElementBrClickable(element, driver);
        try {
            BrowserActions.waitAndClickOnWebElement(element,driver);
            takeScreenshot();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
    public static void waitAndClickOnWebElementUsingJavaScript(By element, WebDriver driver) throws Exception {
        Thread.sleep(200);

        BrowserActions.waitUntilWebElementIsPresent(element, driver);
        try {
            WebElement ele = driver.findElement(element);
            JavascriptExecutor executor = (JavascriptExecutor)driver;
            executor.executeScript("arguments[0].click();", ele);
            takeScreenshot();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            throw new Exception("Can not click on webElement: " + element.toString(),e);
        }

    }
    public static void waitAndClickOnWebElement(By element, WebDriver driver) throws Exception {
        Thread.sleep(200);

        BrowserActions.waitUntilWebElementIsPresent(element, driver);
        try {
            driver.findElement(element).click();
            takeScreenshot();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            throw new Exception("Can not click on webElement: " + element.toString(),e);
        }
    }
    public static void ClickOnWebElement(By element, WebDriver driver) throws Exception {

        Thread.sleep(200);

        try {
            driver.findElement(element).click();
            takeScreenshot();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            throw new Exception("Can not click on webElement: " + element.toString(),e);
        }
    }
    public static void waitAndEnterTextInWebElement(String text, By element, WebDriver driver) throws Exception {
            BrowserActions.waitUntilWebElementIsPresent(element, driver);
            try {
                takeScreenshot();

                driver.findElement(element).clear();
                takeScreenshot();

                driver.findElement(element).sendKeys(text);
                takeScreenshot();

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
                throw new Exception("Can not enter text in webElement: " + element.toString(),e);
            }
    }

    public static void waitAndEnterIntegerInWebElement(int text, By element, WebDriver driver) throws Exception {
        BrowserActions.waitUntilWebElementIsPresent(element, driver);
        try {

            driver.findElement(element).clear();
            takeScreenshot();

            driver.findElement(element).sendKeys(String.valueOf(text));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            throw new Exception("Can not enter text in webElement: " + element.toString(),e);
        }
    }

    public static void waitAndClearTextIbWebElement(By element, WebDriver driver) throws Exception {
        BrowserActions.waitUntilWebElementIsPresent(element, driver);
        try {

            driver.findElement(element).clear();
            takeScreenshot();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            throw new Exception("Can not clear text in webElement: " + element.toString(),e);
        }
    }
    public static void waitAndEnterTextInWebElementAndThenPressEnter(String text, By element, WebDriver driver) throws Exception {
            BrowserActions.waitUntilWebElementIsPresent(element, driver);
            try {
                takeScreenshot();

                driver.findElement(element).clear();
                takeScreenshot();

                driver.findElement(element).sendKeys(text);
                takeScreenshot();

                driver.findElement(element).sendKeys(Keys.ENTER);
                takeScreenshot();

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
                throw new Exception("Can not enter text in webElement: " + element.toString(),e);
            }
    }

    public static String waitAndGetWebElementText(By element, WebDriver driver) throws Exception {
            BrowserActions.waitUntilWebElementIsPresent(element, driver);
            String webElementText;
            try {
                webElementText = driver.findElement(element).getText();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
                throw new Exception("Can not get text from webElement: " + element.toString(),e);
            }
        takeScreenshot();

        return webElementText;
    }
    public static String waitAndGetTableColumnIndex(By element, WebDriver driver, String ColName) throws Exception {
        BrowserActions.waitUntilWebElementIsPresent(element, driver);
        Integer colIndex;
        try {
            List<WebElement> headerElements = driver.findElements(element);
            List<String> headers = headerElements.stream()
                    .map(WebElement::getText)
                    .collect(Collectors.toList());
            colIndex = IntStream.range(0, headers.size())
                    .filter(i -> headers.get(i).equals(ColName))
                    .findFirst().getAsInt()+1;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            throw new Exception("Can not get column index from webElement: " + element.toString(),e);
        }
        takeScreenshot();

        return Integer.toString(colIndex);
    }

    public static boolean isWebElementPresent(By element, WebDriver driver){
            BrowserActions.waitUntilWebElementIsPresent(element, driver);
            boolean found;
            try {
                driver.findElement(element);
                found = true;
            } catch (Exception ex) {
                found = false;
            }
        takeScreenshot();

        return found;
    }

    public static void switchToFrameById(String ID, WebDriver driver) throws Exception {
            try {
                takeScreenshot();

                driver.switchTo().frame(ID);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
                throw new Exception("Frame is not found by id: " + ID,e);
            }
    }

    public static void switchToMainWindow(WebDriver driver) throws Exception {
        try {
            takeScreenshot();

            driver.switchTo().defaultContent();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            throw new Exception("Default Frame is not Found",e);
        }

    }


    public static void waitAndSelectFromDropdown(String value, By element, WebDriver driver){
            BrowserActions.waitUntilWebElementIsPresent(element, driver);
            try {

                Select dropdownElement = new Select(driver.findElement(element));
                dropdownElement.selectByVisibleText(value);
                takeScreenshot();

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
    }
    public static void waitAndSelectOptionFromDropdown(String optionText, By element, WebDriver driver) {
        BrowserActions.waitUntilWebElementIsPresent(element, driver);
        takeScreenshot();
        driver.findElement(element).click();
        By option = By.xpath("//*[contains(text(),'" + optionText + "')]");
        driver.findElement(option).click();
        takeScreenshot();
    }

    public static void waitAndHoverOverElement(By element, WebDriver driver) throws Exception {
            BrowserActions.waitUntilWebElementIsPresent(element, driver);
            try {
                WebElement webElement = driver.findElement(element);
                Actions actions = new Actions(driver);

                actions.moveToElement(webElement).perform();
                takeScreenshot();

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
                throw new Exception("Can not hover on webElement: " + element.toString(),e);
            }
    }


    public static void scrollIntoView(By element, WebDriver driver) throws Exception {
            BrowserActions.waitUntilWebElementIsPresent(element, driver);
            try {

                WebElement webElement = driver.findElement(element);
                ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", webElement);
                takeScreenshot();

            } catch (Exception e) {
                System.out.println(element);
                e.printStackTrace();
                System.out.println(e.getMessage());
                throw new Exception("Can not scroll to webElement: " + element.toString(),e);
            }
    }

    public static void scrollIntoNavBar(By element, By navbar, WebDriver driver) throws Exception {
        BrowserActions.waitUntilWebElementIsPresent(navbar, driver);
        try {

            WebElement webElement = driver.findElement(navbar).findElement(element);
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", webElement);
            takeScreenshot();

        } catch (Exception e) {
            System.out.println(element);
            e.printStackTrace();
            System.out.println(e.getMessage());
            throw new Exception("Can not scroll to webElement: " + element.toString(),e);
        }
    }
    public static void removeSurveyPopup(WebDriver driver) {
        By surveyElement = By.id("kampyleInviteContainer");
        List<WebElement> surveyPopup = driver.findElements(surveyElement);
        if (surveyPopup.size() > 0) {
            String popupInjectionScript = "document.getElementById('kampyleInviteContainer').remove()";
            ((JavascriptExecutor) driver).executeScript(popupInjectionScript);
        }
    }

    public static void takeScreenshot() {
        counterOfActions++;

        // Take screenshot after each step
        byte[] screenshot = ((TakesScreenshot) DriverSetup.driver).getScreenshotAs(OutputType.BYTES);
        saveScreenshotToFile(screenshot, "Action_Number_"+counterOfActions+"_" + ".png");
    }
    private static void saveScreenshotToFile(byte[] screenshot, String fileName) {
        try {
            FileUtils.writeByteArrayToFile(new File(System.getProperty("user.dir")+"/src/test/ScreenShots/"+"AllActions"+"/" + "time_"+ LocalTime.now().format(DateTimeFormatter.ofPattern("HH_mm_ss"))+ fileName ), screenshot);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
