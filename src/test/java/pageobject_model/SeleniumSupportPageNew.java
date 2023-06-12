package pageobject_model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeleniumSupportPageNew {
    private WebDriver driver;
    private static final String HOMEPAGE_URL = "https://selenium.dev";

    @FindBy(xpath = "//a[@href='/support']")
    private WebElement supportButton;

    public SeleniumSupportPageNew(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public SeleniumSupportPageNew openSupportPage() {
        driver.get(HOMEPAGE_URL);
        supportButton.click();
        return new SeleniumSupportPageNew(driver);
    }
}
