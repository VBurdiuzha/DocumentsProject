package mainPackage.ui;

import mainPackage.utils.WebDriverTools;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static org.openqa.selenium.By.cssSelector;


public class DocCategoryPage {
    private final By inputUsername = cssSelector("#front480616263a00926a515c2aaf34b53fcc");
    private final By inputPassword = cssSelector("#front75da0a9226c31d6d56e327f558c4ccd8");
    private final By loginButton = cssSelector("#front64fbd75d07ec519ac1c34bbf3c93e41b");

    @FindBy(css = "#app > div > div.container > div > div > div.headerLeft > ul > li:nth-child(2) > a")
    private WebElement catDocTab;
    @FindBy(css = "#my_documents > div.list > div.search_header > div > div > span:nth-child(2) > input")
    private WebElement inputCatDoc;
    @FindBy(css = "#my_documents > div.list > div.search_header > div > div > span:nth-child(2) > svg")
    private WebElement lupa;
    @FindBy(css = "#my_documents > div.list > div.list_header > p")
    private WebElement numOfDocs;
    @FindBy(xpath = "//*[@id=\"5a293e74bf4ed10001a54d69\"]")
    private WebElement sumDoc;
    @FindBy(css = "#my_documents > div.list > div.aboutDocContainer")
    private WebElement docContainer;



    private final WebDriver driver;

    public DocCategoryPage(WebDriver driver){
        this.driver = driver;
    }


    public void correctDataWithLupa(){
        catDocTab.click();
        inputCatDoc.sendKeys("Test");
        lupa.click();
        Assert.assertNotNull(numOfDocs);
    }

    public void correctDataWithEnterButton() throws InterruptedException {
        catDocTab.click();
        inputCatDoc.sendKeys("Test");
        Thread.sleep(1000);
        inputCatDoc.sendKeys(Keys.RETURN);
        Assert.assertNotNull(numOfDocs);
    }
    public void dropdawnList() {
        catDocTab.click();
        inputCatDoc.sendKeys("Test");
        WebDriverTools.FluentWaitFunction(sumDoc);
        sumDoc.click();
        WebDriverTools.FluentWaitFunction(docContainer);
        Assert.assertNotNull(docContainer);
    }

}
