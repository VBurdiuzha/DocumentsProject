package mainPackage.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        WebElement linkAttachment = new FluentWait<WebDriver>(driver).withTimeout(10, TimeUnit.SECONDS)
                .pollingEvery(4, TimeUnit.SECONDS).ignoring(org.openqa.selenium.NoSuchElementException.class)
                .until(new Function<WebDriver, WebElement>() {
                    public WebElement apply(WebDriver driver) {
                        return element;
                    }
                });
    }
}