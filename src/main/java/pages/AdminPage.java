package pages;

import org.apache.xmlbeans.impl.xb.xsdschema.Attribute;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import static utilities.BrowserActions.*;

public class AdminPage extends BasePage {
    public AdminPage(WebDriver driver) {
        super(driver);
    }

    int numberAsIntBeforeAddNewAdmin;
    int numberAsIntAfterAddNewAdmin;
    int numberAsIntAfterDeleteAdmin;
    private static SoftAssert softAssertForNumberOfAdminCreatedIncreasedBy1;
    private static SoftAssert softAssertForNumberOfAdminCreatedDecreasedBy1;

    private By AddBtn = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']");
    private By NumberOfRecords = By.xpath("//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']//span");
    private By AdminSaveBtn = By.xpath("//button[@type='submit']");
    private By PasswordInput = By.xpath("//label[text()='Password']/../..//input");
    private By ConfirmPasswordInput = By.xpath("//label[text()='Confirm Password']/../..//input");
    private By UsernameInput = By.xpath("//label[text()='Username']/../..//input");
    private By StatusDropdownIcon = By.xpath("//label[text()='Status']/../..//div//i");
    private By StatusValue = By.xpath("//div[@class='oxd-select-dropdown --positon-bottom']//span[text()='Disabled']");
    private By UserRoleDropdownIcon = By.xpath("//label[text()='User Role']/../..//div//i");
    private By UserRoleValue = By.xpath("//div[@class='oxd-select-dropdown --positon-bottom']//span[text()='Admin']");
    private By EmployeeNameInput = By.xpath("//label[text()='Employee Name']/../..//input");
    private By SearchByUsername = By.xpath("//label[text()='Username']/../..//input");
    private By ConfirmDeleteBtn = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']");
    private By ResetSearchResultBtn = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--ghost']");
    public void getNumberOfAdminsCreated() throws Exception {
        String text = waitAndGetWebElementText(NumberOfRecords, driver);
        String number = text.replaceAll("[^0-9]", "");
        numberAsIntBeforeAddNewAdmin = Integer.parseInt(number);
    }

    public void ClickAddAdminBtn() throws Exception {
        waitAndClickOnWebElement(AddBtn, driver);
    }

    public void createNewAdmin(String EmployeeName, String Username, String Pass, String ConfirmPass) throws Exception {
        waitAndClickOnWebElement(UserRoleDropdownIcon, driver);
        waitAndClickOnWebElement(UserRoleValue, driver);
        waitAndEnterTextInWebElement(EmployeeName, EmployeeNameInput, driver);
        By EmployeeSelectValue = By.xpath("//div[@class='oxd-autocomplete-dropdown --positon-bottom']//span[text()='" + EmployeeName + "']");
        waitAndClickOnWebElement(EmployeeSelectValue, driver);
        waitAndClickOnWebElement(StatusDropdownIcon, driver);
        waitAndClickOnWebElement(StatusValue, driver);
        waitAndEnterTextInWebElement(Username, UsernameInput, driver);
        waitAndEnterTextInWebElement(Pass, PasswordInput, driver);
        waitAndEnterTextInWebElement(ConfirmPass, ConfirmPasswordInput, driver);
    }

    public void ClickSaveBtn() throws Exception {
        waitAndClickOnWebElement(AdminSaveBtn, driver);
    }

    public void VerifyNumberOfRecords() throws Exception {
        String text = waitAndGetWebElementText(NumberOfRecords, driver);
        String number = text.replaceAll("[^0-9]", "");
        numberAsIntAfterAddNewAdmin = Integer.parseInt(number);
        softAssertForNumberOfAdminCreatedIncreasedBy1 = new SoftAssert();
        softAssertForNumberOfAdminCreatedIncreasedBy1.assertEquals(numberAsIntBeforeAddNewAdmin,numberAsIntAfterAddNewAdmin+1);
    }

    public void SearchByUsername(String username) throws Exception {
        waitAndEnterTextInWebElement(username,SearchByUsername,driver);
        waitAndClickOnWebElement(AdminSaveBtn,driver);
    }

    public void DeleteTheAdminUser(String username) throws Exception {
        By DeleteIcon = By.xpath("//div[text()='"+username+"']/../..//div//i[@class='oxd-icon bi-trash']");
        waitAndClickOnWebElement(DeleteIcon,driver);
        waitAndClickOnWebElement(ConfirmDeleteBtn,driver);
    }

    public void ClickResetBtn() throws Exception {
        waitAndClickOnWebElement(ResetSearchResultBtn,driver);
    }

    public void VerifyThatNumberDecreasedBy1() throws Exception {
        String text = waitAndGetWebElementText(NumberOfRecords, driver);
        String number = text.replaceAll("[^0-9]", "");
        numberAsIntAfterDeleteAdmin = Integer.parseInt(number);
        softAssertForNumberOfAdminCreatedDecreasedBy1 = new SoftAssert();
        softAssertForNumberOfAdminCreatedDecreasedBy1.assertEquals(numberAsIntAfterDeleteAdmin,numberAsIntAfterAddNewAdmin-1);
    }
}
