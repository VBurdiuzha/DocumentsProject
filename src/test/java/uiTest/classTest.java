package uiTest;

import mainPackage.ui.LoginPage;
import mainPackage.utils.WebDriverTestBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;


public class classTest extends WebDriverTestBase {


    private LoginPage loginPage;

    @BeforeClass
    public void initPages() {
        System.out.println("Jira Pages Initialized");
    }

    @Test(description = "Invalid Login", priority = -1)
    public void failureLogin() {

        loginPage.failureLogin();
    }

    @Test(description = "Valid Login")
    public void successfulLogin() {

        loginPage.successfulLogin();
    }
}
