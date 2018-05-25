package mainPackage.ui;

import mainPackage.interfaceFolder.Vars;
import mainPackage.utils.WebDriverTools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.xpath;

public class LoginPage {
    private final By inputUsername = cssSelector("#front480616263a00926a515c2aaf34b53fcc");
    private final By inputPassword = cssSelector("#front75da0a9226c31d6d56e327f558c4ccd8");
    private final By loginBotton = xpath("//*[@id=\"front64fbd75d07ec519ac1c34bbf3c93e41b\"]");
    private final By messNotification = xpath("//div[@class=\"messageNotification\"]");
    private final By menuButton = xpath("//*[@id=\"fronta0e5a7b36e788e511ab810fb77be3bc2\"]");

    private final WebDriver driver;

    public LoginPage(WebDriver driver) {

        this.driver = driver;
    }

    private void login(String user, String password) {
        driver.get(Vars.baseURL);
        driver.findElement(loginBotton).click();
        WebDriverTools.clearAndFill(inputUsername, user);
        WebDriverTools.clearAndFill(inputPassword, password).submit();
    }

    public void successfulLogin(String user, String password) {

        login(user, password);
        Assert.assertNotNull(menuButton);
    }

    public void failureLogin(String user, String password) {
        login (user, password);
        Assert.assertNotNull(messNotification);
    }


}
