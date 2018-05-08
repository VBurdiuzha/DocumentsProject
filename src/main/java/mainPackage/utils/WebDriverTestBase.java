package mainPackage.utils;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class WebDriverTestBase {
    protected static WebDriver browser;

    {
        System.setProperty("webdriver.chrome.driver","/Users/villiburduza/IdeaProjects/ServiceDoc/qa/src/main/resources/selenium/mac/chromedriver");
    }

    @BeforeTest
    public static void setUp() {
        browser = new ChromeDriver(new ChromeOptions().addArguments("--start-maximized", "--incognito"));
        browser.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

        WebDriverTools.setDriver(browser);
    }

    @AfterTest
    public static void finish() {

        browser.close();
    }
}