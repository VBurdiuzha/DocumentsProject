package uiTest;

import mainPackage.ui.LoginPage;
import mainPackage.utils.WebDriverTestBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;


public class LogIn extends WebDriverTestBase {


    private LoginPage loginPage;

    @BeforeClass
    public void initPages() {
        loginPage = PageFactory.initElements(browser, LoginPage.class);
        System.out.println("Jira Pages Initialized");
    }

    @Test (description = "Invalid Login", priority = -1, groups = {"LogIn"})
    public void failureLogin() {

        loginPage.failureLogin();
    }

    @Test  (description = "Valid Login", groups = {"LogIn"})
    public void successfulLogin() {

        loginPage.successfulLogin();
    }
}
