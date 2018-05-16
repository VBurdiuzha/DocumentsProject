package mainPackage.ui;

import mainPackage.Vars;
import mainPackage.utils.WebDriverTools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.openqa.selenium.By.cssSelector;

public class RegistrationPage {
    private final By inputUsername = cssSelector("input[name=email]");
    private final By inputPassword = cssSelector("input[name=password]");
    @FindBy(xpath = "//span[contains(text(),\"E-mail введен не верно\")]")
    private List<WebElement> errorEmail;
    @FindBy(xpath = "//span[contains(text(),\"Пароль должен содержать не менее 6-ти символов\")]")
    private List<WebElement> errorPassw;
    @FindBy(xpath = "//span[contains(text(),\"Войти\")]")
    private WebElement enterButton;
    @FindBy(xpath = "//span[contains(text(),\"Регистрация\")]")
    private WebElement registrationButton;
    @FindBy(css = "#agree")
    private WebElement checkbox;
    @FindBy(css = "#app > div > div.container > div.ModalWindow > div > div > div > div > div > form > div:nth-child(2) > svg")
    private WebElement icon;
    @FindBy(css = "#rcmloginuser")
    private WebElement ossName;
    @FindBy(css = "#rcmloginpwd")
    private WebElement ossPass;

    private final WebDriver browser;

    public RegistrationPage(WebDriver browser){
        this.browser = browser;
    }

    @Test (dataProvider = "email address")
    public void verifyEmail(String email, boolean n2)  {
        browser.get(Vars.baseURL);
        enterButton.click();
        registrationButton.click();

        WebDriverTools.clearAndFill(inputUsername, email);
        WebDriverTools.clearAndFill(inputPassword, Vars.correctPassword).submit();
        icon.click();
        Assert.assertFalse(errorEmail.size() != 0);

    }

    @Test (dataProvider = "password")
    public void verifyPassw(String password, boolean n2)  {
        WebDriverTools.clearAndFill(inputUsername, Vars.regularUser);
        WebDriverTools.clearAndFill(inputPassword, password).submit();
        icon.click();
        checkbox.click();
        Assert.assertFalse(errorPassw.size() != 0);
    }

    public void enterEmail(){
        browser.get(Vars.OSS);
        browser.findElement(By.xpath("//*[@id=\"rcmloginuser\"]")).sendKeys(Vars.OSSlogin);
        System.out.println("GJ");
        browser.findElement(By.xpath("//*[@id=\"rcmloginpwd\"]")).sendKeys(Vars.OSSpass);
        browser.findElement(By.xpath("//*[@id=\"login-form\"]/div[1]/form/p/input")).click();

    }
}
