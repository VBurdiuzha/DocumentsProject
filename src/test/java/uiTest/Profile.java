package uiTest;

import mainPackage.Vars;
import mainPackage.ui.LoginPage;
import mainPackage.ui.ProfilePage;
import mainPackage.utils.WebDriverTestBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Profile extends WebDriverTestBase{

    private LoginPage loginPage;
    private ProfilePage profileMenu;

    @BeforeClass
    public void initPages() {
        loginPage = PageFactory.initElements(browser, LoginPage.class);
        System.out.println("Open brouser");
    }

    @Test (description = "Valid Login", groups = {"Profile"})
    public void successfulLogin() {

        loginPage.successfulLogin(Vars.adminUser, Vars.adminUserPassword);
    }

    @Test (description = "Go to menu", groups = ("Profile"))
    public void toProfile(){
        profileMenu = PageFactory.initElements(browser, ProfilePage.class);
        profileMenu.goToProfile();
        System.out.println("Open menu");
        profileMenu.toProfilePage();
        System.out.println("Profile page open");
    }

//    @Test(description = "Upload foto for avatar", groups = ("Profile"))
//    public void uploadFoto(){
//        profileMenu.openUploadFotoWindow();
//    }

}

