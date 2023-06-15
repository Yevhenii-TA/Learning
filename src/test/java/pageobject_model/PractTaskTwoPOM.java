package pageobject_model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;

public class PractTaskTwoPOM {
    private WebDriver driver;
    private static final String HOMEPAGE_URL = "https://pastebin.com";
    private static final String TEXT_NEW_PASTE = "git config --global user.name  \"New Sheriff in Town\"\n" +
            "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
            "git push origin master --force";
    private static final String TEXT_NAME_TITLE = "how to gain dominance among developers";
    private static final String USERNAME = "ivanenko1992";
    private static final String PASSWORD = "Xthysdes1993?1234";

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
    @FindBy(xpath = "//*[@class='btn-sign sign-in']")
    private WebElement loginBtn;
    @FindBy(xpath = "//input[@id='loginform-username']")
    private WebElement usernameField;
    @FindBy(xpath = "//input[@id='loginform-password']")
    private WebElement passField;
    @FindBy(xpath = "//button[@type='submit'][text()='Login']")
    private WebElement signInBtn;
    @FindBy(xpath = "//a[text()='raw']")
    private WebElement rawBtn;

    //endregion
    public PractTaskTwoPOM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public PractTaskTwoPOM openHomePage() {
        driver.get(HOMEPAGE_URL);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(loginBtn));
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

    public PractTaskTwoPOM selectDropdownValues() {
        expirationDropdownHP.click();
        selectOptionExpiration.click();
        formatDropdownHP.click();
        selectOptionFormat.click();

        return this;
    }

    public PractTaskTwoPOM tapOnCreateBtn() {
        createBtn.click();
        //return new PractTaskOnePOM(driver);
        return this;
    }

    public PractTaskTwoPOM turnOnToggle() {
        formatToggle.click();
        return this;
    }

    public PractTaskTwoPOM loginToSite() throws InterruptedException {
        loginBtn.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOf(signInBtn));
        usernameField.sendKeys(USERNAME);
        passField.sendKeys(PASSWORD);
        signInBtn.click();
        return this;
    }

    public PractTaskTwoPOM switchToNewTab(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));

        String originalWindow = driver.getWindowHandle();
        assert driver.getWindowHandles().size() == 1;
        rawBtn.click();
        wait.until(numberOfWindowsToBe(2));

        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        return this;
    }
}
