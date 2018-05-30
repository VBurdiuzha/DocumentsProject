package uiTest;

import mainPackage.ui.ExpertiseUserPage;
import mainPackage.utils.WebDriverTestBase;
import mainPackage.utils.WebDriverTools;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class ExpertiseUser extends WebDriverTestBase {
    private ExpertiseUserPage expertiseUserPage;

    @BeforeClass
    public void initPages() {
        expertiseUserPage = PageFactory.initElements(WebDriverTools.driver, ExpertiseUserPage.class);
        System.out.println("Expertise user page init");
    }

    @Test(description = "Go to the Expertise module", groups = {"Expertise"}, priority = 1)
    public void expertiseModule() throws InterruptedException {

        expertiseUserPage.expertiseModule();

    }
    @Test (description = "test case with valid data", priority = 2)
    public void validData() throws InterruptedException {

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

    @Test(description =  "test case with empty second field", groups = {"Expertise"}, priority = 6)
    public void incorrectSecondField(){
        expertiseUserPage.incorrectSecondField();
    }

    @Test(description =  "test case with empty third field", groups = {"Expertise"}, priority = 7)
    public void requisitesField(){
        expertiseUserPage.requisitesField();
    }

    @Test(description =  "test case with empty third text area", groups = {"Expertise"}, priority = 8)
    public void emptyRequisiteField(){
        expertiseUserPage.emptyRequisiteField();
    }

    @Test(description =  "test case with empty third text area", groups = {"Expertise"}, priority = 9)
    public void emptyAttachmentField(){
        expertiseUserPage.emptyAttachmentField();
    }

    @Test(description =  "test case with empty third text area", groups = {"Expertise"}, priority = 10)
    public void attachment21() throws InterruptedException {
        expertiseUserPage.attachment21();
    }

}
