package mainPackage.ui;


import mainPackage.api.APIMethods;
import mainPackage.interfaceFolder.ExpertiseVars;
import mainPackage.interfaceFolder.Vars;
import mainPackage.utils.WebDriverTools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import sun.awt.windows.ThemeReader;

import javax.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.openqa.selenium.By.className;
import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.xpath;

public class MyApplicationsPage {

    private final By inputUsername = cssSelector("#front480616263a00926a515c2aaf34b53fcc");
    private final By inputPassword = cssSelector("#front75da0a9226c31d6d56e327f558c4ccd8");
    private final By loginButton = xpath("//*[@id=\"front64fbd75d07ec519ac1c34bbf3c93e41b\"]");
    @FindBy(xpath = "//*[@id=\"fronta0e5a7b36e788e511ab810fb77be3bc2\"]")
    private WebElement avatar;
    @FindBy(css = "#front3d6305e5e1809ea5588858bbcf65cc36")
    private WebElement profile;
    @FindBy(css = "#sidemenu > li.li_review > a")
    private WebElement expertiseModule;
    @FindBy(css = "#front2fcf3840290d49dd8320b34367dc760f")
    private WebElement myAppTab;
    @FindBy(css = "#maincolumn > div > div.ReviewServicesContent > ul > li.Context > div > div:nth-child(2) > span.popup > div > button")
    private WebElement actions;
    @FindBy(css = "#front96645a8c27674b0b8bf42dc3fa9ae440")
    private WebElement view;
    @FindBy(css = "#maincolumn > div > div.ReviewServicesContent > div > div > div > div > div > ul > li.PriceItem > div")
    private WebElement numOfApplication;
    @FindBy(css = "#maincolumn > div > div.ReviewServicesContent > div > div > div > div > div > div.Property > div.Items.CreatedAt > div.Value")
    private WebElement dateStart;
    @FindBy(css = "#maincolumn > div > div.ReviewServicesContent > div > div > div > div > div > div.Property > div.Items.UpdatedAt > div.Value")
    private WebElement dateUpdate;
    @FindBy(css = "#maincolumn > div > div.ReviewServicesContent > div > div > div > div > div > div.Property > div.Items.Status > div.Value")
    private WebElement status;
    @FindBy(css = "#maincolumn > div > div.ReviewServicesContent > div > div > div > div > div > div.Property > div.Items.Document > div.Value")
    private WebElement typeOfApplication;
    @FindBy(css = "#maincolumn > div > div.ReviewServicesContent > div > div > div > div > div > div.Property > div.Items.Ownership > div.Value")
    private WebElement side;
    @FindBy(css = "#maincolumn > div > div.ReviewServicesContent > div > div > div > div > div > div.Property > div.Items.Requisites > div.Value")
    private WebElement requisiteDoc;
    @FindBy(css = "#maincolumn > div > div.ReviewServicesContent > div > div > div > div > div > div.Property > div.Items.Text > div.Value")
    private WebElement text;
    @FindBy(css = "#maincolumn > div > div.ReviewServicesContent > div > div > div > div > div > div.Property > div.Items.MultipleFileSelection > div.Value > div > div > ul > li > ul > li")
    private WebElement attachment;
    @FindBy(css = "#maincolumn > div > div.ReviewServicesContent > div > div > div > div > div > div.AddButtonContainer > button")
    private WebElement updateButton;
    @FindBy(css = "#maincolumn > div > div.ReviewServicesContent > div > div > div > div > div > div.AddButtonContainer > div > svg")
    private WebElement descriptionIcon;
    @FindBy(css = "#maincolumn > div > div.ReviewServicesContent > div > div > div > div > div > div.questionHead")
    private WebElement messages;
    @FindBy(css = "#maincolumn > div > div.ReviewServicesContent > div > div > div > div > div > div.historyTitle")
    private WebElement flowApplication;


    @FindBy(css = "#maincolumn > div > div.ReviewServicesContent > div > div > div > div > div > div.wrapperAddContent > div > div.addBody > textarea")
    private WebElement textAreaUpdateDoc;
    @FindBy(css = "input[type=file]")
    private WebElement uploadAttach;
    @FindBy(css = "#maincolumn > div > div.ReviewServicesContent > div > div > div > div > div > div.wrapperAddContent > div > div.addFooter > div > button.submit")
    private WebElement sendButton;
    @FindBy(css = "div[class='FileName 7568fe1cc132338520598c09a4fefbef']")
    private WebElement fileExpertise;



    @FindBy(css = "#maincolumn > div > div.ReviewServicesContent > ul > li.Context > div > div.ListHeader > div.status")
    private WebElement filterStatus;

    @FindBy(css = "#maincolumn > div > div.ReviewServicesContent > div > div > div > div > div > div.Property > div.Items.MultipleFileSelection > div.Value > div > div > ul > li:nth-child(1) > ul > li > div.Icon > svg")
    private WebElement downloadAttachment;
    @FindBy(css = "#maincolumn > div > div.ReviewServicesContent > div > div > div > div > div > div.wrapperAddContent > div > div.addBody > div > div > div > ul > li > ul > li > div.Icon")
    private WebElement downloadAttachPopUp;


    private final WebDriver driver;
    public MyApplicationsPage(WebDriver browser){
        this.driver = browser;
    }

    public void expertiseModule() {
        driver.get(Vars.baseURL);
        driver.findElement(loginButton).click();
        WebDriverTools.clearAndFill(inputUsername, Vars.regularUser);
        WebDriverTools.clearAndFill(inputPassword, Vars.regularUserPassword).submit();
        new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(avatar)).click();
        profile.click();
        expertiseModule.click();
        myAppTab.click();
        Assert.assertNotNull(myAppTab);

    }

    public void reviewAppInTheWork(){
        driver.navigate().refresh();
        expertiseModule.click();
        myAppTab.click();
        actions.click();
        WebDriverTools.FluentWaitFunction(view);
        view.click();
        Assert.assertNotNull(numOfApplication);
        Assert.assertNotNull(dateStart);
        Assert.assertNotNull(dateUpdate);
        Assert.assertNotNull(status);
        Assert.assertNotNull(typeOfApplication);
        Assert.assertNotNull(side);
        Assert.assertNotNull(requisiteDoc);
        Assert.assertNotNull(text);
        Assert.assertNotNull(attachment);
        Assert.assertNotNull(updateButton);
        Assert.assertNotNull(descriptionIcon);
        Assert.assertNotNull(messages);
        Assert.assertNotNull(flowApplication);
    }

    public void updateAppInTheWork() {
        driver.navigate().refresh();
        expertiseModule.click();
        myAppTab.click();
        WebDriverTools.FluentWaitFunction(filterStatus);
        filterStatus.click();
        WebDriverTools.FluentWaitFunction(actions);
        actions.click();
        WebDriverTools.FluentWaitFunction(view);
        view.click();
        WebDriverTools.FluentWaitFunction(updateButton);
        updateButton.click();
        WebDriverTools.FluentWaitFunction(textAreaUpdateDoc);
        textAreaUpdateDoc.sendKeys("   Какое-то дополнение от пользователя");
        uploadAttach.sendKeys(ExpertiseVars.attachmentFileLocation + ExpertiseVars.attachmentFileNamePNG);;
        WebDriverTools.clickOnInvisibleElement(sendButton);
        WebDriverTools.FluentWaitFunction(fileExpertise);
        Assert.assertNotNull("Какое-то дополнение от пользователя");
        Assert.assertNotNull(fileExpertise);


                               /* need add changes to the history */
    }

    public void downloadAttachment() throws NoSuchAlgorithmException, IOException {
        driver.navigate().refresh();
        expertiseModule.click();
        myAppTab.click();
        WebDriverTools.FluentWaitFunction(filterStatus);
        filterStatus.click();
        WebDriverTools.FluentWaitFunction(actions);
        actions.click();
        WebDriverTools.FluentWaitFunction(view);
        view.click();
        WebDriverTools.FluentWaitFunction(downloadAttachment);
        WebDriverTools.clickOnInvisibleElement(downloadAttachment);

        byte[] b = Files.readAllBytes(Paths.get("/Users/villiburduza/Downloads/expertise.png"));
        byte[] hash = MessageDigest.getInstance("MD5").digest(b);

        String expected = "BB4EA20ADCE262FCCC4685A929FB5104";
        String actual = DatatypeConverter.printHexBinary(hash);
        System.out.println(expected.equalsIgnoreCase(actual) ? " Download attachment test. Hash pass" : "Hash failed");

    }

    public void downloadAttachmentPopUp() throws IOException, NoSuchAlgorithmException {
        driver.navigate().refresh();
        expertiseModule.click();
        myAppTab.click();
        WebDriverTools.FluentWaitFunction(filterStatus);
        filterStatus.click();
        WebDriverTools.FluentWaitFunction(actions);
        actions.click();
        WebDriverTools.FluentWaitFunction(view);
        view.click();
        WebDriverTools.FluentWaitFunction(updateButton);
        updateButton.click();
        WebDriverTools.FluentWaitFunction(downloadAttachPopUp);
        WebDriverTools.clickOnInvisibleElement(downloadAttachPopUp);
        byte[] b = Files.readAllBytes(Paths.get("/Users/villiburduza/Downloads/expertise.png"));
        byte[] hash = MessageDigest.getInstance("MD5").digest(b);

        String expected = "BB4EA20ADCE262FCCC4685A929FB5104";
        String actual = DatatypeConverter.printHexBinary(hash);
        System.out.println(expected.equalsIgnoreCase(actual) ? " Download attachment test. Hash pass" : "Hash failed");

    }

    public void whyRejectedApp(){
        APIMethods.createApplication();
        APIMethods.payDoc();
//        APIMethods.rejectedApplication();



    }


}
