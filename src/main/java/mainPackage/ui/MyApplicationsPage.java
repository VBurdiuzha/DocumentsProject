package mainPackage.ui;


import mainPackage.interfaceFolder.Vars;
import mainPackage.utils.WebDriverTools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static org.openqa.selenium.By.className;
import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.xpath;

public class MyApplicationsPage {

    private final By inputUsername = cssSelector("#front480616263a00926a515c2aaf34b53fcc");
    private final By inputPassword = cssSelector("#front75da0a9226c31d6d56e327f558c4ccd8");
    private final By loginButton = xpath("//*[@id=\"front64fbd75d07ec519ac1c34bbf3c93e41b\"]");
    @FindBy(xpath = "//*[@id=\"fronta0e5a7b36e788e511ab810fb77be3bc2\"]")
    private WebElement avatar;
    @FindBy(css = "#front3d6305e5e1809ea5588858bbcf65cc36")
    private WebElement profile;
    @FindBy(css = "#sidemenu > li.li_review > a")
    private WebElement expertiseModule;
    @FindBy(css = "#front2fcf3840290d49dd8320b34367dc760f")
    private WebElement myAppTab;




    private final WebDriver driver;
    public MyApplicationsPage(WebDriver browser){
        this.driver = browser;
    }

    public void expertiseModule() {
        driver.get(Vars.baseURL);
        driver.findElement(loginButton).click();
        WebDriverTools.clearAndFill(inputUsername, Vars.regularUser);
        WebDriverTools.clearAndFill(inputPassword, Vars.regularUserPassword).submit();
        new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(avatar)).click();
        profile.click();
        expertiseModule.click();
        myAppTab.click();
        Assert.assertNotNull(myAppTab);

    }

}
