package uiTest;

import mainPackage.Vars;
import mainPackage.ui.ExpertiseUserPage;
import mainPackage.ui.LoginPage;
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
    @Test (description = "delete user from admin", priority = 2)
    public void createDoc() throws InterruptedException {

        expertiseUserPage.validData();
    }
}
