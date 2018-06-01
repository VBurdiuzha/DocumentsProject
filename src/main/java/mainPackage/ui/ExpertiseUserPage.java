package mainPackage.ui;


import javafx.scene.web.WebView;
import mainPackage.interfaceFolder.ExpertiseVars;
import mainPackage.interfaceFolder.Vars;
import mainPackage.utils.WebDriverTestBase;
import mainPackage.utils.WebDriverTools;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import static org.openqa.selenium.By.className;
import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.xpath;

public class ExpertiseUserPage {

    private final By inputUsername = cssSelector("#front480616263a00926a515c2aaf34b53fcc");
    private final By inputPassword = cssSelector("#front75da0a9226c31d6d56e327f558c4ccd8");
    private final By loginBotton = xpath("//*[@id=\"front64fbd75d07ec519ac1c34bbf3c93e41b\"]");
    private final By roleInDoc = xpath ( "//*[@id=\"front15028f72ff543a7225493002142fac78\"]");
    private final By textarea = cssSelector("#front6cbe73215f7d646d4888d05f14810819");

    @FindBy(xpath = "//*[@id=\"fronta0e5a7b36e788e511ab810fb77be3bc2\"]")
    private WebElement avatar;
    @FindBy(css = "#front3d6305e5e1809ea5588858bbcf65cc36")
    private WebElement profile;
    @FindBy(css = "#sidemenu > li.li_review > a")
    private WebElement expertiseModule;
    @FindBy(css = "#maincolumn > div > div.tabContainer > span:nth-child(1) > div > a")
    private WebElement tabNewDoc;
    @FindBy(css = "#frontb5fbbf28a9f06b537b590d5f3b4ff32d > div")
    private WebElement createApplication;
    @FindBy(css = "#front868dfaedd842b532f770504a740cbf47 > svg")
    private WebElement typeDoc;
    @FindBy(css = "#\\35 aafce473a24c926d01797ba")
    private WebElement testCategoryType;
    @FindBy(css = "#frontfc57de6a29ea1e8f6ee07fda4f548cc8")
    private WebElement radioButton3;
    @FindBy(css = "input[type=file]")
    private WebElement attachFile;
    @FindBy(xpath = "//*[@id=\"front930d0de3b569e900ece1ea62969151de\"]/div/span")
    private WebElement nextButton;
    @FindBy(css = "#front404d0ca4b994575eec4661a031a130a8")
    private WebElement payAndGo;
    @FindBy(xpath = "//*[@id=\"maincolumn\"]/div/div[2]/div/div/div[2]/div/button")
    private WebElement continueWork;
    @FindBy(xpath = "//*[@id=\"maincolumn\"]/div/div[2]/div/div[1]/span")
    private WebElement errorMessageTypeDoc;
    @FindBy(xpath = "//*[@id=\"sidemenu\"]/li[2]/a")
    private WebElement sideBarExpertise;
    @FindBy(css = "#front96c67a9f92654c30aec8dd319d49623a")
    private WebElement deleteFile;
    @FindBy(css = "#front96c67a9f92654c30aec8dd319d49623a")
    private WebElement reestablis;
    @FindBy(linkText = "expertise.png")
    private WebElement fileExpertise;
    @FindBy(linkText = "Пополнить")
    private WebElement getMoney;




    private final WebDriver driver;

    public ExpertiseUserPage(WebDriver driver) {
        this.driver = driver;
    }


    public void expertiseModule() {
        driver.get(Vars.baseURL);
        driver.findElement(loginBotton).click();
        WebDriverTools.clearAndFill(inputUsername, Vars.regularUser);
        WebDriverTools.clearAndFill(inputPassword, Vars.regularUserPassword).submit();
        new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(avatar)).click();
        profile.click();
        expertiseModule.click();
        Assert.assertNotNull(tabNewDoc);
    }

    public void validData() {
        driver.navigate().refresh();
        expertiseModule.click();
        WebDriverTools.FluentWaitFunction(createApplication);
        createApplication.click();
        typeDoc.click();
        testCategoryType.click();
        WebDriverTools.clearAndFill(roleInDoc, "test role").click();
        radioButton3.click();
        WebDriverTools.clearAndFill(textarea, "This is automation test").click();
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");
        attachFile.sendKeys(ExpertiseVars.attachmentFileLocation + ExpertiseVars.attachmentFileNamePNG);
        nextButton.click();
        WebDriverTools.FluentWaitFunction(payAndGo);
        payAndGo.click();
        WebDriverTools.FluentWaitFunction(continueWork);
        continueWork.click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"maincolumn\"]/div/div[2]/ul/li[1]/div/div[1]/div[2]")).isDisplayed());


    }

    public void doubleAttachment(){
        driver.navigate().refresh();
        expertiseModule.click();
        createApplication.click();
        typeDoc.click();
        testCategoryType.click();
        WebDriverTools.clearAndFill(roleInDoc, "test role").click();
        radioButton3.click();
        WebDriverTools.clearAndFill(textarea, "This is automation test").click();
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");
        attachFile.sendKeys(ExpertiseVars.attachmentFileLocation + ExpertiseVars.attachmentFileNamePDF);
        attachFile.sendKeys(ExpertiseVars.attachmentFileLocation + ExpertiseVars.attachmentFileNameDOCX);
        WebDriverTools.FluentWaitFunction(nextButton);
        nextButton.click();
        WebDriverTools.FluentWaitFunction(payAndGo);
        payAndGo.click();
        WebDriverTools.FluentWaitFunction(continueWork);
        continueWork.click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"maincolumn\"]/div/div[2]/ul/li[1]/div/div[1]/div[2]")).isDisplayed());
    }


    public void emptyTypeField(){
        driver.navigate().refresh();
        expertiseModule.click();
        createApplication.click();
        WebDriverTools.clearAndFill(roleInDoc, "test role").click();
        radioButton3.click();
        WebDriverTools.clearAndFill(textarea, "This is automation test").click();
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");
        attachFile.sendKeys(ExpertiseVars.attachmentFileLocation + ExpertiseVars.attachmentFileNamePNG);
        nextButton.click();
        Assert.assertTrue(driver.findElement(By.cssSelector("#frontefe13855ecb4f08c893b82990641b449")).isDisplayed());
    }
    public void emptyWhoYouAreField()  {
        driver.navigate().refresh();
        expertiseModule.click();
        WebDriverTools.FluentWaitFunction(createApplication);
        createApplication.click();
        typeDoc.click();
        testCategoryType.click();
        radioButton3.click();
        WebDriverTools.clearAndFill(textarea, "This is automation test").click();
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");
        attachFile.sendKeys(ExpertiseVars.attachmentFileLocation + ExpertiseVars.attachmentFileNamePNG);
        nextButton.click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"front3dd6d39ab46cf734a1a23794bcc6a2dd\"]")).isDisplayed());
    }

    public void incorrectSecondField(){
        driver.navigate().refresh();
        expertiseModule.click();
        WebDriverTools.FluentWaitFunction(createApplication);
        createApplication.click();
        typeDoc.click();
        testCategoryType.click();
        WebDriverTools.clearAndFill(roleInDoc, "1234").click();
        radioButton3.click();
        WebDriverTools.clearAndFill(textarea, "This is automation test").click();
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");
        attachFile.sendKeys(ExpertiseVars.attachmentFileLocation + ExpertiseVars.attachmentFileNamePNG);
        nextButton.click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"front3dd6d39ab46cf734a1a23794bcc6a2dd\"]")).isDisplayed());

    }

    public void requisitesField()  {
        driver.navigate().refresh();
        expertiseModule.click();
        WebDriverTools.FluentWaitFunction(createApplication);
        createApplication.click();
        typeDoc.click();
        testCategoryType.click();
        WebDriverTools.clearAndFill(roleInDoc, "test role").click();
        WebDriverTools.clearAndFill(textarea, "This is automation test").click();
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");
        attachFile.sendKeys(ExpertiseVars.attachmentFileLocation + ExpertiseVars.attachmentFileNamePNG);
        nextButton.click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"front8c5a7f84a773a7e92820274c5740a8a7\"]")).isDisplayed());
    }

    public void emptyRequisiteField() {
        driver.navigate().refresh();
        expertiseModule.click();
        WebDriverTools.FluentWaitFunction(createApplication);
        createApplication.click();
        typeDoc.click();
        testCategoryType.click();
        WebDriverTools.clearAndFill(roleInDoc, "test role").click();
        radioButton3.click();
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");
        attachFile.sendKeys(ExpertiseVars.attachmentFileLocation + ExpertiseVars.attachmentFileNamePNG);
        nextButton.click();
        WebDriverTools.FluentWaitFunction(payAndGo);
        payAndGo.click();
        WebDriverTools.FluentWaitFunction(continueWork);
        continueWork.click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"maincolumn\"]/div/div[2]/ul/li[1]/div/div[1]/div[2]")).isDisplayed());

    }

    public void emptyAttachmentField()  {
        driver.navigate().refresh();
        expertiseModule.click();
        WebDriverTools.FluentWaitFunction(createApplication);
        createApplication.click();
        typeDoc.click();
        testCategoryType.click();
        WebDriverTools.clearAndFill(roleInDoc, "test role").click();
        radioButton3.click();
        WebDriverTools.clearAndFill(textarea, "This is automation test").click();
        nextButton.click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"front393917ab1b5b784ed233b208744263f8\"]")).isDisplayed());
    }

    public void attachment21 () throws InterruptedException {
        driver.navigate().refresh();
        expertiseModule.click();
        createApplication.click();
        typeDoc.click();
        testCategoryType.click();
        WebDriverTools.clearAndFill(roleInDoc, "test role").click();
        radioButton3.click();
        WebDriverTools.clearAndFill(textarea, "This automation test").click();
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");

        int count = 11;
        for (int i = 0; i <= count; i++) {
            attachFile.sendKeys(ExpertiseVars.attachmentFileLocation + ExpertiseVars.attachmentFileNamePNG);
            attachFile.sendKeys(ExpertiseVars.attachmentFileLocation + ExpertiseVars.attachmentFileNamePDF);
        }

        WebDriverTools.FluentWaitFunction(nextButton);
        nextButton.click();
        Thread.sleep(8000);
        WebDriverTools.FluentWaitFunction(payAndGo);
        payAndGo.click();
        WebDriverTools.FluentWaitFunction(continueWork);
        continueWork.click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"maincolumn\"]/div/div[2]/ul/li[1]/div/div[1]/div[2]")).isDisplayed());


                                       /* need fix bug */



    }


    public void fileMoreThen50MB () {
        driver.navigate().refresh();
        expertiseModule.click();
        WebDriverTools.FluentWaitFunction(createApplication);
        createApplication.click();
        typeDoc.click();
        testCategoryType.click();
        WebDriverTools.clearAndFill(roleInDoc, "test role").click();
        radioButton3.click();
        WebDriverTools.clearAndFill(textarea, "This is automation test").click();
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");
        attachFile.sendKeys(ExpertiseVars.attachmentFileLocation + ExpertiseVars.attachmentFileName50MB);
        nextButton.click();
        //Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"front393917ab1b5b784ed233b208744263f8\"]")).isDisplayed());


                                      /* need fix bug */
    }

    public void deleteOneOfUploadedFiles () {
        driver.navigate().refresh();
        expertiseModule.click();
        createApplication.click();
        typeDoc.click();
        testCategoryType.click();
        WebDriverTools.clearAndFill(roleInDoc, "test role").click();
        radioButton3.click();
        WebDriverTools.clearAndFill(textarea, "This automation test").click();
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");
        attachFile.sendKeys(ExpertiseVars.attachmentFileLocation + ExpertiseVars.attachmentFileNamePNG);
        attachFile.sendKeys(ExpertiseVars.attachmentFileLocation + ExpertiseVars.attachmentFileNamePDF);
        driver.findElement(By.xpath("//*[@id=\"maincolumn\"]/div/div[2]/div/span/div[2]/div/ul[2]/li[2]/ul/li/div[2]")).click();
        WebDriverTools.clickOnInvisibleElement(deleteFile);
        WebDriverTools.FluentWaitFunction(nextButton);
        nextButton.click();
        WebDriverTools.FluentWaitFunction(payAndGo);
        payAndGo.click();
        WebDriverTools.FluentWaitFunction(continueWork);
        continueWork.click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"maincolumn\"]/div/div[2]/ul/li[1]/div/div[1]/div[2]")).isDisplayed());

    }


    public void reestablishUploadedFiles () {
        driver.navigate().refresh();
        expertiseModule.click();
        createApplication.click();
        typeDoc.click();
        testCategoryType.click();
        WebDriverTools.clearAndFill(roleInDoc, "test role").click();
        radioButton3.click();
        WebDriverTools.clearAndFill(textarea, "This automation test").click();
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");
        attachFile.sendKeys(ExpertiseVars.attachmentFileLocation + ExpertiseVars.attachmentFileNamePNG);
        attachFile.sendKeys(ExpertiseVars.attachmentFileLocation + ExpertiseVars.attachmentFileNamePDF);
        fileExpertise.click();
        WebDriverTools.clickOnInvisibleElement(deleteFile);
        reestablis.click();
        WebDriverTools.FluentWaitFunction(nextButton);
        nextButton.click();
        WebDriverTools.FluentWaitFunction(payAndGo);
        payAndGo.click();
        WebDriverTools.FluentWaitFunction(continueWork);
        continueWork.click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"maincolumn\"]/div/div[2]/ul/li[1]/div/div[1]/div[2]")).isDisplayed());


                                /* need add key for file */


    }

    public void haveNotMoney (){
        driver.get(Vars.baseURL);
        driver.navigate().refresh();
        driver.findElement(loginBotton).click();
        WebDriverTools.clearAndFill(inputUsername, Vars.regularUser);
        WebDriverTools.clearAndFill(inputPassword, Vars.regularUserPassword).submit();
        new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(avatar)).click();
        profile.click();

        WebDriverTools.withdrawMoneyPOSTrequest("-10");

        driver.navigate().refresh();
        expertiseModule.click();
        WebDriverTools.FluentWaitFunction(createApplication);
        createApplication.click();
        typeDoc.click();
        testCategoryType.click();
        WebDriverTools.clearAndFill(roleInDoc, "test role").click();
        radioButton3.click();
        WebDriverTools.clearAndFill(textarea, "This is automation test").click();
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");
        attachFile.sendKeys(ExpertiseVars.attachmentFileLocation + ExpertiseVars.attachmentFileNamePNG);
        nextButton.click();
        WebDriverTools.FluentWaitFunction(payAndGo);
        payAndGo.click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div[3]/div/div/div[2]/button")).isDisplayed());


        WebDriverTools.addMoneyPOSTrequest(10);

    }

    public String getToken(){
        return
        WebDriverTools.authorizationGetToken("regularUserAutoTest@email.ua","123456");
    }

}



