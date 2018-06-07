package uiTest;

import mainPackage.interfaceFolder.Vars;
import mainPackage.ui.LoginPage;
import mainPackage.utils.WebDriverTestBase;
import mainPackage.utils.WebDriverTools;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;


public class LogIn extends WebDriverTestBase {


    private LoginPage loginPage;

    @BeforeClass
    public void initPages() {
        loginPage = PageFactory.initElements(WebDriverTools.driver, LoginPage.class);
        System.out.println("Login page init");
    }

    @Test (description = "Invalid Login", priority = -1, groups = {"LogIn"})
    public void failureLogin() {

        loginPage.failureLogin(Vars.regularUser, Vars.badPassword);
    }

    @Test  (description = "Valid Login", priority = 1, groups = {"LogIn"})
    public void successfulLogin() {

        loginPage.successfulLogin(Vars.regularUser, Vars.regularUserPassword);
    }
}
