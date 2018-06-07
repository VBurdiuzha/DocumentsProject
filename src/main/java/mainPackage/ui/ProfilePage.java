package mainPackage.ui;

import mainPackage.utils.WebDriverTools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.openqa.selenium.By.xpath;

public class ProfilePage {

    private final By MENUBUTTON = By.id("fronta0e5a7b36e788e511ab810fb77be3bc2");
    private final By PROFILEBUTTOB = By.id("front3d6305e5e1809ea5588858bbcf65cc36");
    private final By UPLOADFOTO = By.id("front16a8798d370eb274c51db577e047a929");
    private final String ATTACHMENTPICTURE = "C:\\ServiceDoc\\qa\\src\\main\\resources\\picture\\";
    private final By SURNAMEFIELD = By.id("front405bbe8e4001ec0948f0888ef8a785bf");
    private final By NAMEFIELD = By.id("front68d8b2b234b0e3d0de6620b9ada9d991");
    private final By LASTNAMEFIELD = By.id("front05b064591cb0664a5d27c61545fd181e");
    private final By ADDITIONALEMAILFIELD = By.id("frontf40dad94c14ecd2444dc82d08982eece");
    private final By PHONEFIELD = By.id("front31d4268c6a82c7346f9718c9a0eeddf8");
    //private final By checkBoxField = xpath("//*[@id=\"frontc9cbb1c342671979b3697e6e244c001f\"]");
    private final By SAVEBUTTON = By.id("front568091864f935c2d061a3f0b850538a2");
    private final By OKBUTTONSUCCHANGE = xpath("//button[contains(text(), \"Ok\")]");
    private final By OKBUTTONERROR = xpath("//button[contains(text(), \"OK\")]");

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
    private final By visibleConfirPasswordButton = xpath("//*[@id=\"frontbbe4c7ed0235340b35e11aa63d6bcd9a\"]");;
    private final By successSaveMessage = xpath("//p[contains(text(),\"Персональные даные изменены успешно\")]");

    static final By ERRORSURNAME = xpath("//div[text()=\"Данное поле может содержать только буквы\"]");
    static final By ERRORNAME = xpath("//div[text()=\"Данное поле может содержать только буквы\"]");
    static final By ERRORLASTNAME = xpath("//div[text()=\"Данное поле может содержать только буквы\"]");
    static final By ERRORADDITIONALEMAIL = xpath("//div[contains(text(), \"E-mail введенно не верно\")]");
    static final By ERRORPHONENUMBER = xpath("//div[contains(text(), \"Не верный формат ввода должен быть +380973519267\")]");
    static final By errorCurPass = xpath("//div[text()=\"Пароль введен не верно\"]");
    static final By errorNewPass = xpath("//div[text()=\"Пароль должен состоять не менее чем из 6 символов\"]");
    static final By errorConfPass = xpath("//div[text()=\"Пароли не совпадают\"]");

    static final By PROFSLADER = By.id("front38ff1273b71541cadb2b3117b8f60cad");
    static final By PROFMODEON = xpath("//span[@class=\"profesional-mode\"]/span[@class=\"is-active\"][contains(text(), \"Профессионал\")]");
    static final By PROFMODEOFF= xpath("//span[@class=\"normal-mode\"]/span[@class=\"is-active\"][contains(text(), \"Обычный\")]");
    static final By WARNINGPROFFMODEON = By.xpath("//div[@class=\"notificationHeader khaki\"]");

    static final By ERRORNOTSUPPORTEDFORMATPICTURE = By.xpath("//div[@class=\"notifMasageText alert-text\"]");


    @FindBy(css = "input[type=file]")
    private WebElement attachFile;

    private final WebDriver driver;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForElementClickable(By bySelector) {
        new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(bySelector));
    }

    public void waitForElementDisplayed(By bySelector){
        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(bySelector));
    }

    public void toProfilePage(){
        driver.findElement(MENUBUTTON).click();
        driver.findElement(PROFILEBUTTOB).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class=\"profile\"]")).isDisplayed());
    }

    @Test(dataProvider = "surName")
    public void verifyEmail(String surName, boolean n2) throws InterruptedException {
        WebDriverTools.clearAndFill(SURNAMEFIELD, surName);
        if(n2 == false){
            Assert.assertNotNull(ERRORSURNAME);
        }else {
            driver.findElement(SAVEBUTTON).click();
            waitForElementDisplayed(OKBUTTONSUCCHANGE);
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
            waitForElementDisplayed(OKBUTTONSUCCHANGE);
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
            waitForElementDisplayed(OKBUTTONSUCCHANGE);
            driver.findElement(OKBUTTONSUCCHANGE).click();
        }
    }

    @Test(dataProvider = "changePassword")
    public void verifyChangePassword(String oldPassword, String newPassword) throws InterruptedException{
        WebDriverTools.clearAndFill(CURRENTPASSWORDFIELD, oldPassword);
        WebDriverTools.clearAndFill(NEWPASSWORDFIELD, newPassword);
        WebDriverTools.clearAndFill(CONFIRMPASSWORDFIELD, newPassword);
        Thread.sleep(3000);
        waitForElementClickable(CHANGEPASSORDBUTTON);
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
            waitForElementClickable(OKBUTTONERROR);
            driver.findElement(OKBUTTONERROR).click();
            waitForElementClickable(BUTTONAPLAYFOTO);
            driver.findElement(BUTTONAPLAYFOTO).click();
        }else {
            attachFile.sendKeys(ATTACHMENTPICTURE + avatarFielsName);
            waitForElementDisplayed(BUTTONAPLAYFOTO);
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
            waitForElementDisplayed(OKBUTTONSUCCHANGE);
            driver.findElement(OKBUTTONSUCCHANGE).click();
        }
    }

    @Test(dataProvider = "phoneNamber")
    public void verifyPhoneNamber(String phoneNamber, boolean n2){
        WebDriverTools.clearAndFill(PHONEFIELD, phoneNamber);
        if(n2 == false){
            Assert.assertNotNull(ERRORPHONENUMBER);
        }else {
            waitForElementClickable(SAVEBUTTON);
            driver.findElement(SAVEBUTTON).click();
            waitForElementDisplayed(OKBUTTONSUCCHANGE);
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
            waitForElementDisplayed(NOTIFICATIONALERT);
            Assert.assertNotNull(NOTIFICATIONALERT);
            waitForElementClickable(NOTIFICATIONOKBUTTONPROFFMOD);
            driver.findElement(NOTIFICATIONOKBUTTONPROFFMOD).click();
            Assert.assertTrue(driver.findElement(PROFMODEON).isDisplayed());
        }
    }
}


