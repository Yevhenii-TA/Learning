package pageobject_model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class iCanWinPOM {
    private WebDriver driver;
    private static final String HOMEPAGE_URL = "https://pastebin.com";
    private static final String TEXT_NEW_PASTE = "Hello from WebDriver";
    private static final String TEXT_NAME_TITLE = "helloweb";

    //region Selectors
    @FindBy(xpath = "//textarea[@id='postform-text']")
    private WebElement inputFieldHP;

    @FindBy(xpath = "//select[@name='PostForm[expiration]']")
    private WebElement expOptions;

    @FindBy(xpath = "//span[@title='Never']")
    private WebElement expirationDropdownHP;

    @FindBy(xpath = "//input[@id='postform-name']")
    private WebElement nameFieldHP;

    @FindBy(xpath = "//button[text()='Create New Paste']")
    private WebElement createBtn;

    @FindBy(xpath = "//li[text() = '10 Minutes']")
    private WebElement selectOption;

    //endregion
    public iCanWinPOM(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public iCanWinPOM openHomePage(){
        driver.get(HOMEPAGE_URL);
        //return new PractTaskOnePOM(driver);
        return this;
    }

    public iCanWinPOM pasteMainText(){
        inputFieldHP.sendKeys(TEXT_NEW_PASTE);
        //return new PractTaskOnePOM(driver);
        return this;
    }

    public iCanWinPOM pasteNameTitle(){
        nameFieldHP.sendKeys(TEXT_NAME_TITLE);
        //return new PractTaskOnePOM(driver);
        return this;
    }

    public iCanWinPOM selectExpValue() throws InterruptedException {
        expirationDropdownHP.click();
        selectOption.click();
        return this;
    }

    public iCanWinPOM waitElement(String element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(element)));
        return this;
    }

    public iCanWinPOM tapOnCreateBtn(){
        createBtn.click();
        //return new PractTaskOnePOM(driver);
        return this;
    }
}
