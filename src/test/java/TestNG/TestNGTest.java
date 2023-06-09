package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
//import java.lang.annotation.Annotation;

public class TestNGTest {
    private WebDriver driver;
    @BeforeMethod (alwaysRun = true)
    public void browserSetup() {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
    }
    @Test (description = "elementary test, CTRA-7465")
    public void BtnClick()  {

        driver.get("https://selenium.dev");
        WebElement SupportButton =  driver.findElement(By.xpath("//*[@id='main_navbar']/ul/li[6]/a"));
        SupportButton.click();
//      Assert.assertTrue(SupportButton.isSelected());
        WebElement SupportTitle = driver.findElement(By.xpath("//h1[text()='Getting Help']"));
        Assert.assertEquals(SupportTitle.getText(),"Getting Help");
//      Thread.sleep(3000); //do not use this approach
        driver.quit();
    }

    @AfterMethod (alwaysRun = true)
    public void quitBrowser(){
        driver.quit();
        driver = null; // to get clear instance of browser for other tests
    }

}
