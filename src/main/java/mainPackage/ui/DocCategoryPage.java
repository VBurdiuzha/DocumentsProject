package mainPackage.ui;

import org.openqa.selenium.By;
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
    @FindBy(css = "#my_documents > div.list")
    private WebElement docList;



    private final WebDriver driver;

    public DocCategoryPage(WebDriver driver){
        this.driver = driver;
    }


    public void correctData(){
//        driver.get(Vars.baseURL);
//        driver.findElement(loginButton).click();
//        WebDriverTools.clearAndFill(inputUsername, Vars.regularUser);
//        WebDriverTools.clearAndFill(inputPassword, Vars.regularUserPassword).submit();
        catDocTab.click();
        inputCatDoc.sendKeys("Test");
        lupa.click();
        Assert.assertNotNull(docList);
    }



}
