package TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject_model.PractTaskOnePOM;

public class PracticalTaskOne {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void BrowserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void TaskOne() throws InterruptedException {
        PractTaskOnePOM practTaskOnePOM = new PractTaskOnePOM(driver);
        practTaskOnePOM.openHomePage()
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
