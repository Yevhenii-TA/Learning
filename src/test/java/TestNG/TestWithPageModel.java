package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject_model.SeleniumSupportPage;

public class TestWithPageModel {
    private WebDriver driver;
    private static final String supportTitleExpected = "Getting Help";

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void checkTitle() {
        SeleniumSupportPage seleniumSupportPage = new SeleniumSupportPage();
        seleniumSupportPage.openSupportPage(driver);

        WebElement supportTitleActual = driver.findElement(By.xpath("//h1[text()='Getting Help']"));
        Assert.assertEquals(supportTitleActual.getText(), supportTitleExpected);
    }

    @AfterMethod(alwaysRun = true)
    public void quitBrowser() {
        driver.quit();
        driver = null;
    }
}
