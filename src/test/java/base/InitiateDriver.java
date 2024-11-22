package base;

import cucumber.CommonPo;
import org.openqa.selenium.WebDriver;

public class InitiateDriver extends CommonPo {

    public InitiateDriver(WebDriver driver) {
        super(driver);
    }
    //@Before
    public void SetUp(String URL) {
        driver.get(URL);
    }
    //@After
    public void closeSession() {
        if (driver != null) {
            driver.quit();
        }
    }


}
