package mainPackage.utils;

import mainPackage.interfaceFolder.LogsVars;
import org.testng.annotations.DataProvider;

public class DataProviderParameters {

    @DataProvider(name = "email address")
    public Object[][] createEmail() {
        return new Object[][]{
                {"test@testcom", false},
                {"test@.com ", false},
                {"te st@gmail.com ", false},
                {"te@st@gmail.com", false},
                {"te..st@gmail.com", true},
                {"@gmail.com", false},
                {"имейлнарусском@gmail.com", false},
                {"admnAutoTest@email.ua", false},
                {"test@gmail.com.", false},
                {"  ", false},
                {"test@test.com", true},
        };
    }

    @DataProvider(name = "password")
    public Object[][] createPassw() {
        return new Object[][] {
                { " !@#$%^&*()_+=-|/\\'\"<>,.`~", false },
                { "парольнарусском", true},
                { "0123456789012345678901234", false },
                { "  ", false},
                { LogsVars.regularUserPassword, true},
        };
    }
    @DataProvider(name = "surName")
    public Object[][] surNameInputData() {
        return new Object[][]{
                {"123", false},
                {"+-*/|?.,@$#%^&()!~", false},
                {"Ив.ан", false},
                {"Иван123", false},
                {"      ", false},
                {"Мамренко", true},
        };
    }

    @DataProvider(name = "name")
    public Object[][] nameInputData() {
        return new Object[][]{
                {"123", false},
                {"+-*/|?.,@$#%^&()!~", false},
                {"Ив.ан", false},
                {"Иван123", false},
                {"      ", false},
                {"Стас", true},
        };
    }

    @DataProvider(name = "lastName")
    public Object[][] lastNameInputData() {
        return new Object[][]{
                {"123", false},
                {"+-*/|?.,@$#%^&()!~", false},
                {"Ив.ан", false},
                {"Иван123", false},
                {"      ", false},
                {"Иванович", true},
        };
    }

    @DataProvider(name = "changePassword")
    public Object[][] passInputData(){
        return new Object[][]{
                {"123456", "123456"},
                {"123456", "654321"},
                {"654321", "0987654321"},
                {"0987654321", "P@ssw0rd123"},
                {"P@ssw0rd123", "Good_password"},
                {"Good_password", "qweQWE123"},
                {"qweQWE123", "123456"},
                {"NotCorrectPass", "123456"},
                {"123456", "123456"},
        };
    }


    @DataProvider(name = "phoneNamber")
    public Object[][] phoneNamber(){
        return new Object[][]{
                {"+3809", false},
                {"+34536", true},
                {"0973519267", true},
                {"+7809as", false},
                {"+3809134324234234", true},
                {"+38091343242342343", false},
                {"+380913432424234!", false},
                {"+        ", false},
                {"+380973519267", true},
        };
    }
}

