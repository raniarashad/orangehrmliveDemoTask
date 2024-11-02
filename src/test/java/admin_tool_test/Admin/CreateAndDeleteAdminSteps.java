package admin_tool_test.Admin;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AdminPage;
import pages.HomePage;
import pages.LoginPage;
import io.cucumber.java.en.Given;
import utilities.PropertyFileSetup;

import static utilities.DriverSetup.driver;

public class CreateAndDeleteAdminSteps {
    private LoginPage loginPage;
    private HomePage homePage;
    private AdminPage adminPage;

    @Given("Admin Sign in to website")
    public void adminSignInToWebsite() throws Exception {
        String Username = PropertyFileSetup.props.getProperty("Username");
        String Pass = PropertyFileSetup.props.getProperty("Password");
        loginPage = new LoginPage(driver);
        loginPage.login(Username, Pass);
    }

    @When("Click on Admin tab on the left side menu")
    public void clickOnAdminTabOnTheLeftSideMenu() throws Exception {
        homePage = new HomePage(driver);
        homePage.ClickOnAdminLink();
    }

    @Then("Get the number of records found")
    public void getTheNumberOfRecordsFound() throws Exception {
        adminPage = new AdminPage(driver);
        adminPage.getNumberOfAdminsCreated();
    }

    @And("Click on add button")
    public void clickOnAddButton() throws Exception {
        adminPage.ClickAddAdminBtn();
    }

    @And("Fill the required data {string},{string},{string},{string},")
    public void fillTheRequiredData(String name, String username, String pass, String confirmPass) throws Exception {
        adminPage.createNewAdmin(name, username, pass, confirmPass);
    }

    @And("Click on save button")
    public void clickOnSaveButton() throws Exception {
        adminPage.ClickSaveBtn();
    }

    @Then("Verify that the number of records increased by one")
    public void verifyThatTheNumberOfRecordsIncreasedByOne() throws Exception {
        adminPage.VerifyNumberOfRecords();
    }

    @And("Search with the username for the new user {string}")
    public void searchWithTheUsernameForTheNewUser(String username) throws Exception {
        adminPage.SearchByUsername(username);
    }

    @And("Delete the new user {string}")
    public void deleteTheNewUser(String username) throws Exception {
        adminPage.DeleteTheAdminUser(username);
    }

    @And("Click on Rest button to reset the search result")
    public void clickOnRestButtonToResetTheSearchResult() throws Exception {
        adminPage.ClickResetBtn();
    }

    @Then("Verify that the number of records decreased by one")
    public void verifyThatTheNumberOfRecordsDecreasedByOne() throws Exception {
        adminPage.VerifyThatNumberDecreasedBy1();
    }

}
