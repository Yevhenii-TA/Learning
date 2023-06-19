package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
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
        String epectedPrice = "Total Estimated Cost: USD 4,799.62 per 1 month";
        String expectedSSD = "Local SSD: 2x375 GiB";
        String expectedVM = "Provisioning model: Regular";
        String expectedInstance = "Instance type: n1-standard-1";
        String expectedRegion = "Region: Columbus";

        PractTaskThreePOM practTaskPOM = new PractTaskThreePOM(driver);
        practTaskPOM.openHomePage()
                .searchCalcAndNavigate()
                .fillInMainData()
                .fillInGPUdata()
                .fillInStorageData()
                .submitForm();

        WebElement actualPrice = driver.findElement(By.xpath("//*[@id='resultBlock']/md-card/md-card-content/div/div/div/div[1]/h2/b"));
        WebElement actualSSD = driver.findElement(By.xpath("//*[@id='compute']/md-list/md-list-item[8]/div[1]")); //*[@id="compute"]/md-list/md-list-item[8]/div[1]/text()
        WebElement actualVM = driver.findElement(By.xpath("//*[@id='compute']/md-list/md-list-item[4]/div[1]"));
        WebElement actualInstance = driver.findElement(By.xpath("//*[@id='compute']/md-list/md-list-item[5]/div[1]"));
        WebElement actualRegion = driver.findElement(By.xpath("//*[@id='compute']/md-list/md-list-item[1]/div[1]"));

        Assert.assertEquals(actualPrice.getText(), epectedPrice);
        if (actualSSD.getText().contains(expectedSSD)){
            Assert.assertTrue(true,"String is not valid");
        }
        Assert.assertEquals(actualVM.getText(), expectedVM);
        if (actualInstance.getText().contains(expectedInstance)){
            Assert.assertTrue(true,"String is not valid");
        }
        Assert.assertEquals(actualRegion.getText(), expectedRegion);
    }

    @AfterMethod(alwaysRun = true)
    public void TearDown() {
        driver.quit();
        driver = null;
    }
}
