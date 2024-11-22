package base;

import cucumber.CommonPo;
import io.cucumber.java.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class InitiateDriver extends CommonPo {

    public InitiateDriver(WebDriver driver) {
        super(driver);
    }
    //@Before
    public void SetUp(String URL) {
        // Create ChromeOptions instance
        ChromeOptions options = new ChromeOptions();
        // Add the maximized argument
        options.addArguments("--start-maximized");
        driver.get(URL);
        //driver.manage().window().maximize();
    }
    //@After
    public void closeSession() {
        driver.quit();
    }

}
