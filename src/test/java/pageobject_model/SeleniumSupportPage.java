package pageobject_model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeleniumSupportPage {
    //private WebDriver driver;
    private static final String HOMEPAGE_URL = "https://selenium.dev";

    //@FindBy(xpath = "//a[@href='/support']")
    /*private WebElement ;*/

    public void openSupportPage(WebDriver driver) {
        driver.get(HOMEPAGE_URL);
        WebElement supportBtn = driver.findElement(By.xpath("//a[@href='/support']"));
        supportBtn.click();
    }


/*    public SeleniumSupportPage openSupportPage()
    {
        supportButton.click();
    }*/

/*    public String getTitleText(String titleActual)
    {
        return titleActual;
    }*/

}
