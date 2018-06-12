package mainPackage.listeners;

import io.qameta.allure.Attachment;
import mainPackage.utils.WebDriverTestBase;
import mainPackage.utils.WebDriverTools;
import org.apache.commons.io.FileUtils;
import org.apache.http.util.Args;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static mainPackage.utils.WebDriverTools.driver;

public class TestListener implements ITestListener {

    WebDriverTools tools = new WebDriverTools();
    private String params;

    private File captureScreenshot(WebDriver driver) {
        File file = null;
        try {
            file = ((TakesScreenshot) WebDriverTools.driver).getScreenshotAs(OutputType.FILE);
            screenshotToAllure(file);
        }catch (WebDriverException e){
            e.printStackTrace();
        }
        return file;
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    private byte[] screenshotToAllure(File screen) {
        byte[] screenShot = new byte[0];
        try {
            screenShot = Files.readAllBytes(screen.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return screenShot;
    }


    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("============Test started============");

    }

    @Override
    public void onTestSuccess(ITestResult tr) {
        System.out.println("============Test passed successful============");
        String pathSucceed = "target/screenshots/"+params+"/success/" + tr.getMethod().getMethodName() + ".png";
        File screen = captureScreenshot(WebDriverTestBase.getDriver());
        try {
            FileUtils.copyFile(screen, new File(pathSucceed));}
        catch (IOException e) {e.printStackTrace();}
        System.out.println("Screenshot captured for test case:" + tr.getMethod().getMethodName());

    }

    @Override
    public void onTestFailure(ITestResult tr) {
        System.out.println("============Test failed============");
        String pathFailed = "target/screenshots/"+params+"/failed/" + tr.getMethod().getMethodName() + ".png";

        File screen = captureScreenshot(WebDriverTestBase.getDriver());
        try {
            FileUtils.copyFile(screen, new File(pathFailed));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Screenshot captured for test case:" + tr.getMethod().getMethodName());
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        System.out.println("======Test failed, but that the expected result=======");


    }

    @Override
    public void onStart(ITestContext iTestContext) {
        System.out.println("============Starting testing process============");

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

        System.out.println("==========Finishing testing process ============");

        if (driver != null) {
            driver.quit();
        }

    }


}
