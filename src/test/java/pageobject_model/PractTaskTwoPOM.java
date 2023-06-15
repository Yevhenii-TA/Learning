package pageobject_model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PractTaskTwoPOM {
    private WebDriver driver;
    private static final String HOMEPAGE_URL = "https://pastebin.com";
    private static final String TEXT_NEW_PASTE = "git config --global user.name  \"New Sheriff in Town\"\n" +
            "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
            "git push origin master --force";
    private static final String TEXT_NAME_TITLE = "how to gain dominance among developers";

    //region Selectors
    @FindBy(xpath = "//textarea[@id='postform-text']")
    private WebElement inputFieldHP;

    @FindBy(xpath = "//select[@name='PostForm[expiration]']")
    private WebElement expOptions;

    @FindBy(xpath = "//span[@title='Never']")
    private WebElement expirationDropdownHP;
    @FindBy(id = "select2-postform-format-container")
    private WebElement formatDropdownHP;

    @FindBy(xpath = "//input[@id='postform-name']")
    private WebElement nameFieldHP;

    @FindBy(xpath = "//button[text()='Create New Paste']")
    private WebElement createBtn;

    @FindBy(xpath = "//li[text() = '10 Minutes']")
    private WebElement selectOptionExpiration;
    @FindBy(xpath = "//li[text() = 'Bash']")
    private WebElement selectOptionFormat;

    @FindBy(xpath = "//div[@class='toggle__control']")
    private WebElement formatToggle;

    //endregion
    public PractTaskTwoPOM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public PractTaskTwoPOM openHomePage() {
        driver.get(HOMEPAGE_URL);
        //return new PractTaskOnePOM(driver);
        return this;
    }

    public PractTaskTwoPOM pasteMainText() {
        inputFieldHP.sendKeys(TEXT_NEW_PASTE);
        //return new PractTaskOnePOM(driver);
        return this;
    }

    public PractTaskTwoPOM pasteNameTitle() {
        nameFieldHP.sendKeys(TEXT_NAME_TITLE);
        //return new PractTaskOnePOM(driver);
        return this;
    }

    public PractTaskTwoPOM selectDropdownValues() throws InterruptedException {
        expirationDropdownHP.click();
        selectOptionExpiration.click();
        formatDropdownHP.click();
        selectOptionFormat.click();

        return this;
    }

    public PractTaskTwoPOM waitElement(String element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(element)));
        return this;
    }

    public PractTaskTwoPOM tapOnCreateBtn() {
        createBtn.click();
        //return new PractTaskOnePOM(driver);
        return this;
    }

    public PractTaskTwoPOM turnOnToggle(){
        formatToggle.click();
        return this;
    }
}
