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
                { Vars.regularUserPassword, true},
        };
    }
    @DataProvider(name = "surName")
    public Object[][] surNameInputData() {
        return new Object[][]{
                {"Qwe", true},
                {" !@#$%^&*()_+=-|/\\'\"<>,.`~", true},
                {"Иванов", false},
                {"01234567890", true},
                {"Иван.нов", true},
                {"Иванов123@@@1", true},
        };
    }

    @DataProvider(name = "name")
    public Object[][] nameInputData() {
        return new Object[][]{
                {"  1  ", true},
                {" !@#$%^&*()_+=-|/\\'\"<>,.`~", true},
                {"Иван", true},
                {"01234567890", true},
                {"Иван.нов", true},
                {"Иванов123", true},
        };
    }
    @DataProvider(name = "lastName")
    public Object[][] lastNameInputData() {
        return new Object[][]{
                {"    ", true},
                {" !@#$%^&*()_+=-|/\\'\"<>,.`~", true},
                {"Иванович", false},
                {"01234567890", true},
                {"Иван.нович", true},
                {"Иванов123ич", true},
        };
    }

    @DataProvider(name = "changePassword")
    public Object[][] passInputData(){
        return new Object[][]{
                {"123456", true},
                {"123456", true},
                {"123456", true},
                {"123456", true},
                {"123456", true},
                {"123456", true},
        };
    }
}

