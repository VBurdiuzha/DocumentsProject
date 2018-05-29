package mainPackage.ui;

import mainPackage.Vars;
import mainPackage.utils.WebDriverTools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
    private final By nameField = xpath("//*[@id=\"front68d8b2b234b0e3d0de6620b9ada9d991\"]");
    private final By lastNameField = xpath("//*[@id=\"front05b064591cb0664a5d27c61545fd181e\"]");
    private final By emailField = xpath("//div/input[@name=\"email\"]");
    private final By additionalEmailField = xpath("//div/input[@name=\"additionalEmail\"]");
    private final By phoneField = xpath("//div/input[@name=\"phone\"]");
    private final By checkBoxField = xpath("//div[@class=\"autificationCheckbox\"]");
    private final By saveButton = xpath("//*[@id=\"front568091864f935c2d061a3f0b850538a2\"]");
    private final By okButton = xpath("//*[@id=\"front8628574b55129c807335ac973147f697\"]");

    private final By curentPasswordField = xpath("//div/input[@id=\"fronta8c70490d53c902d11afe62cf486145d\"]");
    private final By newPasswordField = xpath("//*[@id=\"front3cade50d322efc1e206a5d352e32304c\"]");
    private final By confirmPasswordField = xpath("//*[@id=\"front0028d653e3134862587fb6a63671137b\"]");
    private final By changePasswordButton = xpath("//*[@id=\"frontba18c5cf1d22197288461c025285de35\"]");
    private final By slidercheckBoxButton = xpath("//div/input[@name=\"stripedRows\"]");

    private final By popUpMessage = xpath("//div[@class=\"smallTooltip\"]");
    private final By visiblePassword = xpath("//div/input[@value=\"123456\"]");
    private final By visibleCurrentPasswordButton = xpath("//*[@id=\"fronta8c70490d53c902d11afe62cf486145d\"]");
    private final By visibleNewPasswordButton = xpath("//*[@id=\"front9ba90ab3392fe8ddc58ab1499a28523b\"]");
    private final By visibleConfirPasswordButton = xpath("//*[@id=\"frontbbe4c7ed0235340b35e11aa63d6bcd9a\"]");;
    private final By successSaveMessage = xpath("//p[contains(text(),\"Персональные даные изменены успешно\")]");


    private final WebDriver driver;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForElementDisplayed(By bySelector){
        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(bySelector));
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
        waitForElementDisplayed(okButton);
        driver.findElement(okButton).click();
    }

    @Test(dataProvider = "name")
    public void verifyName(String name, boolean n2) throws InterruptedException {
        WebDriverTools.clearAndFill(nameField, name);
        driver.findElement(saveButton).click();
        waitForElementDisplayed(okButton);
        driver.findElement(okButton).click();
    }

    @Test(dataProvider = "lastName")
    public void verifylastName(String lastName, boolean n2) throws InterruptedException {
        WebDriverTools.clearAndFill(lastNameField, lastName);
        driver.findElement(saveButton).click();
        waitForElementDisplayed(okButton);
        driver.findElement(okButton).click();
    }

    @Test(dataProvider = "changePassword")
    public void verifyChangePassword(String changePassword, boolean n2) throws InterruptedException{
        WebDriverTools.clearAndFill(curentPasswordField, Vars.correctPassword);
        WebDriverTools.clearAndFill(newPasswordField, changePassword);
        WebDriverTools.clearAndFill(confirmPasswordField, changePassword);
        driver.findElement(changePasswordButton).click();
        waitForElementDisplayed(okButton);
        driver.findElement(okButton).click();
    }

}
