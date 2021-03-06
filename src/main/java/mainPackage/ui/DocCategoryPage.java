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
    @FindBy(css = "#clearData")
    private WebElement crossIcon;
    @FindBy(css = "#my_documents > div.list.nothing-found-list")
    private WebElement emptyList;
    @FindBy(css = "#fronta0e5a7b36e788e511ab810fb77be3bc2")
    private WebElement ava;

    @FindBy(css = "#my_documents > div.list > div.search_header > div > div > span:nth-child(2) > input")
    private WebElement placeholder;
    @FindBy(css = "//input[@value=\"null\"]')")
    private WebElement emptySeaarch;

    @FindBy(css = "#my_documents > div.list > div:nth-child(3) > div > div.header_right > svg")
    private WebElement iconbot;
    @FindBy(css = "#my_documents > div.list > div:nth-child(3) > div > div.header_right > p")
    private WebElement iconIsOpen;
    @FindBy(css = "#my_documents > div.list > div:nth-child(2) > div")
    private WebElement automationCat;
    @FindBy(css = "#my_documents > div.list")
    private WebElement automationList;


    private final WebDriver driver;

    public DocCategoryPage(WebDriver driver){
        this.driver = driver;
    }


    public void correctDataWithLupa() {
        catDocTab.click();
        inputCatDoc.sendKeys("Test");
        lupa.click();
        Assert.assertNotNull(numOfDocs);
    }

    public void correctDataWithEnterButton() {
        driver.navigate().refresh();
        catDocTab.click();
        inputCatDoc.sendKeys("Test");
        inputCatDoc.sendKeys(Keys.RETURN);
        Assert.assertNotNull(numOfDocs);
    }
    public void dropdawnList() {
        driver.navigate().refresh();
        catDocTab.click();
        inputCatDoc.sendKeys("Test");
        WebDriverTools.FluentWaitFunction(sumDoc);
        sumDoc.click();
        WebDriverTools.FluentWaitFunction(docContainer);
        Assert.assertNotNull(docContainer);
    }
    public void dataWithOneLetter() throws InterruptedException {
        driver.navigate().refresh();
        catDocTab.click();
        Thread.sleep(1000);
        inputCatDoc.sendKeys(Keys.RETURN);
        WebDriverTools.FluentWaitFunction(crossIcon);
        Assert.assertNotNull(crossIcon);
    }

    public void dataWithTwoLetter() {
        driver.navigate().refresh();
        catDocTab.click();
        inputCatDoc.sendKeys("Te");
        inputCatDoc.sendKeys(Keys.RETURN);
        WebDriverTools.FluentWaitFunction(crossIcon);
        Assert.assertNotNull(crossIcon);
    }

    public void dataWithManyLetters() {
        driver.navigate().refresh();
        catDocTab.click();
        inputCatDoc.sendKeys("ааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааааа");
        inputCatDoc.sendKeys(Keys.RETURN);
        WebDriverTools.FluentWaitFunction(emptyList);
        Assert.assertNotNull(emptyList);
    }

    public void dataWithSlashAndSpace()  {
        driver.navigate().refresh();
        catDocTab.click();
        inputCatDoc.sendKeys(" ");
        inputCatDoc.sendKeys("/");
        inputCatDoc.sendKeys(Keys.RETURN);
        WebDriverTools.FluentWaitFunction(ava);
        Assert.assertNotNull(ava);
    }

    public void deleteData()  {
        driver.navigate().refresh();
        catDocTab.click();
        inputCatDoc.sendKeys("Te");
        WebDriverTools.FluentWaitFunction(crossIcon);
        crossIcon.click();
        Assert.assertNotNull(placeholder);
    }

    public void spaceData()  {
        driver.navigate().refresh();
        catDocTab.click();
        inputCatDoc.sendKeys(" ");
        WebDriverTools.FluentWaitFunction(emptySeaarch);
        Assert.assertNotNull(emptySeaarch);
    }

    public void subcategories() {
        driver.navigate().refresh();
        catDocTab.click();
        WebDriverTools.FluentWaitFunction(iconbot);
        iconbot.click();
        WebDriverTools.FluentWaitFunction(iconIsOpen);
        Assert.assertNotNull(iconIsOpen);
    }

    public void categoryWithOutSubCat() {
        driver.navigate().refresh();
        catDocTab.click();
        automationCat.click();
        WebDriverTools.FluentWaitFunction(automationList);
        Assert.assertNotNull(automationList);
    }
}
