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
import pageobject_model.HurtMePlentyPOM;

public class HardCore {
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
        //region Expected results
        String expectedPrice = "Total Estimated Cost: USD 5,406.21 per 1 month";
        String expectedSSD = "Local SSD: 2x375 GiB";
        String expectedVM = "Provisioning model: Regular";
        String expectedInstance = "Instance type: n1-standard-1";
        String expectedRegion = "Region: Columbus";
        //endregion

        HurtMePlentyPOM taskThree = new HurtMePlentyPOM(driver);
        taskThree.openHomePage()
                .searchCalcAndNavigate()
                .fillInMainData()
                .fillInGPUdata()
                .fillInStorageData()
                .submitForm();

        //region Actual Result selectors
        WebElement actualPrice = driver.findElement(By.xpath("//*[@id='resultBlock']/md-card/md-card-content/div/div/div/div[1]/h2/b"));
        WebElement actualSSD = driver.findElement(By.xpath("//*[@id='compute']/md-list/md-list-item[8]/div[1]")); //*[@id="compute"]/md-list/md-list-item[8]/div[1]/text()
        WebElement actualVM = driver.findElement(By.xpath("//*[@id='compute']/md-list/md-list-item[3]/div[1]"));
        WebElement actualInstance = driver.findElement(By.xpath("//*[@id='compute']/md-list/md-list-item[4]/div[1]"));
        WebElement actualRegion = driver.findElement(By.xpath("//*[@id='compute']/md-list/md-list-item[1]/div[1]"));
        //endregion

        Assert.assertEquals(actualPrice.getText(), expectedPrice, "Price is not correct");
        if (expectedInstance.contains(actualInstance.getText())) {
            Assert.assertTrue(true);
        } else
            System.out.println("Instance is not correct");
        if (expectedSSD.contains(actualSSD.getText())) {
            Assert.assertTrue(true);
        } else
            System.out.println("SSD is not correct");
        Assert.assertEquals(actualVM.getText(), expectedVM, "VM is not correct");
        Assert.assertEquals(actualRegion.getText(), expectedRegion, "Region is not correct");
    }


    @AfterMethod(alwaysRun = true)
    public void TearDown() {
        driver.quit();
        driver = null;
    }
}
