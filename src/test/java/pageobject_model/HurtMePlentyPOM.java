package pageobject_model;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HurtMePlentyPOM {
    private final WebDriver driver;
    private static final String HOMEPAGE_URL = "https://cloud.google.com/";
    private static final String CALC_NAME = "Google Cloud Platform Pricing Calculator";


    //region Selectors
    @FindBy(xpath = "//*[@aria-label='Search']")
    private WebElement searchBtnField;
    @FindBy(xpath = "//*[@id='___gcse_0']/div/div/div/div[5]/div[2]/div/div/div[1]/div[1]/div[1]/div[1]/div/a")
    private WebElement calculatorLink;
    @FindBy(xpath = "//md-tab-item[@tabindex='0']")
    private WebElement computeEngineBtn;
    @FindBy(xpath = "//*[@id='input_97']")
    private WebElement numberOfInstances; //#input_96
    @FindBy(xpath = "//*[contains(text(),'E2')]/../../../..//md-select[@placeholder='Series']")
    private WebElement machineSeries;
    @FindBy(xpath = "//md-option[@id='select_option_213']")
    private WebElement machineSeriesOption;
    @FindBy(xpath = "//md-option[@value='CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8']")
    private WebElement machineTypeOption;
    //@FindBy(xpath = "//md-chekbox[@aria-label='Add GPUs']")
    @FindBy(xpath = "//*[@id='mainForm']/div[2]/div/md-card/md-card-content/div/div[1]/form/div[12]/div[1]/md-input-container/md-checkbox")
    // ask about this
    private WebElement checkboxGPU;
    @FindBy(xpath = "//*[@id='select_485']")
    private WebElement typeGPU;
    @FindBy(xpath = "//div[normalize-space()='NVIDIA Tesla V100']")//*[@id="select_option_491"]
    private WebElement typeGPUSelect;
    @FindBy(xpath = "//*[@id='select_value_label_484']")
    private WebElement numberOfGPU;
    @FindBy(xpath = "//md-option[@id='select_option_495']") //*[@id="select_option_494"]
    private WebElement numberOfGPUSelect;
    @FindBy(xpath = "//*[@id='select_value_label_447']")
    private WebElement localSSD;
    @FindBy(xpath = "//div[normalize-space()='2x375 GB']")
    private WebElement localSSDSelect;
    @FindBy(css = "#select_value_label_95")
    private WebElement dataCenter;
    @FindBy(css = "#select_option_233") //changed data center because the asked one is not supported with selected GPU
    private WebElement dataCenterSelect;
    @FindBy(css = "#select_value_label_142")
    private WebElement commitedUsage;
    @FindBy(css = "#select_option_163")
    private WebElement commitedUsageSelect;
    @FindBy(xpath = "//*[@id='mainForm']/div[2]/div/md-card/md-card-content/div/div[1]/form/div[20]/button")
    private WebElement addToEstimate;
    @FindBy(xpath = "//iframe[@src='https://cloud.google.com/frame/products/calculator/index_d6a98ba38837346d20babc06ff2153b68c2990fa24322fe52c5f83ec3a78c6a0.frame']")
    private WebElement calculatorFrameOne;
    @FindBy(xpath = "//iframe[@id='myFrame']")
    private WebElement calculatorFrameTwo;

    //endregion
    public HurtMePlentyPOM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public HurtMePlentyPOM openHomePage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public HurtMePlentyPOM searchCalcAndNavigate() {
        searchBtnField.sendKeys(CALC_NAME);
        searchBtnField.sendKeys(Keys.ENTER);
        waitHandlerVisibility(5, calculatorLink);
        calculatorLink.click();
        return this;
    }

    public HurtMePlentyPOM fillInMainData() {
        switchToFrame(); //switch to iframes
        numberOfInstances.sendKeys("4");
        machineSeries.click();
        waitHandlerVisibility(1, machineSeriesOption);
        machineSeriesOption.click();
        return this;
    }

    public HurtMePlentyPOM fillInGPUdata() {
        checkboxGPU.click();
        typeGPU.click();
        waitHandlerVisibility(2, typeGPUSelect);
        typeGPUSelect.click();
        numberOfGPU.click();
        waitHandlerVisibility(2, numberOfGPUSelect);
        numberOfGPUSelect.click();
        return this;
    }

    public HurtMePlentyPOM fillInStorageData() {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        localSSD.click();
        waitHandlerVisibility(2, localSSDSelect);
        localSSDSelect.click();

        WebElement point = driver.findElement(By.xpath("//*[@id='mainForm']/div[2]/div/md-card/md-card-content/div/div[1]/form/div[17]/div[1]"));
        js.executeScript("arguments[0].scrollIntoView();", point);
        js.executeScript("arguments[0].click();",dataCenter);
        js.executeScript("arguments[0].click();",dataCenterSelect);
        js.executeScript("arguments[0].click();",commitedUsage);
        waitHandlerClickable(3,commitedUsageSelect);
        js.executeScript("arguments[0].click();",commitedUsageSelect);

        return this;
    }

    public HurtMePlentyPOM waitHandlerVisibility(long secDuration, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(secDuration));
        wait.until(ExpectedConditions.visibilityOf(element));
        return this;
    }

    public HurtMePlentyPOM waitHandlerClickable(long secDuration, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(secDuration));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return this;
    }

    public HurtMePlentyPOM switchToFrame() {
        waitHandlerVisibility(10,calculatorFrameOne);
        driver.switchTo().frame(calculatorFrameOne);
        driver.switchTo().frame(calculatorFrameTwo);
        return this;
    }

    public HurtMePlentyPOM submitForm() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",addToEstimate);
        //addToEstimate.click();
        return this;
    }
}
