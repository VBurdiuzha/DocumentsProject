package mainPackage.ui;


import mainPackage.interfaceFolder.ExpertiseVars;
import mainPackage.interfaceFolder.Vars;
import mainPackage.utils.WebDriverTools;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

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
    @FindBy(css = "#maincolumn > div > div.ReviewServicesContent > ul > li.ReviewIntroFooter > button > div > span")
    private WebElement createApplication;
    @FindBy(css = "#maincolumn > div > div.ReviewServicesContent > div > div.Knowledges > div.Content > ul > li > ul > li:nth-child(2) > div > svg")
    private WebElement typeDoc;
    @FindBy(css = "#\\35 aafce473a24c926d01797ba")
    private WebElement testCategoryType;
    @FindBy(css = "#frontfc57de6a29ea1e8f6ee07fda4f548cc8")
    private WebElement radioButton3;

    @FindBy(xpath = "//*[@id=\"ea88063a-1346-46ae-ff11-b025989a8431\"]/label")
    private WebElement attachFile;




    private final WebDriver driver;

    public ExpertiseUserPage(WebDriver driver) {
        this.driver = driver;
    }


    public void expertiseModule() throws InterruptedException {
        driver.get(Vars.baseURL);
        driver.findElement(loginBotton).click();
        WebDriverTools.clearAndFill(inputUsername, Vars.regularUser);
        WebDriverTools.clearAndFill(inputPassword, Vars.regularUserPassword).submit();
        new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(avatar)).click();
        Thread.sleep(3000);
        profile.click();
        expertiseModule.click();
        Assert.assertNotNull(tabNewDoc);
    }

    public void validData() throws InterruptedException {
        createApplication.click();
        typeDoc.click();
        testCategoryType.click();
        WebDriverTools.clearAndFill(roleInDoc, "test role").click();
        radioButton3.click();
        WebDriverTools.clearAndFill(textarea, "This is my automation test").click();
      //  attachFile.click();


        attachFile.sendKeys(ExpertiseVars.attachmentFileLocation + ExpertiseVars.attachmentFileName);



//        WebElement linkAttachment = new FluentWait<WebDriver>(driver).withTimeout(10, TimeUnit.SECONDS)
//                .pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class)
//                .until(new Function<WebDriver, WebElement>() {
//                    public WebElement apply(WebDriver browser) {
//                        return linkAttachmentName;
//                    }
//                });
//
//        //  Assert.assertEquals(JiraVars.attachmentFileName, linkAttachment.getText());
//
//        attachmentLink = linkAttachment.getText();
//        return ExpertiseVars.attachmentFileName.equals(linkAttachment.getText());


    }


}
