package uiTest;

import mainPackage.listeners.TestListenerUI;
import mainPackage.ui.RegistrationPage;
import mainPackage.utils.DataProviderParameters;
import mainPackage.utils.WebDriverTestBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({TestListenerUI.class})
public class Registration extends WebDriverTestBase{
    private RegistrationPage registrationPage;
    private DataProviderParameters dataProviderParameters;

    @BeforeClass
    public void initPages() {
        registrationPage = PageFactory.initElements(driver, RegistrationPage.class);
        dataProviderParameters = PageFactory.initElements(driver, DataProviderParameters.class);
        System.out.println("Initialized");
    }

    @Test (description = "check different email cases", dataProviderClass = DataProviderParameters.class,
            dataProvider = "emailReg", priority = 1, groups = {"Reg.Email"})
    public void verifyEmail(String email, boolean n2){

        registrationPage.verifyEmail(email, n2);
    }


    @Test (description = "check different passw cases" ,dataProviderClass = DataProviderParameters.class,
            dataProvider = "passwReg", priority = 2, groups = {"Reg.Password"})
    public void verifyPassw(String password, boolean n2) throws InterruptedException {

        registrationPage.verifyPassw(password, n2);
    }
    @Test(description = "confirmEmail", priority = 3)
    public void enterEmail() throws InterruptedException {

        registrationPage.confirmAccountWithEmail();
    }

    @Test (description = "delete user from admin", priority = 4)
    public void deleteUser() throws InterruptedException {

        registrationPage.deleteUser();
    }


}
