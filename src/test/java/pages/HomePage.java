package pages;

import cucumber.CommonPo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends CommonPo {
    public HomePage(WebDriver driver) {
        super(driver);

    }
    public void userClickOnOptionFromLeftSideMenu(String Option) {
        waitForVisible(logo);
        directoriesFromLeftSideMenu(Option).click();
    }

}
