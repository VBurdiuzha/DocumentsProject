package uiTest;

import mainPackage.interfaceFolder.Vars;
import mainPackage.ui.LoginPage;
import mainPackage.ui.ProfilePage;
import mainPackage.utils.DataProviderParameters;
import mainPackage.utils.WebDriverTestBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Profile extends WebDriverTestBase{

    private LoginPage loginPage;
    private ProfilePage profilePage;

    @BeforeClass
    public void initPages() {
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        System.out.println("Open brouser");
    }

    @Test (description = "Valid Login", groups = {"Profile"})
    public void successfulLogin() {

        loginPage.successfulLogin(Vars.personalUser, Vars.personalUserPassword);
    }

    @Test (description = "Go to menu", groups = ("Profile"))
    public void toProfile(){
        profilePage = PageFactory.initElements(driver, ProfilePage.class);
        profilePage.toProfilePage();
        System.out.println("Profile page open");
    }

    @Test (description = "check different surname", dataProviderClass = DataProviderParameters.class, dataProvider = "surName", groups = {"Profile"})
    public void verifySurName(String surName, boolean n2) throws InterruptedException {
        profilePage.verifyEmail(surName, n2);
    }

}

