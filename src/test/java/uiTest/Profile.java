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

    @Test (description = "Valid Login", groups = {"disabled"}, priority = 1)
    public void successfulLogin() {

        loginPage.successfulLogin(LogsVars.personalUser, LogsVars.personalUserPassword);
    }

    @Test (description = "to Profile", groups = ("Profile"), priority = 2)
    public void toProfile(){
        profilePage.toProfilePage();
        System.out.println("Profile page open");
    }

    @Test (description = "upload Avatar GIF", groups = ("Profile"), priority = 3)
    public void uploadAvatarGIF() {
        profilePage.uploadAvatarGIF();
    }

    @Test (description = "upload Avatar BMP", groups = ("Profile"), priority = 4)
    public void uploadAvatarBMP() {
        profilePage.uploadAvatarBMP();
    }

    @Test (description = "upload Avatar WEBP", groups = ("Profile"), priority = 5)
    public void uploadAvatarWEBP() {
        profilePage.uploadAvatarWEBP();
    }

    @Test (description = "upload Avatar TIFF", groups = ("Profile"), priority = 6)
    public void uploadAvatarTIFF() {
        profilePage.uploadAvatarTIFF();
    }

    @Test (description = "upload Avatar SVG", enabled = false, groups = ("Profile"), priority = 7)
    public void uploadAvatarSVG() {
        profilePage.uploadAvatarSVG();
    }

    @Test (description = "upload Avatar 2MB",enabled = false, groups = ("Profile"), priority = 9)
    public void uploadAvatar2MB() {
        profilePage.uploadAvatar2MB();
    }

    @Test (description = "upload Avatar PNG",groups = ("Profile"), priority = 10)
    public void uploadAvatarPNG() {
        profilePage.uploadAvatarPNG();
    }

    @Test (description = "upload Avatar JPG",groups = ("Profile"), priority = 11)
    public void uploadAvatarJPG() {
        profilePage.uploadAvatarJPG();
    }

    @Test (description = "delete ava",groups = ("Profile"), priority = 12)
    public void deleteAva() {
        profilePage.deleteAva();
    }

    @Test (description = "dimensions Ava",groups = ("Profile"), priority = 13)
    public void dimensionsAva() {
        profilePage.dimensionsAva();
    }

    @Test (description = "edit Uploaded Photo",groups = ("Profile"), priority = 14)
    public void editUploadedPhoto() {
        profilePage.editUploadedPhoto();
    }

    @Test (description = "check different Name", dataProviderClass = DataProviderParameters.class,
            dataProvider = "name", groups = {"Profile"}, priority = 15)
    public void verifyName(String name, boolean n2)  {
        profilePage.verifyName(name, n2);
    }

    @Test (description = "check different Surname", dataProviderClass = DataProviderParameters.class,
            dataProvider = "surName", groups = {"Profile"}, priority = 16)
    public void verifySurName(String surName, boolean n2)  {
        profilePage.verifysurname(surName ,n2);
    }

    @Test (description = "check different Lastname", dataProviderClass = DataProviderParameters.class,
            dataProvider = "lastName", groups = {"Profile"}, priority = 17)
    public void verifylastName(String lastName, boolean n2)  {
        profilePage.verifylastName(lastName, n2);
    }

    @Test (description = "review Hint Message",groups = ("Profile"), priority = 18)
    public void reviewHintMessage() {
        profilePage.reviewHintMessage();
    }

    @Test (description = "check additional email address", dataProviderClass = DataProviderParameters.class,
            dataProvider = "email address",enabled = false,groups = {"Profile"}, priority = 19)
    public void verifyEmail(String email, boolean n2) {
        profilePage.verifyAdditionalEmail(email, n2);
    }

    @Test (description = "check phone number", dataProviderClass = DataProviderParameters.class,
            dataProvider = "phoneNamber",enabled = false, groups = {"Profile"}, priority = 20)
    public void verifyPhoneNamber(String phoneNamber, boolean n2){
        profilePage.verifyPhoneNamber(phoneNamber, n2);
    }

    @Test (description = "verify Change Password", dataProviderClass = DataProviderParameters.class,
            dataProvider = "newPassword", groups = ("Profile"), priority = 21)
    public void verifyChangePassword(String newPassword, boolean n2)  {

        profilePage.verifyChangePassword(newPassword, n2);
    }

    @Test (description = "verify Confirm Password", dataProviderClass = DataProviderParameters.class,
            dataProvider = "confirmPassword", groups = ("Profile"), priority = 22)
    public void verifyConfirmPassword(String changePassword, String changePassword2) throws InterruptedException {

        profilePage.verifyConfirmPassword(changePassword,changePassword2);
    }

    @Test (description = "change Password", groups = ("Profile"), priority = 23)
    public void changePassword() {
        profilePage.changePassword();
    }
}

