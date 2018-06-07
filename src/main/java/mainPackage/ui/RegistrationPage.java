package mainPackage.ui;

import mainPackage.interfaceFolder.Vars;
import mainPackage.utils.WebDriverTools;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import static org.openqa.selenium.By.className;
import static org.openqa.selenium.By.cssSelector;


public class RegistrationPage {
    private final By inputUsernameReg = cssSelector("#fronteb734f137e32ca6e15b461599b787c93");
    private final By inputPasswordReg = cssSelector("#front411762a7c586464361f7ff1860ab2a55");
    private final By inputUsername = cssSelector("#front480616263a00926a515c2aaf34b53fcc");
    private final By inputPassword = cssSelector("#front75da0a9226c31d6d56e327f558c4ccd8");
    private final By loginBatton = className("front64fbd75d07ec519ac1c34bbf3c93e41b");
    @FindBy(xpath = "//span[contains(text(),\"E-mail введен не верно\")]")
    private List<WebElement> errorEmail;
    @FindBy(xpath = "//div[contains(text(),\"Пароль должен содержать не менее 6-ти символов\")]")


    private List<WebElement> errorPassw;
    @FindBy(css = "#front64fbd75d07ec519ac1c34bbf3c93e41b > div > div > span")
    private WebElement enterButton;
    @FindBy(css = "#fronta9f92768ea8d4b4129297d3392619fbf")
    private WebElement registrationButton;
    @FindBy(css = "#agree")
    private WebElement checkbox;
    @FindBy(css = "#frontc5d740f39f49e48867e013768c9d155b")
    private WebElement icon;
    @FindBy(css = "#rcmloginuser")
    private WebElement ossName;
    @FindBy(css = "#rcmloginpwd")
    private WebElement ossPass;
    @FindBy(css = "#rcmlistfilter")
    private WebElement sortMenu;
    @FindBy(css = "#rcmlistfilter > option:nth-child(2)")
    private WebElement unread;
    @FindBy(xpath = "//*[@id=\"app\"]/div/div[1]/div[2]/div/div/div[2]/button")
    private WebElement OKbutton;
    @FindBy(css = "#app > div > div.container > div.ModalWindow > div > div > div > div > div > form > div:nth-child(4) > div > div > button > div > div > span")
    private WebElement Regbutton;
    @FindBy(css = "#button-1005-btnInnerEl")
    private WebElement OkButtonForbidden;
    @FindBy(css = "#menuitem-1035-textEl")
    private WebElement SignOut;
    @FindBy(xpath = "//*[@id=\"rcmloginuser\"]")
    private WebElement OSSinputEmail;
    @FindBy(xpath = "//*[@id=\"rcmloginpwd\"]")
    private WebElement OSSinputPass;
    @FindBy(xpath = "//*[@id=\"textfield-1013-inputEl\"]")
    private WebElement adminPassField;
    @FindBy(xpath = "//*[@id=\"login-form\"]/div[1]/form/p/input")
    private WebElement OSSSignIn;
    @FindBy(xpath = "//*[@id=\"toolbar-1014-innerCt\"]")
    private WebElement toolbarSignIn;
    @FindBy(xpath = "//*[@id=\"button-1015-btnInnerEl\"]")
    private WebElement admSignIn;
    @FindBy(xpath = "//*[@id=\"pagingtoolbar-1060-innerCt\"]")
    private WebElement toolbarNextPage;
    @FindBy(xpath = "//*[@id=\"button-1069\"]")
    private WebElement adminNextPage;
    @FindBy(xpath = "//div[contains(text(),\"v.burdiuzha@ossystem.com.ua\")]")   // change "//div[contains(text(),\"Войти\")]"
    private WebElement pickEmail;
    @FindBy(xpath = "//*[@id=\"toolbar-1054-innerCt\"]")
    private WebElement toolbarDeleteUser;
    @FindBy(xpath = "//*[@id=\"button-1059-btnInnerEl\"]")
    private WebElement deleteUser;
    @FindBy(xpath = "//*[@id=\"button-1006-btnInnerEl\"]")
    private WebElement deleteUserYes;
    @FindBy(xpath = "//*[@id=\"messagelist\"]")
    private WebElement messageList;
    @FindBy(xpath = "//span[contains(text(),\"ок\")]")
    private WebElement okButtonWhenSuccessConfirm;
    @FindBy(css = "#button-1005-btnInnerEl")
    private WebElement forbidden;
    @FindBy(css = "#button-1033-btnInnerEl")
    private WebElement logOutAdm;
    @FindBy(css = "#menuitem-1035-textEl")
    private WebElement logOutAadm2;



    private final WebDriver driver;

    public RegistrationPage(WebDriver browser){
        this.driver = browser;
    }

    @Test (dataProvider = "provider1")
    public void verifyEmail(String n1, boolean n2)  {
        driver.get(Vars.baseURL);
        enterButton.click();
        registrationButton.click();

        WebDriverTools.clearAndFill(inputUsernameReg, n1);
        WebDriverTools.clearAndFill(inputPasswordReg, Vars.correctPassword).submit();
        icon.click();
        Assert.assertFalse(errorEmail.size() != 0);

    }

    @Test (dataProvider = "provider2")
    public void verifyPassw(String n1, boolean n2) throws InterruptedException {
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
        enterButton.click();
        registrationButton.click();
        WebDriverTools.clearAndFill(inputUsernameReg, Vars.OSSEmail);
        WebDriverTools.clearAndFill(inputPasswordReg, n1).submit();
        icon.click();
        checkbox.click();
        Regbutton.click();
        Thread.sleep(2000);
        Assert.assertFalse(errorPassw.size() != 0);
        new FluentWait<WebDriver>(driver).withTimeout(7, TimeUnit.SECONDS).pollingEvery(500, TimeUnit.MILLISECONDS)
                .ignoring(InvalidElementStateException.class).until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver browser) {
                return OKbutton;
            }
        }).click();

    }

    public void confirmAccountWithEmail() throws InterruptedException {
        driver.get(Vars.OSS);
        OSSinputEmail.sendKeys(Vars.OSSlogin);
        OSSinputPass.sendKeys(Vars.OSSpass);
        OSSSignIn.click();
        Thread.sleep(5000);
        driver.navigate().refresh();
        Thread.sleep(2000);
        driver.navigate().refresh();
        sortMenu.click();
        Thread.sleep(2000);
        unread.click();
        Thread.sleep(2000);
        WebDriverTools.clearAndFill(cssSelector("#quicksearchbox"), "Confirmation of authorization").click();
        driver.findElement(By.linkText("Confirmation of authorization")).click();
        Assert.assertNotNull(messageList);
        driver.switchTo().frame("messagecontframe");
        driver.findElement(By.linkText("ссылке")).click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String originalWindow = driver.getWindowHandle();
        String newWindow;
        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> stringIterator = windowHandles.iterator();

        while (stringIterator.hasNext()) {
            newWindow = stringIterator.next();
            if (!originalWindow.equalsIgnoreCase(newWindow)) {
                driver.switchTo().window(newWindow);
            }

        }
        driver.close(); ///In here I should close the new window

        driver.switchTo().window(originalWindow);//In here I should switch back to the old window

        driver.get(Vars.baseURL);
        enterButton.click();
        WebDriverTools.clearAndFill(inputUsername, Vars.OSSEmail);
        WebDriverTools.clearAndFill(inputPassword, Vars.adminUserPassword).submit();

    }

    public void deleteUser () throws InterruptedException {

        driver.get(Vars.baseAdminURL);
        WebDriverTools.clearAndFill(By.xpath("//*[@id=\"textfield-1012-inputEl\"]"), Vars.adminUser);
        adminPassField.sendKeys(Vars.adminUserPassword);
        toolbarSignIn.click();
        admSignIn.click();
        toolbarNextPage.click();
        adminNextPage.click();
        pickEmail.click();
        toolbarDeleteUser.click();
        deleteUser.click();
        deleteUserYes.click();
    }

}