package TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject_model.PractTaskTwoPOM;

public class PracticalTaskTwo {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void BrowserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void TaskTwo() throws InterruptedException {
        PractTaskTwoPOM practTaskPOM = new PractTaskTwoPOM(driver);
        practTaskPOM.openHomePage()
                .pasteMainText()
                .turnOnToggle()
                .pasteNameTitle()
                .selectDropdownValues()
                .tapOnCreateBtn();
        Thread.sleep(5000);

    }

    @AfterMethod(alwaysRun = true)
    public void TearDown() {
        driver.quit();
        driver = null;
    }
}
