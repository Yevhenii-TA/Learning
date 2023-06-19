package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject_model.PractTaskThreePOM;

public class PracticalTaskThree {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void BrowserSetup() {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL); //waits for all resources to download
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @Test
    public void TaskThree() throws InterruptedException {


        PractTaskThreePOM practTaskPOM = new PractTaskThreePOM(driver);
        practTaskPOM.openHomePage()
                .searchCalcAndNavigate()
                .fillInMainData()
                .fillInGPUdata()
                .fillInStorageData()
                .submitForm();
        WebElement actualPrice = driver.findElement(By.xpath("//*[@id='resultBlock']/md-card/md-toolbar/div/h2[2]/text()"));
        System.out.println(actualPrice.getText());
        //Assert.assertEquals(actualPrice.getText(),"");

    }

    @AfterMethod(alwaysRun = true)
    public void TearDown() {
        driver.quit();
        driver = null;
    }
}
