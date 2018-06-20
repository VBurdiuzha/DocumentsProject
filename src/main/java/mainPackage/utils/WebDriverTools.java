package mainPackage.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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


    public static void FluentWaitFunction(final WebElement element) {
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



    public void makeScreenshot(WebDriver driver, String name) throws InterruptedException {
        Thread.sleep(1000);
        File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screen, new File("/target/screenshots/"+ getTime() +"/"+name+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void scrollPageUp(WebDriver driver){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scroll(0, -250);");
    }

    public String getTime(){
        DateFormat dateFormat = new SimpleDateFormat("(dd.MM.yyyy) HH-mm-ss");
        Date date = new Date();
        String today = dateFormat.format(date);
        return today;
    }


}
