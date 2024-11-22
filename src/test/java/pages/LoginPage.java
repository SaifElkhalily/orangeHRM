package pages;

import cucumber.CommonPo;
import org.openqa.selenium.WebDriver;

public class LoginPage extends CommonPo {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void userLoginWithUserNameAndPassword(String username, String password) {
        waitForVisible(usernameField);
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }
}
