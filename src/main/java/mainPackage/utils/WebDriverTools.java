package mainPackage.utils;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import mainPackage.interfaceFolder.ExpertiseVars;

import mainPackage.interfaceFolder.Vars;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.json.*;
//import org.json.simple.JSONObject;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import static io.restassured.RestAssured.given;


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
        RestAssured.baseURI ="https://stage.servicedoc.ua";
        RequestSpecification request = given();
        org.json.simple.JSONObject requestParams = new org.json.simple.JSONObject();
        requestParams.put("change", money);
        request.header("Content-Type", "application/json");
        request.header("Authorization", ExpertiseVars.typeToken + authorizationGetTokenUI
                (Vars.regularUser, Vars.regularUserPassword));
        request.body(requestParams.toJSONString());

        System.out.println(requestParams.toJSONString());
        io.restassured.response.Response response = request.post("/api/v1/payment/replenishaccount");
        System.out.println("Response body: " + response.body().asString());
        System.out.println(response);
        System.out.println(request);
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);

                /*     http://toolsqa.com/rest-assured/post-request-using-rest-assured/    */
    }

    public static void withdrawMoneyPOSTrequest(String money)
    {
        RestAssured.baseURI ="https://stage.servicedoc.ua";
        RequestSpecification request = given();
        org.json.simple.JSONObject requestParams = new org.json.simple.JSONObject();
        requestParams.put("change", money);
        requestParams.put("userId", "5af40ce5bb4c21029830830d");
        requestParams.put("forAdminPanel", 1);
        request.header("Content-Type", "application/json");
        request.header("Authorization", ExpertiseVars.typeToken + authorizationGetTokenUI
                (Vars.regularUser, Vars.regularUserPassword));
        request.body(requestParams.toJSONString());

        System.out.println(requestParams.toJSONString());
        io.restassured.response.Response response = request.post("/api/v1/payment/changeaccount/");
        System.out.println("Response body: " + response.body().asString());
        System.out.println(request);
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);

                /*     http://toolsqa.com/rest-assured/post-request-using-rest-assured/    */

    }


    public static String authorizationGetTokenUI(String Name, String Passw)
    {
        RestAssured.baseURI ="https://stage.servicedoc.ua/api/v1";
        RequestSpecification request = given();
        org.json.simple.JSONObject requestParams = new org.json.simple.JSONObject();
        requestParams.put("client_id", "android");
        requestParams.put("client_secret", "SomeRandomCharsAndNumbers");
        requestParams.put("email", Name);
        requestParams.put("grant_type", "password");
        requestParams.put("password", Passw);

        requestParams.put("side", "front");

        requestParams.put("username", Name);
        request.header("Content-Type", "application/json");
        request.body(requestParams.toJSONString());


        System.out.println(requestParams.toJSONString());
        io.restassured.response.Response response = request.post("/oauth/token");
        System.out.println("Response body: " + response.body().asString());
        java.lang.String responseSTR = response.body().asString();

        org.json.JSONObject obj = new JSONObject(responseSTR);
        String tokenUI = obj.getString("access_token");

        System.out.println("This is my token : " + tokenUI);

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
            return
                tokenUI;
    }

}
