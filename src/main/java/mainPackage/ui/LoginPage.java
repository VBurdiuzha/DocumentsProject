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

public class LoginPage {
    private final By inputUsername = cssSelector("input[name=email]");
    private final By inputPassword = cssSelector("input[name=password]");
    @FindBy(css = "#app > div > div.container > div.ModalWindow > div > div > div > div > div > div > form > div.recoverPassword > div > div")
    private List<WebElement> messageError;


    private final WebDriver browser;

    public LoginPage(WebDriver browser) {

        this.browser = browser;
    }

    public void successfulLogin() {

        login(Vars.password);
    }

    public void failureLogin() {
        login("badPassword");
        Assert.assertTrue(messageError.size() != 0);
    }

    private void login(String password) {
        browser.get(Vars.baseURL);
        browser.findElement(cssSelector("#app > div > div.container > div > div > div.headerRight > div:nth-child(2) > button > div > div > span")).click();

        WebDriverTools.clearAndFill(inputUsername, Vars.username);
        WebDriverTools.clearAndFill(inputPassword, password).submit();
    }

}
