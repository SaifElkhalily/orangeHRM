package cucumber;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CommonPo {
    protected WebDriver driver;
    public CommonPo(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitForVisible(final WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }
    protected void clickElement(final WebElement button) {
        waitForVisible(button);
        button.click();
    }

    @FindBy(xpath = "//img[@alt='client brand banner']")
    public WebElement logo;

    @FindBy(xpath = "//input[@name='username']")
    public WebElement usernameField;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement saveButton;

    @FindBy(xpath = "//div/span[@class='oxd-text oxd-text--span']")
    public WebElement numberOfRecords;

    @FindBy(xpath = "//button[text()=' Add ']")
    public WebElement addButton;

    @FindBy(xpath = "//form/div[1]/div/div[1]/div/div[2]/div/div/div[1]")
    public WebElement userRoleDropDownMenu;

    @FindBy(xpath = "//label[contains(., 'Status')]//following::div[1]//div[@class='oxd-select-text-input']")
    public WebElement statusDropDownMenu;

    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    public WebElement employeeNameField;

    @FindBy(xpath = "//form/div[1]/div/div[4]/div/div[2]/input")
    public WebElement usernameFieldForAddingUser;

    @FindBy(xpath = "//form/div[2]/div/div[1]/div/div[2]/input")
    public WebElement passwordFieldForAddingUser;

    @FindBy(xpath = "//form/div[2]/div/div[2]/div/div[2]/input")
    public WebElement confirmPasswordField;

    @FindBy(xpath = "//div[@data-v-957b4417]//input[@data-v-1f99f73c and @class='oxd-input oxd-input--active']")
    public WebElement usernameFieldSearchingForUser;

    @FindBy(xpath = "//button[text()=' Search ']")
    public WebElement searchButton;

    @FindBy(xpath = "(//span[@class='oxd-checkbox-input oxd-checkbox-input--active --label-right oxd-checkbox-input'])[2]")
    public WebElement checkbox;

    @FindBy(xpath = "//i[@class='oxd-icon bi-trash']")
    public WebElement deleteButton;

    @FindBy(xpath = "//div[@role='document']")
    public WebElement confirmationPopup;

    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']")
    public WebElement yesDeleteButton;

    public WebElement directoriesFromLeftSideMenu(String Option){
        String xpath = String.format("//span[text()='%s']", Option);
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement disappearingDropdown(String Option){
        String xpath = String.format("//div[contains(@class, 'oxd-select-dropdown')]//span[text()='%s']",Option);
        return driver.findElement(By.xpath(xpath));
    }
    public By disappearingAutoSuggestion(String select){
        String xpath = String.format("//div[contains(@class, 'oxd-autocomplete-wrapper')]//span[text()='%s']", select);
        return By.xpath(xpath);
    }

    public int numberOfRecordsFoundInTable(){
        List<WebElement> numberOfRecords = driver.findElements(By.xpath("//div[@class='oxd-table-card']"));
        return numberOfRecords.size();
    }

}
