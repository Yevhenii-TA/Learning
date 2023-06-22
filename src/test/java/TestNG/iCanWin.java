package TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject_model.iCanWinPOM;

public class iCanWin {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void BrowserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void TaskOne() throws InterruptedException {
        iCanWinPOM practTaskPOM = new iCanWinPOM(driver);
        practTaskPOM.openHomePage()
                .pasteMainText()
                .pasteNameTitle()
                .selectExpValue()
                .tapOnCreateBtn();

    }

    @AfterMethod(alwaysRun = true)
    public void TearDown() {
        driver.quit();
        driver = null;
    }
}
