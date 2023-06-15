package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
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
        String titleResultExpected = "how to gain dominance among developers"; //bad idea, need to find something else

        PractTaskTwoPOM practTaskPOM = new PractTaskTwoPOM(driver);
        practTaskPOM.openHomePage()
                .pasteMainText()
                .turnOnToggle()
                .pasteNameTitle()
                .selectDropdownValues()
                .tapOnCreateBtn();

        WebElement titleResultActual = driver.findElement(By.xpath("//div[@class='info-top']/*"));
        Assert.assertEquals(titleResultActual.getText(),titleResultExpected,"Title does not match expected");


        Thread.sleep(5000);
/*        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.visibilityOf(titleResultActual));*/
    }

    @AfterMethod(alwaysRun = true)
    public void TearDown() {
        driver.quit();
        driver = null;
    }
}
