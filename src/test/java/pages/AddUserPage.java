package pages;

import cucumber.CommonPo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddUserPage extends CommonPo {
    public AddUserPage(WebDriver driver) {
        super(driver);
    }
    Actions actions = new Actions(driver);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public void addingNewUser(String UserRole , String Status , String Name , String Select , String Username , String Password , String ConfirmPass){
        waitForVisible(employeeNameField);

        userRoleDropDownMenu.click();
        actions.moveToElement(disappearingDropdown(UserRole)).click().perform();

        statusDropDownMenu.click();
        actions.moveToElement(disappearingDropdown(Status)).click().perform();

        employeeNameField.sendKeys(Name);
        WebElement suggestEmployeeName = wait.until(ExpectedConditions.visibilityOfElementLocated(disappearingAutoSuggestion(Select)));
        actions.moveToElement(suggestEmployeeName).click().perform();


        usernameFieldForAddingUser.sendKeys(Username);
        passwordFieldForAddingUser.sendKeys(Password);
        confirmPasswordField.sendKeys(ConfirmPass);

        waitForVisible(saveButton);
        clickElement(saveButton);
    }

}
