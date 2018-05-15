package uiTest;

import mainPackage.Vars;
import mainPackage.ui.RegistrationPage;
import mainPackage.utils.WebDriverTestBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class Registration extends WebDriverTestBase{
    private RegistrationPage registrationPage;

    @BeforeClass
    public void initPages() {
        registrationPage = PageFactory.initElements(browser, RegistrationPage.class);
        System.out.println("Initialized");
    }


    @DataProvider(name = "provider1")
    public Object[][] createEmail() {
        return new Object[][]{
                {"test@.com", true},
                {"te st@gmail.com", true},
                {"te@st@gmail.com", true},
                {"te..st@gmail.com", true},
                {"test@gmail.com.", true},
                {"@gmail.com", true},
                {"имейлнарусском@gmail.com", true},
                {"admnAutoTest@email.ua", true},
                {"  ", true}
        };
    }
    @Test (description = "check different email cases",  dataProvider = "provider1", groups = {"Reg.Email"})
    public void verifyEmail(String n1, boolean n2){

        registrationPage.verifyEmail(n1, n2);
    }

    @DataProvider(name = "provider2")
    public Object[][] createPassw() {
        return new Object[][] {
                { " !@#$%^&*()_+=-|/\\'\"<>,.`~", true },
                { "парольнарусском", false},
                { "0123456789012345678901234", true },
                { "  ", true},
                { Vars.regularUser, true},
        };
    }

    @Test (description = "check different passw cases",dataProvider = "provider2", groups = {"Reg.Password"})
    public void verifyPassw(String n1, boolean n2){

        registrationPage.verifyPassw(n1, n2);
    }
    @Test
    public void enterEmail(){
        registrationPage.enterEmail();
    }

}
