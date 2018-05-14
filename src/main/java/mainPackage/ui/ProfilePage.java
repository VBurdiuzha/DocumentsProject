package mainPackage.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.openqa.selenium.By.cssSelector;

public class ProfilePage {
    private final By menuButton = cssSelector("#app > div > div.container > div > div > div.headerRight > div.avatarMenu > div > button > div > div > div > img");
    //public String AVATAR_MENU = "//div[@class=\"avaFrema\"]";
    //private List<WebElement>messageError;

    private final WebDriver browser;

    public ProfilePage(WebDriver browser) {

        this.browser = browser;
    }

    public void goToProfile(){
        browser.findElement(menuButton).click();
    }
}
