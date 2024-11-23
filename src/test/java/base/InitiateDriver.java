package base;

import cucumber.CommonPo;
import org.openqa.selenium.WebDriver;

public class InitiateDriver extends CommonPo {

    public InitiateDriver(WebDriver driver) {
        super(driver);
    }

    public void SetUp(String URL) {
        driver.get(URL);
    }

    public void closeSession() {
            driver.quit();
    }

}
