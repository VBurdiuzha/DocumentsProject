package mainPackage.ui;

import mainPackage.interfaceFolder.LogsVars;
import mainPackage.utils.WebDriverTools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static org.openqa.selenium.By.className;
import static org.openqa.selenium.By.cssSelector;


public class RegistrationPage {
    private final By inputUsernameReg = cssSelector("#fronteb734f137e32ca6e15b461599b787c93");
    private final By inputPasswordReg = cssSelector("#front411762a7c586464361f7ff1860ab2a55");
    private final By inputUsername = cssSelector("#front480616263a00926a515c2aaf34b53fcc");
    private final By inputPassword = cssSelector("#front75da0a9226c31d6d56e327f558c4ccd8");
    private final By loginBatton = className("front64fbd75d07ec519ac1c34bbf3c93e41b");
    @FindBy(css = "#app > div > div.container > div.ModalWindow > div > div > div > div > div > div > form > div:nth-child(1) > div > div:nth-child(5)")
    private List<WebElement> errorEmail;
    @FindBy(xpath = "//div[contains(text(),\"Пароль введен\")]")
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
    @FindBy(css = "#textfield-1085-inputWrap")
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
    @FindBy(xpath = "//div[contains(text(),\"v.burdiuzha@ossystem.com.ua\")]")
    private WebElement pickEmail;
    @FindBy(css = "[class='x-toolbar-separator x-toolbar-separator-horizontal x-box-item x-toolbar-item']")
    private WebElement toolbarDeleteUser;
    @FindBy(css = "#button-1074")
    private WebElement deleteUser;
    @FindBy(css = "[class='x-toolbar x-docked x-toolbar-footer x-box-layout-ct']")
    private WebElement toolbardeleteUserYes;
    @FindBy(css = "[class='x-btn-icon-el x-btn-icon-el-default-small  ']")
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
    @FindBy(css = "[class='x-form-item-body x-form-item-body-default x-form-text-field-body x-form-text-field-body-default  ']")
    private WebElement emailAdminSignUp;
    @FindBy(css = "[class='x-form-text-wrap x-form-text-wrap-default']")
    private WebElement passwAdminSignUp;
    @FindBy(css = "[class='x-btn-icon-el x-btn-icon-el-plain-toolbar-small x-tbar-page-next ']")
    private WebElement nextPageAdm;


    @FindBy(css = "[role='presentation']")
    private WebElement nextPageToolBar;
    @FindBy(css = "[class='checkError']")
    private WebElement errorRegPopUp;


    @FindBy(css = "[class='x-menu-item-text x-menu-item-text-default x-menu-item-indent-no-separator']")
    private WebElement timeFilterUp;


    private final WebDriver driver;

    public RegistrationPage(WebDriver browser) {
        this.driver = browser;
    }

    @Test(dataProvider = "emailReg")
    public void verifyEmail(String n1, boolean n2) {
        driver.get(LogsVars.baseURL);
        enterButton.click();
        registrationButton.click();

        WebDriverTools.clearAndFill(inputUsernameReg, n1);
        WebDriverTools.clearAndFill(inputPasswordReg, LogsVars.correctPassword).submit();
        icon.click();
        Assert.assertFalse(errorEmail.size() != 0);
        Assert.assertNotNull(errorRegPopUp);
    }

    @Test(dataProvider = "passwReg")
    public void verifyPassw(String n1, boolean n2) throws InterruptedException {
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
        enterButton.click();
        registrationButton.click();
        WebDriverTools.clearAndFill(inputUsernameReg, LogsVars.OSSEmail);
        WebDriverTools.clearAndFill(inputPasswordReg, n1).submit();
        icon.click();
        checkbox.click();
        Regbutton.click();
        Thread.sleep(2000);
        Assert.assertFalse(errorPassw.size() != 0);
        WebDriverTools.FluentWaitFunction(OKbutton);
        Assert.assertNotNull(errorRegPopUp);

    }

    public void confirmAccountWithEmail() throws InterruptedException {
        driver.get(LogsVars.OSS);
        OSSinputEmail.sendKeys(LogsVars.OSSlogin);
        OSSinputPass.sendKeys(LogsVars.OSSpass);
        OSSSignIn.click();
        Thread.sleep(2000);
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

        driver.close();
        driver.switchTo().window(originalWindow);

    }

    public void deleteUser() throws InterruptedException {

        driver.get(LogsVars.baseAdminURL);
        WebDriverTools.actionsForFocusElement(emailAdminSignUp, LogsVars.adminUser);
        WebDriverTools.actionsForFocusElement(passwAdminSignUp, LogsVars.adminUserPassword);
        toolbarSignIn.click();
        admSignIn.click();

        WebDriverTools.clickOnInvisibleElement(nextPageToolBar);
        WebDriverTools.FluentWaitFunction(nextPageAdm);
        WebDriverTools.clickOnInvisibleElement(nextPageAdm);
        nextPageAdm.click();

        WebDriverTools.clickOnInvisibleElement(pickEmail);
        Thread.sleep(2000);
        WebDriverTools.clickOnInvisibleElement(toolbarDeleteUser);
//        toolbarDeleteUser.click();

        WebDriverTools.clickOnInvisibleElement(deleteUser);
        Thread.sleep(2000);
        WebDriverTools.FluentWaitFunction(deleteUserYes);
        WebDriverTools.clickOnInvisibleElement(deleteUserYes);

    }

}