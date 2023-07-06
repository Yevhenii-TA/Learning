package SeleniumGridTests;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject_model.iCanWinPOM;

import java.net.MalformedURLException;
import java.net.URL;

public class SeleniumGridTest {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void BrowserSetup() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setPlatform(Platform.MAC);
        desiredCapabilities.setBrowserName("chrome");
        driver = new RemoteWebDriver(new URL("http://192.168.5.66:4444/wd/hub"), desiredCapabilities);
        driver.manage().window().maximize();
    }

    @Test
    public void SeleniumGridTask() throws InterruptedException {
        iCanWinPOM seleniumGrid = new iCanWinPOM(driver);
        seleniumGrid.openHomePage()
                .pasteMainText()
                .pasteNameTitle()
                .selectExpValue()
                .tapOnCreateBtn();
        Thread.sleep(5000);
    }

    @AfterMethod(alwaysRun = true)
    public void TearDown() {
        driver.quit();
        driver = null;
    }
}
