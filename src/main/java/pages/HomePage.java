package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utilities.BrowserActions.ClickOnWebElement;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }
    private By Admin = By.xpath("//a[@href='/web/index.php/admin/viewAdminModule']");
    public void ClickOnAdminLink() throws Exception {
        ClickOnWebElement(Admin,driver);
    }
}
