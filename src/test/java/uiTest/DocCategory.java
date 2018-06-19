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


     @Test(description = "correct Data Lupa", groups = ("DocCategory"), priority = 1)
    public void correctDataWithLupa()  {
         loginPage.successfulLogin(Vars.regularUser, Vars.regularUserPassword);
         docCategoryPage.correctDataWithLupa();
    }

     @Test(description = "correct Data Enter", groups = ("DocCategory"), priority = 2)
     public void correctDataWithEnterButton() throws InterruptedException {
         docCategoryPage.correctDataWithEnterButton();
     }

     @Test(description = "dropdawn List", groups = ("DocCategory"), priority = 3)
     public void dropdawnList()  {
         docCategoryPage.dropdawnList();
     }
}
