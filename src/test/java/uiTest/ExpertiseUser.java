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
}
