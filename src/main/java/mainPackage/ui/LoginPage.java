package mainPackage.ui;

import mainPackage.Vars;
import mainPackage.utils.WebDriverTools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.xpath;

public class LoginPage {
    private final By inputUsername = cssSelector("input[name=email]");
    private final By inputPassword = cssSelector("input[name=password]");
    private final By loginBotton = xpath("//span[contains(text(),\"Войти\")]");
    private final By messNotification = xpath("//div[@class=\"messageNotification\"]");
    private final By avatarMenu = xpath("//div[@class=\"avatarMenu\"]");

    private final WebDriver browser;

    public LoginPage(WebDriver browser) {
        this.browser = browser;
    }

    private void login(String user, String password) {
        browser.get(Vars.baseURL);
        browser.findElement(loginBotton).click();
        WebDriverTools.clearAndFill(inputUsername, user);
        WebDriverTools.clearAndFill(inputPassword, password).submit();
    }

    public void successfulLogin(String user, String password) {

        login(user, password);
        Assert.assertNotNull(avatarMenu);
    }

    public void failureLogin(String user, String password) {
        login (user, password);
        Assert.assertNotNull(messNotification);
    }


}
