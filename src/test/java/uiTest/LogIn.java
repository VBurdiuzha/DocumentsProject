package uiTest;

import mainPackage.interfaceFolder.LogsVars;
import mainPackage.listeners.TestListenerUI;
import mainPackage.ui.LoginPage;
import mainPackage.utils.WebDriverTestBase;
import mainPackage.utils.WebDriverTools;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

@Listeners({TestListenerUI.class})
public class LogIn extends WebDriverTestBase {   // наследование

// полиморфизм
    private LoginPage loginPage; // Ссылка на LoginPage (интерфейс)


    @BeforeClass
    public void initPages() {
        loginPage = PageFactory.initElements(WebDriverTools.driver, LoginPage.class);
        System.out.println("Login page init");
    }

    // используем методы LoginPage, кладем туда данные не влияя на этот метод
    // в рамках другого класса (абстрогирование данных)

    @Test (description = "Invalid Login", priority = -1, groups = {"LogIn"})
    public void failureLogin() {

        loginPage.failureLogin(LogsVars.regularUser, LogsVars.badPassword);
    }

    @Test  (description = "Valid Login", priority = 1, groups = {"LogIn"})
    public void successfulLogin() {

        loginPage.successfulLogin(LogsVars.regularUser, LogsVars.regularUserPassword);
    }
}
