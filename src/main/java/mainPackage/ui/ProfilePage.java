package mainPackage.ui;

import mainPackage.utils.WebDriverTools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.openqa.selenium.By.xpath;

public class ProfilePage {

    private final By menuButton = xpath("//*[@id=\"fronta0e5a7b36e788e511ab810fb77be3bc2\"]");
    private final By profileButton = xpath("//*[@id=\"front3d6305e5e1809ea5588858bbcf65cc36\"]");
    private final By uploadFoto = xpath("//div/p[text()=\"Загрузить фото\"]");
    private final By surNameField = xpath("//*[@id=\"front405bbe8e4001ec0948f0888ef8a785bf\"]");
    private final By nameField = xpath("//div/input[@name=\"name\"]");
    private final By lastNameField = xpath("//div/input[@name=\"lastName\"]");
    private final By emailField = xpath("//div/input[@name=\"email\"]");
    private final By additionalEmailField = xpath("//div/input[@name=\"additionalEmail\"]");
    private final By phoneField = xpath("//div/input[@name=\"phone\"]");
    private final By checkBoxField = xpath("//div[@class=\"autificationCheckbox\"]");
    private final By saveButton = xpath("//*[@id=\"front568091864f935c2d061a3f0b850538a2\"]");
    private final By okButton = xpath("//*[@id=\"front8628574b55129c807335ac973147f697\"]");

    private final By curentPasswordField = xpath("//div/input[@name=\"curentPassword\"]");
    private final By newPasswordField = xpath("//div/input[@name=\"newPassword\"]");
    private final By confirmPasswordField = xpath("//div/input[@name=\"confirmPassword\"]");
    private final By changeButton = xpath("//span[contains(text(),\"Изменить\")]");
    private final By slidercheckBoxButton = xpath("//div/input[@name=\"stripedRows\"]");

    private final By popUpMessage = xpath("//div[@class=\"smallTooltip\"]");
    private final By visiblePassword = xpath("//div/input[@value=\"123456\"]");
    private final By visiblePasswordButton = xpath("");
    private final By successSaveMessage = xpath("//p[contains(text(),\"Персональные даные изменены успешно\")]");


    private final WebDriver driver;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public void toProfilePage(){
        driver.findElement(menuButton).click();
        driver.findElement(profileButton).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class=\"profile\"]")).isDisplayed());
    }

    @Test(dataProvider = "surName")
    public void verifyEmail(String surName, boolean n2) throws InterruptedException {

        WebDriverTools.clearAndFill(surNameField, surName);

        driver.findElement(saveButton).click();

        driver.findElement(okButton).click();

    }



}
