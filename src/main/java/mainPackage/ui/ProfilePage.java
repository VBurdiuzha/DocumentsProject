package mainPackage.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.File;
import java.util.List;

import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.xpath;

public class ProfilePage {

    private final By menuButton = xpath("//div[@class=\"iconMenu\"]");
    private final By profileButton = xpath("//div[text()=\"Профиль\"]");
    private final By uploadFoto = xpath("//div/p[text()=\"Загрузить фото\"]");
    //private final String urlFotoAvatar = "C:\\ServiceDoc\\qa\\src\\main\\resources\\picture";

    private final WebDriver browser;

    public ProfilePage(WebDriver browser) {
        this.browser = browser;
    }

    public void goToProfile(){
        browser.findElement(menuButton).click();
    }

    public void toProfilePage(){
        browser.findElement(profileButton).click();
        Assert.assertTrue(browser.findElement(By.xpath("//div[@class=\"profile\"]")).isDisplayed());
    }

    public void openUploadFotoWindow(){
        browser.findElement(uploadFoto).click();
        System.out.println("Windows opened");
    }

    public void uploadFile(){
        File file = new File("pathToFile");
    }


}
