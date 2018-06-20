package uiTest;

import mainPackage.interfaceFolder.LogsVars;
import mainPackage.listeners.TestListenerUI;
import mainPackage.ui.LoginPage;
import mainPackage.ui.ProfilePage;
import mainPackage.utils.DataProviderParameters;
import mainPackage.utils.WebDriverTestBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners({TestListenerUI.class})
public class Profile extends WebDriverTestBase{

    private LoginPage loginPage;
    private ProfilePage profilePage;

    @BeforeClass
    public void initPages() {
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        profilePage = PageFactory.initElements(driver, ProfilePage.class);
        System.out.println("Open brouser");
    }

    @Test (description = "Valid Login", groups = {"Profile"}, priority = 1)
    public void successfulLogin() {
        loginPage.successfulLogin(LogsVars.personalUser, LogsVars.personalUserPassword);
    }

    @Test (description = "Go to menu", groups = ("Profile"), priority = 2)
    public void toProfile(){
        profilePage.toProfilePage();
        System.out.println("Profile page open");
    }

    @Test (description = "check different Surname", dataProviderClass = DataProviderParameters.class,
            dataProvider = "surName", groups = {"Profile"}, priority = 3)
    public void verifySurName(String surName, boolean n2) throws InterruptedException {
        profilePage.verifyEmail(surName ,n2);
    }

    @Test (description = "check different Name", dataProviderClass = DataProviderParameters.class,
            dataProvider = "name", groups = {"Profile"}, priority = 4)
    public void verifyName(String name, boolean n2) throws InterruptedException {
        profilePage.verifyName(name, n2);
    }

    @Test (description = "check different Lastname", dataProviderClass = DataProviderParameters.class,
            dataProvider = "lastName", groups = {"Profile"}, priority = 5)
    public void verifyLastName(String lastName, boolean n2) throws InterruptedException {
        profilePage.verifylastName(lastName, n2);
    }

    @Test (description = "check change password", dataProviderClass = DataProviderParameters.class,
            dataProvider = "changePassword", groups = {"Profile"}, priority = 6)
    public void verifyChangePassword(String oldPassword, String newPassword) throws InterruptedException {
        profilePage.verifyChangePassword(oldPassword, newPassword);
    }

    @Test(description = "change avatar", dataProviderClass = DataProviderParameters.class,
            dataProvider = "avatarFielsName" ,groups = {"Profile"}, priority = 7)
    public void changeAvatar(String avatarFielsName, boolean n2) throws  InterruptedException {
        profilePage.uploadAvatar(avatarFielsName, n2);
    }

    @Test (description = "check additional email address", dataProviderClass = DataProviderParameters.class,
            dataProvider = "email address", groups = {"Profile"}, priority = 8)
    public void verifyEmail(String email, boolean n2){
        profilePage.verifyAdditionalEmail(email, n2);
    }

    @Test (description = "check phone number", dataProviderClass = DataProviderParameters.class,
            dataProvider = "phoneNamber", groups = {"Profile"}, priority = 9)
    public void verifyPhoneNamber(String phoneNamber, boolean n2){
        profilePage.verifyPhoneNamber(phoneNamber, n2);
    }

    @Test (description = "Switch profesion mode slader", groups = ("Profile"), priority = 10)
    public void checkProfesionMode(){
        profilePage.switchProfessionalModeSlider();
    }
}

