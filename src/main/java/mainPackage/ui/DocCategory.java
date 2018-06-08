package mainPackage.ui;

import com.oracle.jrockit.jfr.UseConstantPool;
import mainPackage.utils.WebDriverTools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

public class DocCategory {
    private final By CATEGORYDOCUMENTS = By.xpath("//a[@href=\"/ru/doccatalog\"]");
    private final By CATEGORYAUTOMATION = By.xpath("//div/h4[contains(text(),\"Automation\")]");
    private final By SIMPLEMARKERTEMPLATE = By.xpath("//div/p[contains(text(), \"Простой маркер\")]");
    private final By CREATEADOCUMENTBUTTON = By.xpath("//button[@class=\"nextStep\"]");
    private final By NEXTBUTTONFERSTSTEP = By.xpath("//button[@class=\"default-button\"]");
    private final By FIELD = By.id("35829368876455533582936887645553");
    private final By NEXTBUTTONSECONDSTEP = By.xpath("//div[@class=\"nextButton\"]");
    private final By CALCULATEDOCUMENTTEMPLATE = By.xpath("//div/p[contains(text(), \"Калькулируемый маркер\")]");

    private final By PAYMENT_BUTTON_PDF = By.xpath("//span[@style=\"font-family: Semibold;\"]");
    private final By BUY_SUCCESS_WINDOW = By.xpath("//div[@class=\"buySuccessModalWindow\"]");

    private final By CONTINUEM_WORK_OK_BUTTON = By.id("front21ad970067350483d2bc4f104de16594");

    private final By DIFFICULTMARKER = By.xpath("//div/p[contains(text(), \"Сложный маркер\")]");

    private final WebDriver driver;

    public DocCategory(WebDriver driver){
        this.driver = driver;
    }

    public void wairForElementDisplayed(By bySelector){
        new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(bySelector));
    }

    @Step("Document category page open")
    public void toDocCategoryPage() throws InterruptedException {
        wairForElementDisplayed(CATEGORYDOCUMENTS);
        driver.findElement(CATEGORYDOCUMENTS).click();
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"my_documents\"]")).isDisplayed());
    }

    public void selectAUtomationFolder(){
        driver.findElement(CATEGORYAUTOMATION).click();
        Assert.assertTrue(driver.findElement(By.xpath("//h3[contains(text(),\"Automation\")]")).isDisplayed());
    }

    @Step("Create simple marker document")
    public void createSimpleMarker(){
        wairForElementDisplayed(SIMPLEMARKERTEMPLATE);
        driver.findElement(SIMPLEMARKERTEMPLATE).click();
        Assert.assertTrue(driver.findElement(By.xpath("//h3[contains(text(), \"Простой маркер\")]")).isDisplayed());
        driver.findElement(CREATEADOCUMENTBUTTON).click();
        Assert.assertTrue(driver.findElement(By.xpath("//h1[contains(text(), \"Выбор языка для документа\")]")).isDisplayed());
        driver.findElement(NEXTBUTTONFERSTSTEP).click();
        WebDriverTools.clearAndFill(FIELD, "123");
        driver.findElement(NEXTBUTTONSECONDSTEP).click();
        wairForElementDisplayed(PAYMENT_BUTTON_PDF);
        driver.findElement(PAYMENT_BUTTON_PDF).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class=\"buySuccessModalWindow\"]")).isDisplayed());
        driver.findElement(CONTINUEM_WORK_OK_BUTTON).click();
        Assert.assertTrue(driver.findElement(By.xpath("//h1[@class=\"gratitude\"]")).isDisplayed());
    }

    @Step("Create difficult marker document")
    public void createDifficultMarker(){
        driver.findElement(DIFFICULTMARKER).click();
        Assert.assertTrue(driver.findElement(By.xpath("//h3[contains(text(), \"Сложный маркер\")]")).isDisplayed());
        driver.findElement(CREATEADOCUMENTBUTTON).click();
        Assert.assertTrue(driver.findElement(By.xpath("//h1[contains(text(), \"Выбор языка для документа\")]")).isDisplayed());
        driver.findElement(NEXTBUTTONFERSTSTEP).click();

    }


    public void createCalculateDocument(){
        driver.findElement(CALCULATEDOCUMENTTEMPLATE).click();
        Assert.assertTrue(driver.findElement(By.xpath("//h3[contains(text(), \"Калькулируемый маркер\")]")).isDisplayed());

    }
}
