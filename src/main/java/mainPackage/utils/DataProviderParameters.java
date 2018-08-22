package mainPackage.utils;

import mainPackage.interfaceFolder.LogsVars;
import org.testng.annotations.DataProvider;

public class DataProviderParameters {




    @DataProvider(name = "emailReg")
    public Object[][] emailreg() {
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
                {"v.burdiuzha@ossystem.com", true},
        };
    }


    @DataProvider(name = "passwReg")
    public Object[][] passwreg() {
        return new Object[][]{
                {"!@#$%^&*()_+=-<>,.`~", false},
                {"парольнарусском", false},
                {" 0123456789012345678901234", false},
                {LogsVars.correctPassword, true}
        };
    }

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
             //   {"  ", false},
                {"test@test.com", true},
        };
    }


    @DataProvider(name = "surName")
    public Object[][] surNameInputData() {
        return new Object[][]{
                {"123", false},
                {"+-*/|?.,@$#%^&()!~", false},
                {"Ив.ан", false},
                {"Иван123", false},
              //  {"      ", false},
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
             //   {"      ", false},
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
              //  {"      ", false},
                {"Иванович", true},
        };
    }

    @DataProvider(name = "newPassword")
    public Object[][] passInputData(){
        return new Object[][]{
                {LogsVars.badPassword, false},
                {"password123", false},
                {" 12345", false},
                {"!@#$%^&*()_+=-<>,.`~", false},
                {"парольнарусском", false},
                {"0123456789012345678901234", false},
             //   {"   ", false},
                {LogsVars.correctPassword, true}
        };
    }

    @DataProvider(name = "confirmPassword")
    public Object[][] confirmData(){
        return new Object[][]{
             //   {LogsVars.correctPassword, LogsVars.correctPassword},
                {"testtest", "test12345"},
             //   {"testtest", "    "},
                {"testtest", "testtest"}
        };
    }


    @DataProvider(name = "phoneNamber")
    public Object[][] phoneNamber(){
        return new Object[][]{
                {"буквы", false},
                {"+12345", false},
                {"+3806985741231", false},
                {"+!\"#;%:?*()_+/~`@", false},
                {"+38097.3519267", false},
             //   {"  ", false},
                {"+380973519267", true},
        };
    }
}

