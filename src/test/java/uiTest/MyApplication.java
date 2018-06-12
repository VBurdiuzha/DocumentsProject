package uiTest;

import mainPackage.ui.MyApplicationsPage;
import mainPackage.utils.WebDriverTestBase;
import mainPackage.utils.WebDriverTools;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;


public class MyApplication extends WebDriverTestBase {

    private MyApplicationsPage myApplicationsPage;
    @BeforeClass
    public void initPages() {
        myApplicationsPage = PageFactory.initElements(WebDriverTools.driver, MyApplicationsPage.class);
        System.out.println("My application page init");
    }


    @Test(description = "Go to my applications", groups = {"MyApp"}, priority = 1)
    public void expertiseModule() throws InterruptedException {

        myApplicationsPage.expertiseModule();

    }

    @Test(description = "Detail view application in the work", groups = {"Expertise"}, priority = 2)
    public void reviewAppInTheWork() throws InterruptedException {
        myApplicationsPage.reviewAppInTheWork();
    }

    @Test(description = "update App In TheWork", groups = {"Expertise"}, priority = 3)
    public void updateAppInTheWork() throws InterruptedException {
        myApplicationsPage.updateAppInTheWork();
    }

    @Test(description = "download Attachment", groups = {"Expertise"}, priority = 4)
    public void downloadAttachment() throws InterruptedException, IOException, NoSuchAlgorithmException {
        myApplicationsPage.downloadAttachment();
    }

    @Test(description = "download Attachment", groups = {"Expertise"}, priority = 5)
    public void downloadAttachmentPopUp() throws InterruptedException, IOException, NoSuchAlgorithmException {
        myApplicationsPage.downloadAttachmentPopUp();
    }

    @Test(description = "why rejected application ", groups = {"Expertise"}, priority = 6)
    public void whyRejectedApp() throws InterruptedException, IOException, NoSuchAlgorithmException {
        myApplicationsPage.whyRejectedApp();
    }



}
