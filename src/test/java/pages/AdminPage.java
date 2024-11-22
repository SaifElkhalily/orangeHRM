package pages;

import cucumber.CommonPo;
import org.openqa.selenium.WebDriver;

public class AdminPage extends CommonPo {
    public AdminPage(WebDriver driver) {
        super(driver);
    }
    int initialCount;
    int recentCount;

    public void numberOfRecordsFound(){
        waitForVisible(numberOfRecords);
        System.out.println("Number of Records found : " + numberOfRecords.getText());
    }
    public void clickOnAdd(){
        waitForVisible(addButton);
        clickElement(addButton);
    }

    public void searchForUser(String username){
        waitForVisible(usernameFieldSearchingForUser);
        usernameFieldSearchingForUser.sendKeys(username);
        searchButton.click();
    }

    public void deleteUser(){
        waitForVisible(checkbox);
        checkbox.click();
        deleteButton.click();
        waitForVisible(confirmationPopup);
        yesDeleteButton.click();
    }

    public void refreshPage(){
        waitForVisible(searchButton);
        driver.navigate().refresh();
    }

    public void beforeCount(){
        waitForVisible(numberOfRecords);
        initialCount=numberOfRecordsFoundInTable();
    }

    public void afterCount(){
        waitForVisible(numberOfRecords);
        recentCount=numberOfRecordsFoundInTable();
    }



    public void verifyTheNumberOfUsersIncreasedBy1() {
        System.out.println("Initial count = "+ initialCount +" // " + " Recent count = " + recentCount);
        if (recentCount == initialCount + 1) {
            System.out.println("The number of users increased by 1");
        } else {
            System.out.println("Test failed");
        }
    }

        public void verifyTheNumberOfUsersDecreasedBy1 () {
            System.out.println("Initial count = "+ initialCount +" // " + " Recent count = " + recentCount);
            if (recentCount == initialCount - 1) {
                System.out.println("The number of users decreased by 1");
            } else {
                System.out.println("Test failed");
            }
        }


}
