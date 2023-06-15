package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject_model.PractTaskTwoPOM;

import java.time.Duration;

public class PracticalTaskTwo {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void BrowserSetup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");  //added this part because was blocked by site
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @Test
    public void TaskTwo() throws InterruptedException {
        String titleResultExpected = "how to gain dominance among developers"; //bad idea, need to find something else
        String formatTypeExpected = "Bash";

        PractTaskTwoPOM practTaskPOM = new PractTaskTwoPOM(driver);
        practTaskPOM.openHomePage()
                .loginToSite()
                .pasteMainText()
                .turnOnToggle()
                .pasteNameTitle()
                .selectDropdownValues()
                .tapOnCreateBtn();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.titleIs(titleResultExpected));

        WebElement titleResultActual = driver.findElement(By.xpath("//div[@class='info-top']/*"));
        WebElement formatTypeActual = driver.findElement(By.xpath("//div[@class='left']/*[@href='/archive/bash']"));

        Assert.assertEquals(titleResultActual.getText(),titleResultExpected,"Title does not match expected");
        Assert.assertEquals(formatTypeActual.getText(),formatTypeExpected,"Format type is not correct");

        Thread.sleep(7000);
/*        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.visibilityOf(titleResultActual));*/
    }

    @AfterMethod(alwaysRun = true)
    public void TearDown() {
        driver.quit();
        driver = null;
    }
}
