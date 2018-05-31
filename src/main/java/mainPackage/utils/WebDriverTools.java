package mainPackage.utils;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import javax.xml.ws.Response;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;




public class WebDriverTools {
    public static WebDriver driver;

    public static void setDriver(WebDriver driver) {
        WebDriverTools.driver = driver;
    }

    public static WebElement clearAndFill(By selector, String data) {
        WebElement element = driver.findElement(selector);
        element.clear();
        element.sendKeys(data);

        return element;
    }

    public static void waitForElementClickable(WebElement element) {
        new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void switchToFrame(By bySelector) {
        driver.switchTo().frame(driver.findElement(bySelector));
    }


    public static void FluentWaitFunction(WebElement element) {
        WebElement linkAttachment = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS)
                .pollingEvery(1, TimeUnit.SECONDS).ignoring(org.openqa.selenium.NoSuchElementException.class)
                .until(new Function<WebDriver, WebElement>() {
                    public WebElement apply(WebDriver driver) {
                        return element;
                    }
                });
    }

    public static void clickOnInvisibleElement(WebElement element) {
        String script = "var object = arguments[0];"
                + "var theEvent = document.createEvent(\"MouseEvent\");"
                + "theEvent.initMouseEvent(\"click\", true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
                + "object.dispatchEvent(theEvent);";
        ((JavascriptExecutor) driver).executeScript(script, element);
    }

    public static void addMoneyPOSTrequest(int money)
    {
        RestAssured.baseURI ="https://stage.servicedoc.ua/api/v1/payment/replenishaccount";
        RequestSpecification request = RestAssured.given();
        JSONObject requestParams = new JSONObject();
        requestParams.put("change", 1000);
        request.header("Content-Type", "application/json");
        request.header("Authorization", "Bearer b71c0688d16d574a17dde2b85f8258fd3c295043951a5640f123f8bb3edf41c4");
        request.body(requestParams.toJSONString());

        System.out.println(requestParams.toJSONString());
        io.restassured.response.Response response = request.post("payment");
        System.out.println("Response body: " + response.body().asString());
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);

                /*     http://toolsqa.com/rest-assured/post-request-using-rest-assured/    */

    }



    public static void withdrawMoneyPOSTrequest(int money)
    {
        RestAssured.baseURI ="https://stage.servicedoc.ua/api/v1/payment/changeaccount";
        RequestSpecification request = RestAssured.given();
        JSONObject requestParams = new JSONObject();
        requestParams.put("change", money);
        request.header("Content-Type", "application/json");
        request.header("Authorization", "Bearer b71c0688d16d574a17dde2b85f8258fd3c295043951a5640f123f8bb3edf41c4");
        request.body(requestParams.toJSONString());
        io.restassured.response.Response response = request.post("payment");
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);

                /*     http://toolsqa.com/rest-assured/post-request-using-rest-assured/    */

    }


}