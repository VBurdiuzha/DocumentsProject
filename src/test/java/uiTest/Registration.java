package uiTest;

import mainPackage.Vars;
import mainPackage.ui.RegistrationPage;
import mainPackage.utils.DataProviderParameters;
import mainPackage.utils.WebDriverTestBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class Registration extends WebDriverTestBase{
    private RegistrationPage registrationPage;
    private DataProviderParameters dataProviderParameters;

    @BeforeClass
    public void initPages() {
        registrationPage = PageFactory.initElements(browser, RegistrationPage.class);
        dataProviderParameters = PageFactory.initElements(browser, DataProviderParameters.class);
        System.out.println("Initialized");
    }

    @Test (description = "check different email cases", dataProviderClass = DataProviderParameters.class, dataProvider = "email address", groups = {"Reg.Email"})
    public void verifyEmail(String email, boolean n2){

        registrationPage.verifyEmail(email, n2);
    }


    @Test (description = "check different passw cases" ,dataProviderClass = DataProviderParameters.class, dataProvider = "password", groups = {"Reg.Password"})
    public void verifyPassw(String password, boolean n2){

        registrationPage.verifyPassw(password, n2);
    }
    @Test
    public void enterEmail(){
        registrationPage.enterEmail();
    }

}
