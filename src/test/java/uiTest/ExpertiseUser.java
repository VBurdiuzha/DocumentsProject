package uiTest;

import mainPackage.listeners.TestListenerUI;
import mainPackage.ui.ExpertiseUserPage;
import mainPackage.utils.WebDriverTestBase;
import mainPackage.utils.WebDriverTools;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({TestListenerUI.class})

public class ExpertiseUser extends WebDriverTestBase {
    private ExpertiseUserPage expertiseUserPage;

    @BeforeClass
    public void initPages() {
        expertiseUserPage = PageFactory.initElements(WebDriverTools.driver, ExpertiseUserPage.class);
        System.out.println("Expertise user page init");
    }

    @Test(description = "Go to the Expertise module", groups = {"disabled"}, priority = 1)
    public void login() {

        expertiseUserPage.logIn();

    }
    @Test (description = "test case with valid data", priority = 2)
    public void validData()  {

        expertiseUserPage.validData();
    }

    @Test(description =  "test case with double attachment", groups = {"Expertise"}, priority = 3)
    public void doubleAttachment(){
        expertiseUserPage.doubleAttachment();
    }

    @Test(description =  "test case with empty first field", groups = {"Expertise"}, priority = 4)
    public void emptyTypeField(){
        expertiseUserPage.emptyTypeField();
    }

    @Test(description =  "test case with empty second field", groups = {"Expertise"}, priority = 5)
    public void emptyWhoYouAreField(){
        expertiseUserPage.emptyWhoYouAreField();
    }

    @Test(description =  "test case with incorrect second field", groups = {"Expertise"}, priority = 6)
    public void incorrectSecondField(){
        expertiseUserPage.incorrectSecondField();
    }

    @Test(description =  "test case with requisites field", groups = {"Expertise"}, priority = 7)
    public void requisitesField(){
        expertiseUserPage.requisitesField();
    }

    @Test(description =  "test case with empty requisite field", groups = {"Expertise"}, priority = 8)
    public void emptyRequisiteField(){
        expertiseUserPage.emptyRequisiteField();
    }

    @Test(description =  "test case with empty attachment field", groups = {"Expertise"}, priority = 9)
    public void emptyAttachmentField(){
        expertiseUserPage.emptyAttachmentField();
    }

    @Test(description =  "test case with 21 attachments", groups = {"Expertise"}, priority = 10)
    public void attachment21() throws InterruptedException {
        expertiseUserPage.attachment21();}

    @Test(description =  "test case with file more than 50 MB", groups = {"Expertise"}, priority = 11)
    public void fileMoreThen50MB() throws InterruptedException {
        expertiseUserPage.fileMoreThen50MB();
    }

    @Test(description =  "test case with delete One Of Uploaded Files", groups = {"Expertise"}, priority = 12)
    public void deleteOneOfUploudedFiles() throws InterruptedException {
        expertiseUserPage.deleteOneOfUploadedFiles();
    }

    @Test(description =  "test case with reestablish Uploaded Files", groups = {"Expertise"}, priority = 13)
    public void reestablishUploadedFiles() throws InterruptedException {
        expertiseUserPage.reestablishUploadedFiles();
    }

    @Test(description =  "test case have not money", groups = {"Expertise"}, priority = 15)
    public void haveNotMoney() throws InterruptedException {
        expertiseUserPage.haveNotMoney();
    }

    @Test(description =  "test case with empty all fields", groups = {"Expertise"}, priority = 16)
    public void emptyAllField() throws InterruptedException {
        expertiseUserPage.emptyAllField();
    }

    @Test(description =  "test case with incorrect Format File", groups = {"Expertise"}, priority = 17)
    public void incorrectFormatFile() throws InterruptedException {
        expertiseUserPage.incorrectFormatFile();
    }

}
