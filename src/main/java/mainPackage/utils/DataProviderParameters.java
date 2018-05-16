package mainPackage.utils;

import mainPackage.Vars;
import org.testng.annotations.DataProvider;

public class DataProviderParameters {

    @DataProvider(name = "email address")
    public Object[][] createEmail() {
        return new Object[][]{
                {"test@.com", true},
                {"te st@gmail.com", true},
                {"te@st@gmail.com", true},
                {"te..st@gmail.com", true},
                {"test@gmail.com.", true},
                {"@gmail.com", true},
                {"имейлнарусском@gmail.com", true},
                {"admnAutoTest@email.ua", true},
                {"  ", true}
        };
    }

    @DataProvider(name = "password")
    public Object[][] createPassw() {
        return new Object[][] {
                { " !@#$%^&*()_+=-|/\\'\"<>,.`~", true },
                { "парольнарусском", false},
                { "0123456789012345678901234", true },
                { "  ", true},
                { Vars.regularUser, true},
        };
    }
}

