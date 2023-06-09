package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
//import java.lang.annotation.Annotation;

public class TestNGTest {
    @Test
    public void BtnClick()  {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://selenium.dev");
        WebElement SupportButton =  driver.findElement(By.xpath("//*[@id='main_navbar']/ul/li[6]/a"));
        SupportButton.click();
//        Assert.assertTrue(SupportButton.isSelected());
        WebElement SupportTitle = driver.findElement(By.xpath("//h1[text()='Getting Help']"));
        Assert.assertEquals(SupportTitle.getText(),"Getting Help");
        //Thread.sleep(3000); //do not use this approach
        driver.quit();
    }

}
