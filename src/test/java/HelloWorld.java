import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloWorld {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://selenium.dev");
        WebElement SupportButton =  driver.findElement(By.xpath("//*[@id='main_navbar']/ul/li[6]/a"));
        SupportButton.click();
        Thread.sleep(3000); //do not use this approach
        driver.quit();
    }

}
