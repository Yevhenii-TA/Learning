package pageobject_model;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PractTaskThreePOM {
    private final WebDriver driver;
    private static final String HOMEPAGE_URL = "https://cloud.google.com/";
    private static final String CALC_NAME = "Google Cloud Platform Pricing Calculator";
    private static final String TEXT_NAME_TITLE = "how to gain dominance among developers";


    //region Selectors
    @FindBy(xpath = "//*[@aria-label='Search']")
    private WebElement searchBtnField;
    @FindBy(xpath = "//*[@id='___gcse_0']/div/div/div/div[5]/div[2]/div/div/div[1]/div[1]/div[1]/div[1]/div/a")
    private WebElement calculatorLink;
    @FindBy(xpath = "//md-tab-item[@tabindex='0']")
    private WebElement computeEngineBtn;
    @FindBy(xpath = "//*[@id='input_96']")
    private WebElement numberOfInstances; //#input_96
    @FindBy(xpath = "//*[contains(text(),'E2')]/../../../..//md-select[@placeholder='Series']")
    private WebElement machineSeries;
    @FindBy(xpath = "//md-option[@id='select_option_212']")
    private WebElement machineSeriesOption;
    @FindBy(xpath = "//md-option[@value='CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8']")
    private WebElement machineTypeOption;
    //@FindBy(xpath = "//md-chekbox[@aria-label='Add GPUs']")
    @FindBy(xpath = "//*[@id='mainForm']/div[2]/div/md-card/md-card-content/div/div[1]/form/div[12]/div[1]/md-input-container/md-checkbox")
    // ask about this
    private WebElement checkboxGPU;
    @FindBy(xpath = "//*[@id='select_484']")
    private WebElement typeGPU;
    @FindBy(xpath = "//*[@id='select_option_491']")//*[@id="select_option_491"]
    private WebElement typeGPUSelect;
    @FindBy(xpath = "//*[@id='select_value_label_483']/span[1]/div")
    private WebElement numberOfGPU;
    @FindBy(xpath = "//*[@id='select_option_632']") //*[@id="select_option_494"]    //*[@id="select_option_494"]/div
    private WebElement numberOfGPUSelect;
    @FindBy(xpath = "//*[@id='select_value_label_446']")
    private WebElement localSSD;
    @FindBy(xpath = "//*[@id='select_option_473']")
    private WebElement localSSDSelect;
    @FindBy(xpath = "//*[@id='select_value_label_94']")
    private WebElement dataCenter;
    @FindBy(xpath = "//*[@id='select_option_255']")
    //changed data center because the asked one is not supported with selected GPU
    private WebElement dataCenterSelect;
    @FindBy(xpath = "//*[@id='select_value_label_95']")
    private WebElement commitedUsage;
    @FindBy(xpath = "//*[@id='select_option_134']")
    private WebElement commitedUsageSelect;
    @FindBy(xpath = "//*[@id='mainForm']/div[2]/div/md-card/md-card-content/div/div[1]/form/div[19]/button")
    private WebElement addToEstimate;
    @FindBy(xpath = "//iframe[@src='https://cloud.google.com/frame/products/calculator/index_d6a98ba38837346d20babc06ff2153b68c2990fa24322fe52c5f83ec3a78c6a0.frame']")
    private WebElement calculatorFrameOne;
    @FindBy(xpath = "//iframe[@id='myFrame']")
    private WebElement calculatorFrameTwo;

    //endregion
    public PractTaskThreePOM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public PractTaskThreePOM openHomePage() {
        driver.get(HOMEPAGE_URL);
        //driver.get("https://cloud.google.com/products/calculator");
        return this;
    }

    public PractTaskThreePOM searchCalcAndNavigate() {
        searchBtnField.sendKeys(CALC_NAME);
        searchBtnField.sendKeys(Keys.ENTER);
        waitHandler(5, calculatorLink);
        calculatorLink.click();
        return this;
    }

    public PractTaskThreePOM fillInMainData() throws InterruptedException {
        switchToFrame(); //switch to iframes
        numberOfInstances.sendKeys("4");
        machineSeries.click();
        waitHandler(1, machineSeriesOption);
        machineSeriesOption.click();
        return this;
    }

    public PractTaskThreePOM fillInGPUdata(){
        checkboxGPU.click();
        typeGPU.click();
        waitHandler(2, typeGPUSelect);
        typeGPUSelect.click();
        numberOfGPU.click();
        waitHandler(2, numberOfGPUSelect);
        numberOfGPUSelect.click();
        return this;
    }

    public PractTaskThreePOM fillInStorageData(){
        localSSD.click();
        localSSDSelect.click();
        dataCenter.click();
        dataCenterSelect.click();
        commitedUsage.click();
        commitedUsageSelect.click();
        return this;
    }

    public PractTaskThreePOM waitHandler(long secDuration, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(secDuration));
        wait.until(ExpectedConditions.visibilityOf(element));

        return this;
    }

    public PractTaskThreePOM switchToFrame() {
        driver.switchTo().frame(calculatorFrameOne);
        driver.switchTo().frame(calculatorFrameTwo);
        return this;
    }

    public PractTaskThreePOM moveToElement(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
        return this;
    }

    public PractTaskThreePOM submitForm() {
        addToEstimate.click();
        return this;
    }
}
