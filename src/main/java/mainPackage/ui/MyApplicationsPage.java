package mainPackage.ui;


import mainPackage.api.APIMethods;
import mainPackage.interfaceFolder.FilesVars;
import mainPackage.interfaceFolder.LogsVars;
import mainPackage.utils.WebDriverTools;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

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
    @FindBy(css = "#front29b36a788ae06325de5b6c50e83d6cc6")
    private WebElement expertiseModule;
    @FindBy(css = "#front2fcf3840290d49dd8320b34367dc760f")
    private WebElement myAppTab;
    @FindBy(css = "#maincolumn > div > div.ReviewServicesContent > ul > li.Context > div > div:nth-child(2) > span.popup > div > button")
    private WebElement actions;
    @FindBy(css = "#front96645a8c27674b0b8bf42dc3fa9ae440")
    private WebElement view;
    @FindBy(css = "#maincolumn > div > div.ReviewServicesContent > div > div > div > div > div > ul > li.PriceItem > div")
    private WebElement numOfApplication;
    @FindBy(css = "#front85c2eef0ef9fa995cdd1b001e9634c8b")
    private WebElement dateStart;
    @FindBy(css = "#front6a07130deda0f89ae4a285854a6988bd")
    private WebElement dateUpdate;
    @FindBy(css = "#front02b89c29205d0e3642410285dd273840")
    private WebElement status;
    @FindBy(css = "#frontb737612c0e93da40a675cfe470e5e612")
    private WebElement typeOfApplication;
    @FindBy(css = "#fronta145c173281b0fb34984409a1efaf895")
    private WebElement side;
    @FindBy(css = "#front3d0989f1a3d697120eb9db35dc18c42e")
    private WebElement requisiteDoc;
    @FindBy(css = "#frontec6ebd9ec2bd9c1750ac205d635597eb")
    private WebElement text;
    @FindBy(css = "#frontf831f8d8a3777a0306b90072cba6bec7")
    private WebElement attachment;
    @FindBy(css = "#front765eeb3892cfa9942bd09d53d08c0352")
    private WebElement updateButton;
    @FindBy(css = "//div[class=DescriptionBorder]")
    private WebElement descriptionIcon;
    @FindBy(css = "#maincolumn > div > div.ReviewServicesContent > div > div > div > div > div > div.questionHead")
    private WebElement messages;
    @FindBy(css = "#maincolumn > div > div.ReviewServicesContent > div > div > div > div > div > div.historyTitle")
    private WebElement flowApplication;
    @FindBy(css = "input[type=file]")
    private WebElement uploadAttach;
    @FindBy(css = "#maincolumn > div > div.ReviewServicesContent > div > div > div > div > div > div.wrapperAddContent > div > div.addFooter > div > button.submit")
    private WebElement sendButton;
    @FindBy(css = "div[class='FileName 7568fe1cc132338520598c09a4fefbef']")
    private WebElement fileExpertise;
    @FindBy(css = "#front02b89c29205d0e3642410285dd273840")
    private WebElement filterStatus;
    @FindBy(css = "#frontf831f8d8a3777a0306b90072cba6bec7")
    private WebElement downloadAttachment;
    @FindBy(css = "#frontf831f8d8a3777a0306b90072cba6bec7")
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
    @FindBy(css = "#front3c2cc487eb81783e84b98cb3bb1cd4eb")
    private WebElement newAppTab;


    private final By roleInDoc = xpath("//*[@id=\"front15028f72ff543a7225493002142fac78\"]");
    private final By textarea = cssSelector("#front6cbe73215f7d646d4888d05f14810819");

    @FindBy(css = "#fronte934dd9bb03d9f7e252f06f1c642da43 > div > div > div")
    private WebElement editButtonTest;
    @FindBy(css = "button[class=Save]")
    private WebElement saveButton;

    private final WebDriver driver;

    public MyApplicationsPage(WebDriver browser) {
        this.driver = browser;
    }

    public void createDocWaitForPay() throws InterruptedException {
        driver.navigate().refresh();
        expertiseModule.click();
        newAppTab.click();
        WebDriverTools.FluentWaitFunction(createApplication);
        createApplication.click();
        typeDoc.click();
        testCategoryType.click();
        WebDriverTools.clearAndFill(roleInDoc, "test role").click();
        Thread.sleep(1000);
        radioButton3.click();
        WebDriverTools.clearAndFill(textarea, "This is automation test").click();
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");
        attachFile.sendKeys(FilesVars.attachmentFileLocation + FilesVars.attachmentFileNamePNG);
        attachFile.sendKeys(FilesVars.attachmentFileLocation + FilesVars.attachmentFileNamePDF);
        nextButton.click();
        Thread.sleep(3000);
    }

    public void createDocInWork() throws InterruptedException {
        driver.navigate().refresh();
        expertiseModule.click();
        newAppTab.click();
        WebDriverTools.FluentWaitFunction(createApplication);
        createApplication.click();
        typeDoc.click();
        testCategoryType.click();
        WebDriverTools.clearAndFill(roleInDoc, "test role").click();
        radioButton3.click();
        WebDriverTools.clearAndFill(textarea, "This is automation test").click();
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");
        attachFile.sendKeys(FilesVars.attachmentFileLocation + FilesVars.attachmentFileNamePNG);
        attachFile.sendKeys(FilesVars.attachmentFileLocation + FilesVars.attachmentFileNamePDF);
        nextButton.click();

        Thread.sleep(3000);

        String selector = "#front721c0f66c16e78c7120e829611dac8c8_242";
        String num = selector.substring(39, selector.length());   // get unique value (in this case "242")

        WebDriverTools.FluentWaitFunction(payAndGo);
        payAndGo.click();

    }


    public void reviewAppInTheWork() throws InterruptedException {
        driver.navigate().refresh();
        expertiseModule.click();
        createDocInWork();

        driver.navigate().refresh();
        expertiseModule.click();
        WebDriverTools.StaleElementTools(myAppTab);
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
    public void logIn() {
        driver.get(LogsVars.baseURL);
        driver.findElement(loginButton).click();
        WebDriverTools.clearAndFill(inputUsername, LogsVars.regularUser);
        WebDriverTools.clearAndFill(inputPassword, LogsVars.regularUserPassword).submit();
        new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(avatar)).click();
        profile.click();
        expertiseModule.click();
        myAppTab.click();
        newAppTab.click();
        assertNotNull(myAppTab);

    }



    public void updateAppWaitForPay() throws InterruptedException {
        driver.navigate().refresh();
        expertiseModule.click();
        myAppTab.click();

        createDocWaitForPay();
        myAppTab.click();

        driver.navigate().refresh();
        expertiseModule.click();
        WebDriverTools.StaleElementTools(myAppTab);
        myAppTab.click();
        WebDriverTools.FluentWaitFunction(actions);
        actions.click();
        WebDriverTools.FluentWaitFunction(view);
        Thread.sleep(2000);
        view.click();
        Thread.sleep(2000);
        WebDriverTools.FluentWaitFunction(updateButton);
        updateButton.click();
        Thread.sleep(2000);
        WebDriverTools.clearAndFill(textarea, "This is my changes").click();
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");
        attachFile.sendKeys(FilesVars.attachmentFileLocation + FilesVars.attachmentFileNamePNG);
        attachFile.sendKeys(FilesVars.attachmentFileLocation + FilesVars.attachmentFileNamePDF);
        saveButton.click();

        WebDriverTools.FluentWaitFunction(fileExpertise);
        assertNotNull("Какое-то дополнение от пользователя");
        assertNotNull(fileExpertise);


                               /* need add changes to the history */
    }

    public void downloadAttachment() throws InterruptedException {
        driver.navigate().refresh();
        expertiseModule.click();
        myAppTab.click();
        createDocInWork();


        driver.navigate().refresh();
        expertiseModule.click();
        WebDriverTools.StaleElementTools(myAppTab);
        myAppTab.click();
        WebDriverTools.FluentWaitFunction(filterStatus);
        filterStatus.click();
        WebDriverTools.FluentWaitFunction(actions);
        actions.click();
        WebDriverTools.FluentWaitFunction(view);
         WebDriverTools.clickOnInvisibleElement(view);
        WebDriverTools.FluentWaitFunction(downloadAttachment);
        WebDriverTools.clickOnInvisibleElement(downloadAttachment);
//
//        byte[] b = Files.readAllBytes(Paths.get("/Users/villiburduza/Downloads/expertise.png"));
//        byte[] hash = MessageDigest.getInstance("MD5").digest(b);
//
//        String expected = "BB4EA20ADCE262FCCC4685A929FB5104";
//        String actual = DatatypeConverter.printHexBinary(hash);
//        System.out.println(expected.equalsIgnoreCase(actual) ? " Download attachment test. Hash pass" : "Hash failed");

    }

    public void downloadAttachmentPopUp()  {

        driver.navigate().refresh();
        expertiseModule.click();
        WebDriverTools.StaleElementTools(myAppTab);
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
//        byte[] b = Files.readAllBytes(Paths.get("/Users/villiburduza/Downloads/expertise.png"));
//        byte[] hash = MessageDigest.getInstance("MD5").digest(b);
//
//        String expected = "BB4EA20ADCE262FCCC4685A929FB5104";
//        String actual = DatatypeConverter.printHexBinary(hash);
//        System.out.println(expected.equalsIgnoreCase(actual) ? " Download attachment test. Hash pass" : "Hash failed");

    }

    public void whyRejectedApp() {
        APIMethods.createApplication();
        APIMethods.payDoc();
        APIMethods.rejectedApplication();

        logIn();


        driver.navigate().refresh();
        expertiseModule.click();
        WebDriverTools.StaleElementTools(myAppTab);
        myAppTab.click();
        WebDriverTools.FluentWaitFunction(actions);
        actions.click();
        WebDriverTools.FluentWaitFunction(view);
        view.click();
        WebDriverTools.FluentWaitFunction(why);
        why.click();
        WebDriverTools.FluentWaitFunction(whyOK);
        whyOK.click();
        assertNotNull(aboutDate);

        /*  ==================   need fix  attach API ===================== */

    }

    public void rejectedAppToArchive() throws InterruptedException {
        createDocWaitForPay();
        driver.navigate().refresh();
        expertiseModule.click();
        WebDriverTools.StaleElementTools(myAppTab);
        myAppTab.click();
        WebDriverTools.FluentWaitFunction(actions);
        actions.click();
        WebDriverTools.FluentWaitFunction(archiveButton);
        WebDriverTools.clickOnInvisibleElement(archiveButton);
        String selector = "#front721c0f66c16e78c7120e829611dac8c8_242";
        String num = selector.substring(39, selector.length());
        archiveTab.click();
        Assert.assertFalse(By.id(By.cssSelector("#front_rid_") + num).equals(true));

    }

    public void editAppWaitForPay() throws InterruptedException {

        driver.navigate().refresh();
        expertiseModule.click();
        createDocWaitForPay();

        driver.navigate().refresh();
        expertiseModule.click();
        WebDriverTools.StaleElementTools(myAppTab);
        myAppTab.click();
        WebDriverTools.FluentWaitFunction(actions);
        actions.click();
        Thread.sleep(1000);
        WebDriverTools.FluentWaitFunction(editButtonTest);
        WebDriverTools.clickOnInvisibleElement(editButtonTest);
        WebDriverTools.FluentWaitFunction(togleFirstStep);
        togleFirstStep.click();
        WebDriverTools.clickOnInvisibleElement(testVilli);
        Thread.sleep(2000);
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
//        byte[] b = Files.readAllBytes(Paths.get("/Users/villiburduza/Downloads/expertise.png"));  // for local
//        byte[] hash = MessageDigest.getInstance("MD5").digest(b);
//
//        String expected = "BB4EA20ADCE262FCCC4685A929FB5104";
//        String actual = DatatypeConverter.printHexBinary(hash);
//        System.out.println(expected.equalsIgnoreCase(actual) ? " Download attachment test. Hash pass" : "Hash failed");

    }

    public void deleteAllAttachWhenEdit() throws InterruptedException {

        driver.navigate().refresh();
        new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(avatar)).click();
        profile.click();
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
        new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(avatar)).click();
        profile.click();

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

    public void successPaymentWhenWaitForPayDoc() throws InterruptedException {
        driver.navigate().refresh();
        new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(avatar)).click();
        profile.click();


        createDocWaitForPay();

        driver.navigate().refresh();
        expertiseModule.click();
        WebDriverTools.FluentWaitFunction(actions);
        actions.click();
        WebDriverTools.FluentWaitFunction(pay);
        WebDriverTools.clickOnInvisibleElement(pay);
        WebDriverTools.FluentWaitFunction(continueWork);
        continueWork.click();
        assertNotNull(listOfDoc);

    }

    public void haveNotMoneyWhenWaitForPayDoc() throws InterruptedException {

        APIMethods.withDrawAllMoney();
        driver.navigate().refresh();

        logIn();
        new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(avatar)).click();
        profile.click();

        expertiseModule.click();
        createDocWaitForPay();
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

    public void sendToArchivWhenWaitForPay() throws InterruptedException {
        createDocWaitForPay();

        expertiseModule.click();
        myAppTab.click();
        WebDriverTools.FluentWaitFunction(actions);
        actions.click();
        WebDriverTools.FluentWaitFunction(archiveButton);
        WebDriverTools.clickOnInvisibleElement(archiveButton);
        String selector = "#front721c0f66c16e78c7120e829611dac8c8_242";
        String num = selector.substring(39, selector.length());
        archiveTab.click();
        Assert.assertFalse(By.id(By.cssSelector("#front_rid_") + num).equals(true));

    }

    public void answerForOperatorWhenWaitForPayDoc() throws Exception {
        APIMethods.createApplication();
      //  APIMethods.TEST();

//        APIMethods s = new APIMethods();
//         s.multiPartUploading();
       APIMethods.simpleFileUploading();
//        APIMethods.payDoc();
//        APIMethods.setDocFromDOperToOper();


        // need continue...


    }

}
