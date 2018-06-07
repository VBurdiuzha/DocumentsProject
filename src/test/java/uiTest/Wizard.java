package uiTest;

import mainPackage.interfaceFolder.Vars;
import mainPackage.ui.DocCategory;
import mainPackage.ui.LoginPage;
import mainPackage.utils.WebDriverTestBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Wizard  extends WebDriverTestBase{

    private LoginPage loginPage;
    private DocCategory docCategory;

    @BeforeClass
    public void initPage(){
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        System.out.println("Open brouser");
    }
    @Test(description = "Valid Login", groups = {"Wizard"}, priority = 1)
    public void logIn(){
        loginPage.successfulLogin(Vars.personalUser, Vars.personalUserPassword);
    }

    @Test(description = "Go to document category", groups = ("Wizard"), priority = 2)
    public void toDocCategory() throws InterruptedException {
        docCategory = PageFactory.initElements(driver, DocCategory.class);
        docCategory.toDocCategoryPage();
    }
    @Test(description = "Create Simple Marker", groups = ("Wizard"), priority = 3)
    public void createSimpleMarkerDocument() throws InterruptedException {
        docCategory.toDocCategoryPage();
        docCategory.selectAUtomationFolder();
        docCategory.createSimpleMarker();
    }
    @Test(description = "Create Calculate Marker", groups = ("Wizard"), priority = 5)
    public void createCalculateDocument() throws InterruptedException {
        docCategory.toDocCategoryPage();
        docCategory.selectAUtomationFolder();
        docCategory.createCalculateDocument();
    }
    @Test(description = "Create Difficult Marker", groups = ("Wizard"), priority = 4)
    public void createDifficultMarker() throws InterruptedException {
        docCategory.toDocCategoryPage();
        docCategory.selectAUtomationFolder();
        docCategory.createDifficultMarker();
    }
}
