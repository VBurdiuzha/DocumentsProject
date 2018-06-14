package mainPackage.ui;


import bsh.commands.dir;
import mainPackage.api.APIMethods;
import mainPackage.interfaceFolder.ExpertiseVars;
import mainPackage.interfaceFolder.Vars;
import mainPackage.utils.WebDriverTools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import sun.awt.windows.ThemeReader;

import javax.xml.bind.DatatypeConverter;
import java.io.File;
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
import static org.testng.Assert.assertNotNull;

public class MyApplicationsPage {

    private final By inputUsername = cssSelector("#front480616263a00926a515c2aaf34b53fcc");
    private final By inputPassword = cssSelector("#front75da0a9226c31d6d56e327f558c4ccd8");
    private final By loginButton = xpath("//*[@id=\"front64fbd75d07ec519ac1c34bbf3c93e41b\"]");
    private final By deleteAttachButton = cssSelector("#maincolumn > div > div.ReviewServicesContent > div > div > span > div.MultipleFileSelection > div > ul.FilesList > li > ul > li > div.ButtonRemove > svg > path");


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
    @FindBy(css = "#fronte934dd9bb03d9f7e252f06f1c642da43")
    private WebElement editButton;
    @FindBy(css = "#front868dfaedd842b532f770504a740cbf47")
    private WebElement togleFirstStep;
    @FindBy(xpath = "//*[@id=\"5b20d70c7a39b47d2bb70a8c\"]")
    private WebElement testVilli;
    @FindBy(css = "#front15028f72ff543a7225493002142fac78")
    private WebElement secondStep;
    @FindBy(css = "#frontd4a454317d5f666aa45d98df2d2c06c8")
    private WebElement radioButton1;
    @FindBy(xpath = "//*[@id=\"maincolumn\"]/div/div[2]/div/div/span/div[2]/div/ul[2]/li[2]/ul/li/div[2]")
    private WebElement expertisePNG;
    @FindBy(css = "#maincolumn > div > div.ReviewServicesContent > div > div > span > div.MultipleFileSelection > div > ul.FilesList > li > ul > li > div.ButtonRemove > svg > path")
    private WebElement deleteFile;
    @FindBy(css = "#maincolumn > div > div.ReviewServicesContent > div > div > div.Finalizer > div > button.Save")
    private WebElement saveButton;
    @FindBy(css = "#maincolumn > div > div.ReviewServicesContent > ul > li.Context > div")
    private WebElement listOfDoc;
    @FindBy(css = "#frontf831f8d8a3777a0306b90072cba6bec7")
    private WebElement downloadAtachWhenEdit;
    @FindBy(css = "#maincolumn > div > div.ReviewServicesContent > div > div > div.Finalizer > div > button.Cancel")
    private WebElement cancelButton;

    @FindBy(css = "#maincolumn > div > div.ReviewServicesContent > div > div > span > div.MultipleFileSelection > div > ul.FilesList > li > ul > li > div.ButtonRemove > svg")
    private WebElement deleteAllAttachments;

    @FindBy(css = "#front393917ab1b5b784ed233b208744263f8")
    private WebElement errorMessageAttachments;

    @FindBy(css = "#front02b89c29205d0e3642410285dd273840")
    private WebElement why;

    @FindBy(css = "#maincolumn > div > div.ReviewServicesContent > div > div > div > div > div.wrapperAddContent > div > div.rejectBottom > button")
    private WebElement whyOK;
    @FindBy(css = "#maincolumn > div > div.ReviewServicesContent > div > div > div > div > div.historyWrapper > div:nth-child(5) > div.textWrapperLastChild > div.aboutDate")
    private WebElement aboutDate;
    @FindBy(css = "#frontd8a2d7282f772f3622cfe69e2d0c6190")
    private WebElement archiveButton;
    @FindBy(css = "#front1afe563199b52f8c4170e0edc4a81b37")
    private WebElement archiveTab;
    @FindBy(css = "#front27d1fdd92bb71da13adda72adb6eeef8")
    private WebElement pay;
    @FindBy(css = "#front21ad970067350483d2bc4f104de16594")
    private WebElement continueWork;
    @FindBy(css = "#app > div > div.container > div.serverResponseErrorAlerts > div > div > div.buttons > button")
    private WebElement needMoneyButton;



    private final WebDriver driver;

    public MyApplicationsPage(WebDriver browser) {
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
        assertNotNull(myAppTab);

    }

    public void reviewAppInTheWork() {
        driver.navigate().refresh();
        expertiseModule.click();
        myAppTab.click();
        actions.click();
        WebDriverTools.FluentWaitFunction(view);
        view.click();
        assertNotNull(numOfApplication);
        assertNotNull(dateStart);
        assertNotNull(dateUpdate);
        assertNotNull(status);
        assertNotNull(typeOfApplication);
        assertNotNull(side);
        assertNotNull(requisiteDoc);
        assertNotNull(text);
        assertNotNull(attachment);
        assertNotNull(updateButton);
        assertNotNull(descriptionIcon);
        assertNotNull(messages);
        assertNotNull(flowApplication);
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
        uploadAttach.sendKeys(ExpertiseVars.attachmentFileLocation + ExpertiseVars.attachmentFileNamePNG);
        ;
        WebDriverTools.clickOnInvisibleElement(sendButton);
        WebDriverTools.FluentWaitFunction(fileExpertise);
        assertNotNull("Какое-то дополнение от пользователя");
        assertNotNull(fileExpertise);


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

    public void whyRejectedApp() {
        APIMethods.createApplication();
        APIMethods.payDoc();
        APIMethods.rejectedApplication();

        driver.navigate().refresh();
        expertiseModule.click();
        myAppTab.click();
        WebDriverTools.FluentWaitFunction(actions);
        actions.click();
        WebDriverTools.FluentWaitFunction(view);
        view.click();
        why.click();
        WebDriverTools.FluentWaitFunction(whyOK);
        whyOK.click();
        assertNotNull(aboutDate);

    }

    public void rejectedAppToArchive(){

        driver.navigate().refresh();
        expertiseModule.click();
        myAppTab.click();
        WebDriverTools.FluentWaitFunction(actions);
        actions.click();
        WebDriverTools.FluentWaitFunction(archiveButton);
        archiveButton.click();
        String selector = "#front721c0f66c16e78c7120e829611dac8c8_242";
        String num = selector.substring(39, selector.length());
        archiveTab.click();
        Assert.assertFalse(By.id(By.cssSelector("#front_rid_") + num).equals(true));

    }

    public void editAppWaitForPay() {

        driver.navigate().refresh();
        expertiseModule.click();
        myAppTab.click();
        WebDriverTools.FluentWaitFunction(actions);
        actions.click();
        WebDriverTools.FluentWaitFunction(editButton);
        WebDriverTools.clickOnInvisibleElement(editButton);
        WebDriverTools.FluentWaitFunction(togleFirstStep);
        togleFirstStep.click();
        WebDriverTools.clickOnInvisibleElement(testVilli);
        secondStep.sendKeys("Никем");
        radioButton1.click();
        expertisePNG.click();
        WebDriverTools.clickOnInvisibleElement(deleteFile);
        saveButton.click();
        assertNotNull(listOfDoc);


                                       /* need add changes to the history */


    }

    public void downloadAttachWhenEditApp() throws IOException, NoSuchAlgorithmException {

        driver.navigate().refresh();
        expertiseModule.click();
        myAppTab.click();
        WebDriverTools.FluentWaitFunction(actions);
        actions.click();
        WebDriverTools.FluentWaitFunction(editButton);
        WebDriverTools.clickOnInvisibleElement(editButton);
        WebDriverTools.FluentWaitFunction(downloadAtachWhenEdit);
        WebDriverTools.clickOnInvisibleElement(downloadAtachWhenEdit);
        byte[] b = Files.readAllBytes(Paths.get("/Users/villiburduza/Downloads/expertise.png"));
        byte[] hash = MessageDigest.getInstance("MD5").digest(b);

        String expected = "BB4EA20ADCE262FCCC4685A929FB5104";
        String actual = DatatypeConverter.printHexBinary(hash);
        System.out.println(expected.equalsIgnoreCase(actual) ? " Download attachment test. Hash pass" : "Hash failed");

    }

    public void deleteAllAttachWhenEdit() throws InterruptedException {


        driver.navigate().refresh();
        expertiseModule.click();
        myAppTab.click();
        WebDriverTools.FluentWaitFunction(actions);
        actions.click();
        WebDriverTools.FluentWaitFunction(editButton);
        WebDriverTools.clickOnInvisibleElement(editButton);


        try {
            while (deleteAttachButton != null) {
                WebDriverTools.clickOnInvisibleElement(deleteAllAttachments);
            }
        } catch (Throwable t) {}

        assertNotNull(errorMessageAttachments);

    }

    public void cancelChangesEditApp(){
        driver.navigate().refresh();
        expertiseModule.click();
        myAppTab.click();
        WebDriverTools.FluentWaitFunction(actions);
        actions.click();
        WebDriverTools.FluentWaitFunction(editButton);
        WebDriverTools.clickOnInvisibleElement(editButton);

        try {
            while (deleteAttachButton != null) {
                WebDriverTools.clickOnInvisibleElement(deleteAllAttachments);
            }
        } catch (Throwable t) {}

        cancelButton.click();
        WebDriverTools.FluentWaitFunction(actions);
        actions.click();
        WebDriverTools.FluentWaitFunction(view);
        WebDriverTools.clickOnInvisibleElement(view);
        assertNotNull(expertisePNG);

    }

    public void successPaymentWhenWaitForPayDoc(){

        driver.navigate().refresh();
        expertiseModule.click();
        myAppTab.click();
        WebDriverTools.FluentWaitFunction(actions);
        actions.click();
        WebDriverTools.FluentWaitFunction(pay);
        WebDriverTools.clickOnInvisibleElement(pay);
        WebDriverTools.FluentWaitFunction(continueWork);
        continueWork.click();
        assertNotNull(listOfDoc);

    }

    public void haveNotMoneyWhenWaitForPayDoc(){
        driver.get(Vars.baseURL);
        driver.findElement(loginButton).click();
        WebDriverTools.clearAndFill(inputUsername, Vars.regularUser);
        WebDriverTools.clearAndFill(inputPassword, Vars.regularUserPassword).submit();
        new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(avatar)).click();
        profile.click();

        APIMethods.withDrawAllMoney();

        expertiseModule.click();
        myAppTab.click();
        WebDriverTools.FluentWaitFunction(actions);
        actions.click();
        WebDriverTools.FluentWaitFunction(pay);
        WebDriverTools.clickOnInvisibleElement(pay);

        WebDriverTools.FluentWaitFunction(needMoneyButton);
        assertNotNull(needMoneyButton);

        APIMethods.addMoneyPOSTrequest(100);


    }
}
