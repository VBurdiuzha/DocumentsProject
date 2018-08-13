package uiTest;

import mainPackage.listeners.TestListenerUI;
import mainPackage.ui.MyApplicationsPage;
import mainPackage.utils.WebDriverTestBase;
import mainPackage.utils.WebDriverTools;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

@Listeners({TestListenerUI.class})
public class MyApplication extends WebDriverTestBase {

    private MyApplicationsPage myApplicationsPage;
    @BeforeClass
    public void initPages() {
        myApplicationsPage = PageFactory.initElements(WebDriverTools.driver, MyApplicationsPage.class);
        System.out.println("My application page init");
    }


    @Test(description = "Go to my applications", groups = {"disabled"}, priority = -1)
    public void login() {

        myApplicationsPage.logIn();

    }

    @Test(description = "Detail view application in the work", groups = {"Expertise"}, priority = 1)
    public void reviewAppInTheWork() throws InterruptedException {
        myApplicationsPage.reviewAppInTheWork();
    }

    @Test(description = "update App Wait For Pay", groups = {"Expertise"}, priority = 2)
    public void updateAppWaitForPay() throws InterruptedException {
        myApplicationsPage.updateAppWaitForPay();
    }

    @Test(description = "download Attachment from preview in work Doc", groups = {"Expertise"}, priority = 3)
    public void downloadAttachment() throws InterruptedException, IOException, NoSuchAlgorithmException {
        myApplicationsPage.downloadAttachment();
    }

    @Test(description = "download Attachment when edit app", groups = {"Expertise"}, priority = 4)
    public void downloadAttachmentPopUp() throws IOException, NoSuchAlgorithmException {
        myApplicationsPage.downloadAttachmentPopUp();
    }

//    @Test(description = "why rejected application ", groups = {"Expertise"}, priority = 5)
//    public void whyRejectedApp() {
//        myApplicationsPage.logIn();
//        myApplicationsPage.whyRejectedApp();
//    }

    @Test(description = "rejected App To Archive", groups = {"Expertise"}, priority = 6)
    public void rejectedAppToArchive() throws InterruptedException {
        myApplicationsPage.rejectedAppToArchive();
    }


    @Test(description = "edit App Wait for Pay", groups = {"Expertise"}, priority = 7)
    public void editAppWaitForPay() throws InterruptedException {
        myApplicationsPage.editAppWaitForPay();
    }

    @Test(description = "download Attach When Edit App", groups = {"Expertise"}, priority = 8)
    public void downloadAttachWhenEditApp() throws IOException, NoSuchAlgorithmException {
        myApplicationsPage.downloadAttachWhenEditApp();
    }

    @Test(description = "delete All Attach When Edit", groups = {"Expertise"}, priority = 9)
    public void deleteAllAttachWhenEdit() throws InterruptedException {
        myApplicationsPage.deleteAllAttachWhenEdit();
    }

    @Test(description = "delete All Attach When Edit", groups = {"Expertise"}, priority = 10)
    public void cancelChangesEditApp() {
        myApplicationsPage.cancelChangesEditApp();
    }

    @Test(description = "success Payment When Wait For Pay Doc", groups = {"Expertise"}, priority = 11)
    public void successPaymentWhenWaitForPayDoc() throws InterruptedException {
        myApplicationsPage.successPaymentWhenWaitForPayDoc();
    }

    @Test(description = "have Not Money When Wait For Pay Doc", groups = {"Expertise"}, priority = 12)
    public void haveNotMoneyWhenWaitForPayDoc()  {
        myApplicationsPage.haveNotMoneyWhenWaitForPayDoc();
    }

    @Test(description = "send To Archiv When Wait For Pay", groups = {"Expertise"}, priority = 13)
    public void sendToArchivWhenWaitForPay() throws InterruptedException {
        myApplicationsPage.sendToArchivWhenWaitForPay();
    }

    @Test(description = "send To Archiv When Wait For Pay", groups = {"Expertise"}, priority = 14)
    public void answerForOperatorWhenWaitForPayDoc() throws Exception {
        myApplicationsPage.answerForOperatorWhenWaitForPayDoc();
    }


}
