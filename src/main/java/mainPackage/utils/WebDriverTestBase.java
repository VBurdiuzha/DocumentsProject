package mainPackage.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class WebDriverTestBase {
    protected static WebDriver driver;

    {
        System.setProperty("webdriver.chrome.driver", "/var/www/tests/src/main/resources/selenium/linux/chromedriver");
    }

 //   @Parameters ("platform")
    @BeforeTest
    public static void setUp(/*String platform*/) {
//        if ("mac".equals(platform)) {
//            System.setProperty("webdriver.chrome.driver", "/Users/villiburduza/IdeaProjects/ServiceDoc/qa/src/main/resources/selenium/mac/chromedriver");
//            System.out.println("Test running on mac os");
//
//    } else if ("linux".equals(platform)) {
//            System.setProperty("webdriver.chrome.driver", "/var/www/tests/src/main/resources/selenium/linux/chromedriver");
//            System.out.println("Test running on linux os");
//
//        } else if ("windows".equals(platform)) {
//            System.setProperty("webdriver.chrome.driver", "/Users/villiburduza/IdeaProjects/ServiceDoc/qa/src/main/resources/selenium/windows/chromedriver.exe");
//            System.out.println("Test running on windows");
//
//        } else {
//            System.out.println("Something wrong ! :(");
//        }



            driver = new ChromeDriver(new ChromeOptions().addArguments("--start-maximized", "--incognito"));
            driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            mainPackage.utils.WebDriverTools.setDriver(driver);

    }


    @AfterTest
    public static void finish() {

        driver.close();
    }

    public static WebDriver getDriver() {
        return driver;
    }


}