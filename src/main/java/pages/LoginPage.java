package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static utilities.BrowserActions.ClickOnWebElement;
import static utilities.BrowserActions.waitAndEnterTextInWebElement;

public class LoginPage extends BasePage{

    private By usernameInput = By.xpath("//input[@name='username']");
    private By PassInput = By.xpath("//input[@name='password']");
    private By SubmitLoginBtn = By.xpath("//button[@type='submit']");
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public void login(String Email, String Password) throws Exception {
        waitAndEnterTextInWebElement(Email, usernameInput,driver);
        waitAndEnterTextInWebElement(Password, PassInput,driver);
        ClickOnWebElement(SubmitLoginBtn,driver);
    }
}
