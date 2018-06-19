package uiTest;

import mainPackage.interfaceFolder.Vars;
import mainPackage.listeners.TestListenerUI;
import mainPackage.ui.DocCategoryPage;
import mainPackage.ui.LoginPage;
import mainPackage.utils.WebDriverTestBase;
import mainPackage.utils.WebDriverTools;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


 @Listeners({TestListenerUI.class})

public class DocCategory extends WebDriverTestBase {
     private LoginPage loginPage;
     private DocCategoryPage docCategoryPage;

    @BeforeClass
    public void initPages() {
        docCategoryPage = PageFactory.initElements(WebDriverTools.driver, DocCategoryPage.class);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        System.out.println("Doc Category page init");
    }


     @Test(description = "correct Data", groups = ("DocCategory"), priority = 1)
    public void toDocCategory()  {
         loginPage.successfulLogin(Vars.regularUser, Vars.regularUserPassword);
         docCategoryPage.correctData();
    }


}
