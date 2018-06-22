package uiTest;

import mainPackage.interfaceFolder.LogsVars;
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
         loginPage.successfulLogin(LogsVars.regularUser, LogsVars.regularUserPassword);
         docCategoryPage.correctDataWithLupa();
    }

     @Test(description = "correct Data Enter", groups = ("DocCategory"), priority = 2)
     public void correctDataWithEnterButton() {
         docCategoryPage.correctDataWithEnterButton();
     }

     @Test(description = "dropdawn List", groups = ("DocCategory"), priority = 3)
     public void dropdawnList()  {
         docCategoryPage.dropdawnList();
     }

     @Test(description = "data With One Leter", groups = ("DocCategory"), priority = 4)
     public void dataWithOneLetter() throws InterruptedException {
         docCategoryPage.dataWithOneLetter();
     }

     @Test(description = "data With Two Leter", groups = ("DocCategory"), priority = 5)
     public void dataWithTwoLetter() throws InterruptedException {
         docCategoryPage.dataWithTwoLetter();
     }

     @Test(description = "data With Many Letters", groups = ("DocCategory"), priority = 6)
     public void dataWithManyLetters() throws InterruptedException {
         docCategoryPage.dataWithManyLetters();
     }

     @Test(description = "data With Slash And Space", groups = ("DocCategory"), priority = 7)
     public void dataWithSlashAndSpace() throws InterruptedException {
         docCategoryPage.dataWithSlashAndSpace();
     }

     @Test(description = "delete data", groups = ("DocCategory"), priority = 8)
     public void deleteData() {
         docCategoryPage.deleteData();
     }

     @Test(description = "space data", groups = ("DocCategory"), priority = 9)
     public void spaceData()  {
         docCategoryPage.spaceData();
     }

     @Test(description = "subcategories", groups = ("DocCategory"), priority = 10)
     public void subcategories()  {
         docCategoryPage.subcategories();
     }

     @Test(description = "category With Out Sub Cat", groups = ("DocCategory"), priority = 11)
     public void categoryWithOutSubCat()  {
         docCategoryPage.categoryWithOutSubCat();
     }

}
