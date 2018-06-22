package mainPackage.ui;

import mainPackage.interfaceFolder.FilesVars;
import mainPackage.utils.WebDriverTools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.openqa.selenium.By.xpath;

public class ProfilePage {

    private final By MENU_BUTTON = By.id("fronta0e5a7b36e788e511ab810fb77be3bc2");
    private final By PROFILE_BUTTON = By.id("front3d6305e5e1809ea5588858bbcf65cc36");
    @FindBy(css = "#front16a8798d370eb274c51db577e047a929")
    private WebElement uploadFoto;


    @FindBy(css = "[class=serverResponseErrorAlerts]")
    private WebElement allertError;

    private final By SURNAME_FIELD = By.id("front405bbe8e4001ec0948f0888ef8a785bf");
    private final By NAME_FIELD = By.id("front68d8b2b234b0e3d0de6620b9ada9d991");
    private final By LASTNAMEFIELD = By.id("front05b064591cb0664a5d27c61545fd181e");
    private final By ADDITIONALEMAILFIELD = By.id("frontf40dad94c14ecd2444dc82d08982eece");
    private final By PHONEFIELD = By.id("front31d4268c6a82c7346f9718c9a0eeddf8");
    //private final By checkBoxField = xpath("//*[@id=\"frontc9cbb1c342671979b3697e6e244c001f\"]");
    private final By SAVE_BUTTON = By.id("front568091864f935c2d061a3f0b850538a2");
    private final By OK_BUTTONERROR = xpath("//button[contains(text(), \"OK\")]");

    private final By CURRENTPASSWORDFIELD = xpath("//div/input[@id=\"fronta8c70490d53c902d11afe62cf486145d\"]");
    private final By NEWPASSWORDFIELD = By.id("front3cade50d322efc1e206a5d352e32304c");
    private final By CONFIRMPASSWORDFIELD = By.id("front0028d653e3134862587fb6a63671137b");
    private final By CHANGEPASSORDBUTTON = By.id("frontba18c5cf1d22197288461c025285de35");
    private final By NOTIFICATIONALERT = xpath("//div[@class=\"notifMasageText notifMasageTextDanger confirm-text\"]");
    private final By BUTTONAPLAYFOTO = xpath("//button[@class=\"accept\"]");
    private final By NOTIFICATIONHEDERYELLOW = xpath("//div[@class=\"notificationHeader yellow\"]");
    private final By NOTIFICATIONOKBUTTONYELLOW = xpath("//button[contains(text(), \"OK\")]");
    private final By NOTIFICATIONOKBUTTONPROFFMOD = xpath("//button[contains(text(), \"Да\")]");

    private final By visiblePassword = xpath("//div/input[@value=\"123456\"]");
    private final By visibleCurrentPasswordButton = xpath("//*[@id=\"fronta8c70490d53c902d11afe62cf486145d\"]");
    private final By visibleNewPasswordButton = xpath("//*[@id=\"front9ba90ab3392fe8ddc58ab1499a28523b\"]");
    private final By visibleConfirPasswordButton = xpath("//*[@id=\"frontbbe4c7ed0235340b35e11aa63d6bcd9a\"]");

    private final By successSaveMessage = xpath("//p[contains(text(),\"Персональные даные изменены успешно\")]");

    static final By PROFSLADER = By.id("front38ff1273b71541cadb2b3117b8f60cad");
    static final By PROFMODEON = xpath("//span[@class=\"profesional-mode\"]/span[@class=\"is-active\"][contains(text(), \"Профессионал\")]");
    static final By PROFMODEOFF = xpath("//span[@class=\"normal-mode\"]/span[@class=\"is-active\"][contains(text(), \"Обычный\")]");
    static final By WARNINGPROFFMODEON = By.xpath("//div[@class=\"notificationHeader khaki\"]");

    static final By ERRORNOTSUPPORTEDFORMATPICTURE = By.xpath("//div[@class=\"notifMasageText alert-text\"]");


    @FindBy(css = "input[type=file]")
    private WebElement attachFile;


    @FindBy(css = "#front3958782bbce34c0dfeb6cc232a0fd2df")
    private WebElement profileSideBar;
    @FindBy(css = "#front29b36a788ae06325de5b6c50e83d6cc6")
    private WebElement expertiseSideBar;
    @FindBy(css = "#front71c51c3798c0e53c216a544aba75d67d")
    private WebElement expertiseHouseSideBar;
    @FindBy(css = "#front0c544ebe6d3889a2809847afaf5d83aa")
    private WebElement notifySideBar;
    @FindBy(css = "#frontf2967a974e00e9962e0bca363c54f55c")
    private WebElement myDocSideBar;
    @FindBy(css = "#frontf0e18c1ca6fe110ebb86bded28749c43")
    private WebElement statisticPaymentSideBar;
    @FindBy(css = "[class=addAvatar]")
    private WebElement addAvatar;
    @FindBy(css = "[class=accept]")
    private WebElement acceptAvatar;
    @FindBy(css = "#maincolumn > div > div.userAvatar > div.avaContainer > div > img")
    private WebElement avatarNotNull;
    @FindBy(css = "[class=delete]")
    private WebElement deleteAva;
    @FindBy(css = "img[src='/']")
    private WebElement emptyAva;
    @FindBy(css = "[class=editAva]")
    private WebElement editAva;
    @FindBy(css = "input[type='range']")
    private WebElement dimensionAva1;
    @FindBy(css = "#maincolumn > div > div.personalInfo > div.user-main-data > span.wrapper.name > div.inputTextField > div:nth-child(4)")
    private WebElement nameError;
    @FindBy(css = "#maincolumn > div > div.personalInfo > div.user-main-data > span.wrapper.surname > div.inputTextField > div:nth-child(4)")
    private WebElement surnameError;
    @FindBy(css = "#maincolumn > div > div.userMode > div.overlayAlertDiv > div > div.notificationFooter > button")
    private WebElement lastnameError;
    @FindBy(css = "#maincolumn > div > div.personalInfo > div.email > span > div.inputTextField > div:nth-child(5)")
    private WebElement emailError;
    @FindBy(css = "[class=smallTooltip]")
    private WebElement hintMessage;
    @FindBy(css = "#maincolumn > div > div.personalInfo > div.email > span > div.smallTooltipWrapper.question-tooltip > svg")
    private WebElement hint;
    private WebElement notificationOk;
    @FindBy(css = "#maincolumn > div > div.personalInfo > div.user-main-data > span.wrapper.fathers-name > div.inputTextField > div:nth-child(4)")



    private final WebDriver driver;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }


    public void toProfilePage(){
        driver.findElement(MENU_BUTTON).click();
        driver.findElement(PROFILE_BUTTON).click();
        Assert.assertNotNull(profileSideBar);
        Assert.assertNotNull(expertiseSideBar);
        Assert.assertNotNull(expertiseHouseSideBar);
        Assert.assertNotNull(notifySideBar);
        Assert.assertNotNull(myDocSideBar);
        Assert.assertNotNull(statisticPaymentSideBar);
    }

    public void uploadAvatarGIF()  {
        driver.navigate().refresh();
        WebDriverTools.FluentWaitFunction(attachFile);
        attachFile.sendKeys(FilesVars.attachmentFileLocation + FilesVars.attachmentFileNameGIF);
        Assert.assertNotNull(allertError);
    }

    public void uploadAvatarBMP()  {
        driver.navigate().refresh();
        WebDriverTools.FluentWaitFunction(attachFile);
        attachFile.sendKeys(FilesVars.attachmentFileLocation + FilesVars.attachmentFileNameBMP);
        Assert.assertNotNull(allertError);
    }

    public void uploadAvatarWEBP()  {
        driver.navigate().refresh();
        WebDriverTools.FluentWaitFunction(attachFile);
        attachFile.sendKeys(FilesVars.attachmentFileLocation + FilesVars.attachmentFileNameWEBP);
        Assert.assertNotNull(allertError);
    }

    public void uploadAvatarTIFF()  {
        driver.navigate().refresh();
        WebDriverTools.FluentWaitFunction(attachFile);
        attachFile.sendKeys(FilesVars.attachmentFileLocation + FilesVars.attachmentFileNameTIFF);
        Assert.assertNotNull(allertError);
    }

    public void uploadAvatarSVG()  {
        driver.navigate().refresh();
        WebDriverTools.FluentWaitFunction(attachFile);
        attachFile.sendKeys(FilesVars.attachmentFileLocation + FilesVars.attachmentFileNameSVG);
        Assert.assertNotNull(allertError);
    }

    public void uploadAvatar2MB()  {
        driver.navigate().refresh();
        WebDriverTools.FluentWaitFunction(attachFile);
        attachFile.sendKeys(FilesVars.attachmentFileLocation + FilesVars.attachmentFileName2MB);
        Assert.assertNotNull(allertError);
    }

    public void uploadAvatarPNG()  {
        driver.navigate().refresh();
        WebDriverTools.FluentWaitFunction(attachFile);
        attachFile.sendKeys(FilesVars.attachmentFileLocation + FilesVars.attachmentFileNamePNG);
        Assert.assertNotNull(addAvatar);
    }

    public void uploadAvatarJPG()  {
        driver.navigate().refresh();
        WebDriverTools.FluentWaitFunction(attachFile);
        attachFile.sendKeys(FilesVars.attachmentFileLocation + FilesVars.attachmentFileNameJPG);
        WebDriverTools.FluentWaitFunction(acceptAvatar);
        acceptAvatar.click();
        Assert.assertNotNull(avatarNotNull);
    }

    public void deleteAva()  {
        driver.navigate().refresh();
        WebDriverTools.FluentWaitFunction(attachFile);
        attachFile.sendKeys(FilesVars.attachmentFileLocation + FilesVars.attachmentFileNamePNG);
        WebDriverTools.FluentWaitFunction(deleteAva);
        deleteAva.click();
        Assert.assertNotNull(emptyAva);
    }

    public void dimensionsAva() {
        driver.navigate().refresh();
        WebDriverTools.FluentWaitFunction(attachFile);
        attachFile.sendKeys(FilesVars.attachmentFileLocation + FilesVars.attachmentFileNamePNG);
        WebDriverTools.FluentWaitFunction(editAva);
        WebDriverTools.clickOnInvisibleElement(editAva);
        WebDriverTools.clickOnInvisibleElement(dimensionAva1);
        dimensionAva1.sendKeys("1");
        dimensionAva1.click();
        Assert.assertNotNull(dimensionAva1);
    }

    public void editUploadedPhoto() {
        driver.navigate().refresh();
        WebDriverTools.FluentWaitFunction(attachFile);
        attachFile.sendKeys(FilesVars.attachmentFileLocation + FilesVars.attachmentFileNamePNG);
        driver.navigate().refresh();
        WebDriverTools.FluentWaitFunction(editAva);
        WebDriverTools.clickOnInvisibleElement(editAva);
        Assert.assertNotNull(avatarNotNull);
    }


    @Test(dataProvider = "name")
    public void verifyName(String name, boolean n2) throws InterruptedException {
        WebDriverTools.clearAndFill(NAME_FIELD, name);
            driver.findElement(SAVE_BUTTON).click();
        Assert.assertTrue(nameError != null);

    }

    @Test(dataProvider = "surName")
    public void verifysurname(String surName, boolean n2) throws InterruptedException {
        WebDriverTools.clearAndFill(SURNAME_FIELD, surName);
            driver.findElement(SAVE_BUTTON).click();
        Assert.assertTrue(surnameError != null);
        Thread.sleep(500);


    }

    @Test(dataProvider = "lastName")
    public void verifylastName(String lastName, boolean n2) throws InterruptedException {
        WebDriverTools.clearAndFill(LASTNAMEFIELD, lastName);
            driver.findElement(SAVE_BUTTON).click();
        Assert.assertTrue(lastnameError != null);
        Thread.sleep(500);


    }

    public void reviewHintMessage() {
        WebDriverTools.clickOnInvisibleElement(hint);
        hint.click();
        WebDriverTools.FluentWaitFunction(hintMessage);
        Assert.assertNotNull(hintMessage);
    }

    @Test(dataProvider = "email address")
    public void verifyAdditionalEmail(String createEmail, boolean n2) throws InterruptedException {
        WebDriverTools.clearAndFill(ADDITIONALEMAILFIELD ,createEmail);
        Thread.sleep(1000);
        driver.findElement(SAVE_BUTTON).click();
        Assert.assertTrue(emailError != null);
    }



}

 /*   ==============  ======================================================================






    @Test(dataProvider = "surName")
    public void verifyEmail(String surName, boolean n2) throws InterruptedException {
        WebDriverTools.clearAndFill(SURNAMEFIELD, surName);
        if(n2 == false){
            Assert.assertNotNull(ERRORSURNAME);
        }else {
            driver.findElement(SAVEBUTTON).click();
            WebDriverTools.waitForElementClickable((WebElement) OKBUTTONSUCCHANGE);
            driver.findElement(OKBUTTONSUCCHANGE).click();
        }
    }

    @Test(dataProvider = "name")
    public void verifyName(String name, boolean n2) throws InterruptedException {
        WebDriverTools.clearAndFill(NAMEFIELD, name);
        if(n2 == false){
            Assert.assertNotNull(ERRORNAME);
        }else {
            driver.findElement(SAVEBUTTON).click();
            WebDriverTools.waitForElementClickable((WebElement)(OKBUTTONSUCCHANGE);
            driver.findElement(OKBUTTONSUCCHANGE).click();
        }
    }


    @Test(dataProvider = "lastName")
    public void verifylastName(String lastName, boolean n2) throws InterruptedException {
        WebDriverTools.clearAndFill(LASTNAMEFIELD, lastName);
        if(n2 == false){
            Assert.assertNotNull(ERRORLASTNAME);
        }else {
            driver.findElement(SAVEBUTTON).click();
            WebDriverTools.waitForElementClickable((WebElement)(OKBUTTONSUCCHANGE);
            driver.findElement(OKBUTTONSUCCHANGE).click();
        }
    }

    @Test(dataProvider = "changePassword")
    public void verifyChangePassword(String oldPassword, String newPassword) throws InterruptedException{
        WebDriverTools.clearAndFill(CURRENTPASSWORDFIELD, oldPassword);
        WebDriverTools.clearAndFill(NEWPASSWORDFIELD, newPassword);
        WebDriverTools.clearAndFill(CONFIRMPASSWORDFIELD, newPassword);
        Thread.sleep(3000);
        WebDriverTools.waitForElementClickable((WebElement)(CHANGEPASSORDBUTTON);
        driver.findElement(CHANGEPASSORDBUTTON).click();
        Thread.sleep(3000);
        if (driver.findElement(OKBUTTONSUCCHANGE).isDisplayed()){
        driver.findElement(OKBUTTONSUCCHANGE).click();
        }else {
            driver.findElement(NOTIFICATIONOKBUTTONYELLOW).click();
        }

    }

    @Test(dataProvider = "avatarFielsName")
    public void uploadAvatar(String avatarFielsName, boolean n2) throws InterruptedException{
        if (n2 == false) {
            attachFile.sendKeys(ATTACHMENTPICTURE + avatarFielsName);
            Assert.assertNotNull(ERRORNOTSUPPORTEDFORMATPICTURE);
            WebDriverTools.waitForElementClickable((WebElement)(OKBUTTONERROR);
            driver.findElement(OKBUTTONERROR).click();
            WebDriverTools.waitForElementClickable((WebElement)(BUTTONAPLAYFOTO);
            driver.findElement(BUTTONAPLAYFOTO).click();
        }else {
            attachFile.sendKeys(ATTACHMENTPICTURE + avatarFielsName);
            WebDriverTools.waitForElementClickable((WebElement)(BUTTONAPLAYFOTO);
            driver.findElement(BUTTONAPLAYFOTO).click();
        }
    }

    @Test(dataProvider = "email address")
    public void verifyAdditionalEmail(String createEmail, boolean n2){
        WebDriverTools.clearAndFill(ADDITIONALEMAILFIELD ,createEmail);
        if(n2 == false){
            Assert.assertNotNull(ERRORADDITIONALEMAIL);
        }else {
            driver.findElement(SAVEBUTTON).click();
            WebDriverTools.waitForElementClickable((WebElement)(OKBUTTONSUCCHANGE);
            driver.findElement(OKBUTTONSUCCHANGE).click();
        }
    }

    @Test(dataProvider = "phoneNamber")
    public void verifyPhoneNamber(String phoneNamber, boolean n2){
        WebDriverTools.clearAndFill(PHONEFIELD, phoneNamber);
        if(n2 == false){
            Assert.assertNotNull(ERRORPHONENUMBER);
        }else {
            WebDriverTools.waitForElementClickable((WebElement)(SAVEBUTTON);
            driver.findElement(SAVEBUTTON).click();
            WebDriverTools.waitForElementClickable((WebElement)(OKBUTTONSUCCHANGE);
            driver.findElement(OKBUTTONSUCCHANGE).click();
        }
    }

    @Test(description = "Enable professional mode")
    public void switchProfessionalModeSlider(){
        if (driver.findElements(PROFMODEON).size() != 0){
            driver.findElement(PROFSLADER).click();
            Assert.assertTrue(driver.findElement(PROFMODEOFF).isDisplayed());
        }else {
            driver.findElement(PROFSLADER).click();
            WebDriverTools.waitForElementClickable((WebElement)(NOTIFICATIONALERT);
            Assert.assertNotNull(NOTIFICATIONALERT);
            WebDriverTools.waitForElementClickable((WebElement)(NOTIFICATIONOKBUTTONPROFFMOD);
            driver.findElement(NOTIFICATIONOKBUTTONPROFFMOD).click();
            Assert.assertTrue(driver.findElement(PROFMODEON).isDisplayed());
        }
    }

    */


