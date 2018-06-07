package uiTest;

import mainPackage.Vars;
import mainPackage.ui.LoginPage;
import mainPackage.ui.ProfilePage;
import mainPackage.utils.DataProviderParameters;
import mainPackage.utils.WebDriverTestBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.management.relation.InvalidRelationTypeException;

public class Profile extends WebDriverTestBase{

    private LoginPage loginPage;
    private ProfilePage profilePage;

    @BeforeClass
    public void initPages() {
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        profilePage = PageFactory.initElements(driver, ProfilePage.class);
        System.out.println("Open brouser");
    }

    @Test (description = "Valid Login", groups = {"Profile"})
    public void successfulLogin() {
        loginPage.successfulLogin(Vars.personalUser, Vars.personalUserPassword);
    }

    @Test (description = "Go to menu", groups = ("Profile"))
    public void toProfile(){
        profilePage.toProfilePage();
        System.out.println("Profile page open");
    }

    @Test (description = "check different Surname", dataProviderClass = DataProviderParameters.class, dataProvider = "surName", groups = {"Profile"}, enabled = false)
    public void verifySurName(String surName, boolean n2) throws InterruptedException {
        profilePage.verifyEmail(surName ,n2);
    }

    @Test (description = "check different Name", dataProviderClass = DataProviderParameters.class, dataProvider = "name", groups = {"Profile"}, enabled = false)
    public void verifyName(String name, boolean n2) throws InterruptedException {
        profilePage.verifyName(name, n2);
    }

    @Test (description = "check different Lastname", dataProviderClass = DataProviderParameters.class, dataProvider = "lastName", groups = {"Profile"}, enabled = false)
    public void verifyLastName(String lastName, boolean n2) throws InterruptedException {
        profilePage.verifylastName(lastName, n2);
    }

    @Test (description = "check change password", dataProviderClass = DataProviderParameters.class, dataProvider = "changePassword", groups = {"Profile"}, enabled = false)
    public void verifyChangePassword(String oldPassword, String newPassword) throws InterruptedException {
        profilePage.verifyChangePassword(oldPassword, newPassword);
    }

    @Test(description = "change avatar", dataProviderClass = DataProviderParameters.class, dataProvider = "avatarFielsName" ,groups = {"Profile"}, priority = 1, enabled = false)
    public void changeAvatar(String avatarFielsName, boolean n2) throws InvalidRelationTypeException, InterruptedException {
        profilePage.uploadAvatar(avatarFielsName, n2);
    }

    @Test (description = "check additional email address", dataProviderClass = DataProviderParameters.class, dataProvider = "email address", groups = {"Profile"}, enabled = false)
    public void verifyEmail(String email, boolean n2){
        profilePage.verifyAdditionalEmail(email, n2);
    }

    @Test (description = "check phone number", dataProviderClass = DataProviderParameters.class, dataProvider = "phoneNamber", groups = {"Profile"}, enabled = false)
    public void verifyPhoneNamber(String phoneNamber, boolean n2){
        profilePage.verifyPhoneNamber(phoneNamber, n2);
    }

    @Test (description = "Switch profesion mode slader", groups = ("Profile"), priority = 1, enabled = false)
    public void checkProfesionMode(){
        profilePage.switchProfessionalModeSlider();
    }
}

