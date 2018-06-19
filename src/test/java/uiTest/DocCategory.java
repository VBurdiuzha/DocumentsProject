package uiTest;

import mainPackage.listeners.TestListenerUI;
import mainPackage.ui.DocCategoryPage;
import mainPackage.utils.WebDriverTestBase;
import mainPackage.utils.WebDriverTools;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


 @Listeners({TestListenerUI.class})

public class DocCategory extends WebDriverTestBase {

    private DocCategoryPage docCategoryPage;

    @BeforeClass
    public void initPages() {
        docCategoryPage = PageFactory.initElements(WebDriverTools.driver, DocCategoryPage.class);
        System.out.println("Doc Category page init");
    }


    @Test(description = "correct Data", groups = ("DocCategory"), priority = 2)
    public void toDocCategory()  {
        docCategoryPage.correctData();
    }


}
