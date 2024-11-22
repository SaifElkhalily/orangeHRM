package cucumber;

import base.InitiateDriver;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AddUserPage;
import pages.AdminPage;
import pages.HomePage;
import pages.LoginPage;

public class CommonSD{
    private final InitiateDriver initiateDriver;
    private final LoginPage loginPage;
    private final HomePage homePage;
    private final AdminPage adminPage;
    private final AddUserPage addUserPage;

    public CommonSD() {
        System.setProperty("webdriver.chrome.driver", "browser/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        initiateDriver = new InitiateDriver(driver);
        homePage = new HomePage(driver);
        adminPage = new AdminPage(driver);
        addUserPage = new AddUserPage(driver);
    }


    @Given("Initiate Chrome Browser and navigate to {string}")
    public void userOpensChrome (String URL) {
        initiateDriver.SetUp(URL);
    }

    @Given("User Login by entering their Username {string} and Password {string} then clicks on Login")
    public void userLogin(String Username, String Password) {
        loginPage.userLoginWithUserNameAndPassword(Username, Password);
    }

    @Given("User Click on {string} from left side menu")
    public  void  userClicksOnAnyOptionFromLeftSideMenu(String Option) {
        homePage.userClickOnOptionFromLeftSideMenu(Option);
    }

    @Given("Get the number of records found")
    public void getTheNumberOfRecordsFound(){
        adminPage.numberOfRecordsFound();
    }

    @Given("Admin clicks on Add to add a new user")
    public void adminAddsNewUser(){
        adminPage.clickOnAdd();
    }

    @Given("Admin adds new user and fills the required data " +
            "User Role {string}," +
            "Status {string}," +
            "Employee name {string}," +
            "Select Employee {string}," +
            "Username {string}," +
            "Password {string}," +
            "Confirm Password {string} then clicks on Save")
    public void adminAddingNewUser(String UserRole , String Status , String EmployeeName , String SelectName , String Username , String Password , String ConfirmPass) throws InterruptedException {
        addUserPage.addingNewUser(UserRole,Status,EmployeeName, SelectName ,Username,Password, ConfirmPass);
    }

    @Given("Admin searches for a user with the user name {string}")
    public void adminSearchForUser(String Username){
        adminPage.searchForUser(Username);
    }

    @Given("Admin delete user")
    public void adminDeleteUser(){
        adminPage.deleteUser();
    }

    @Given("Refresh the Admin page")
    public void refresh(){
        adminPage.refreshPage();
    }

    @Given("Get the initial count of Users")
    public void getInitialNumberOfUsers(){
        adminPage.beforeCount();
    }

    @Given("Get the recent count of Users")
    public void getRecentNumberOfUsers(){
        adminPage.afterCount();
    }

    @Given("Verify that the number of Users increased by 1")
    public void verifyNumberOfUsersIncreasedBy1(){
        adminPage.verifyTheNumberOfUsersIncreasedBy1();
    }

    @Given("Verify that the number of Users decreased by 1")
    public void verifyNumberOfUsersDecreasedBy1(){
        adminPage.verifyTheNumberOfUsersDecreasedBy1();
    }
}
