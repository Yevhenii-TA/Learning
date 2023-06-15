package pageobject_model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PractTaskOnePOM {
    private WebDriver driver;
    private static final String HOMEPAGE_URL = "https://pastebin.com";
    private static final String TEXT_NEW_PASTE = "Hello from WebDriver";
    private static final String TEXT_NAME_TITLE = "helloweb";

    //region Selectors
    @FindBy(xpath = "//textarea[@id='postform-text']")
    private WebElement inputFieldHP;

    //@FindBy(xpath = "//li[@id='select2-postform-expiration-result-rnj5-10M']")
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
    public PractTaskOnePOM(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public PractTaskOnePOM openHomePage(){
        driver.get(HOMEPAGE_URL);
        //return new PractTaskOnePOM(driver);
        return this;
    }

    public PractTaskOnePOM pasteMainText(){
        inputFieldHP.sendKeys(TEXT_NEW_PASTE);
        //return new PractTaskOnePOM(driver);
        return this;
    }

    public PractTaskOnePOM pasteNameTitle(){
        nameFieldHP.sendKeys(TEXT_NAME_TITLE);
        //return new PractTaskOnePOM(driver);
        return this;
    }

    public PractTaskOnePOM selectExpValue() throws InterruptedException {
        expirationDropdownHP.click();
        //Thread.sleep(3000);
        WebElement fullDD = driver.findElement(By.xpath("/html/body/span[2]/span/span[2]"));
        if (fullDD.isDisplayed()) {
            System.out.println("Element is visible");
            selectOption.click();
        };
        //System.out.println("Element is not visible");
        /*Select dropdown = new Select(expirationDropdownHP);
        dropdown.selectByValue("10M");*/

/*        List<WebElement> listOfOptions = select.getOptions();
        int listSize = listOfOptions.size();
        for (int i=0; i < listSize; i++){
            String tenMinutes = "10M";
            if (listOfOptions.get(i).getText() == tenMinutes){
                listOfOptions.get(i).click();
            }
            String option = listOfOptions.get(i).getText();
            System.out.println("Option number " + i + option);
        }*/
        //return new PractTaskOnePOM(driver);
        return this;
    }

    public PractTaskOnePOM waitElement(String element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(element)));
        return this;
    }

    public PractTaskOnePOM tapOnCreateBtn(){
        createBtn.click();
        //return new PractTaskOnePOM(driver);
        return this;
    }
}
