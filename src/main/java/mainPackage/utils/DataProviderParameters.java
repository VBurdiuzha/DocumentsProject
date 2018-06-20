package mainPackage.utils;

import mainPackage.interfaceFolder.LogsVars;
import org.testng.annotations.DataProvider;

public class DataProviderParameters {

    @DataProvider(name = "email address")
    public Object[][] createEmail() {
        return new Object[][]{
                {"test@.com", false},
                {"te st@gmail.com", false},
                {"te@st@gmail.com", false},
                {"te..st@gmail.com", false},
                {"test@gmail.com.", true},
                {"@gmail.com", false},
                {"имейлнарусском@gmail.com", false},
                {"admnAutoTest@email.ua", true},
                {"  ", false},
                {"additionalmail@gmail.com", true},
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
                {"Qwe123", false},
                {"Петров", true},
                {"!@##$Иванов", false},
                {"Сидоров", true},
                {"123456", false},
                {"123123ИвановSSSS", false},
                {"      ", false},
                {"Пупкин", true},
        };
    }

    @DataProvider(name = "name")
    public Object[][] nameInputData() {
        return new Object[][]{
                {"Qwe123", false},
                {"Петров", true},
                {"Иванов", true},
                {"Сидоров!@@#$%", false},
                {"1234567", false},
                {"      ", false},
                {"Пупка", true},
        };
    }
    @DataProvider(name = "lastName")
    public Object[][] lastNameInputData() {
        return new Object[][]{
                {"Qwe", true},
                {"Петров123", false},
                {"123Иванов", false},
                {"Сидоров!@#$%$%^^", false},
                {"      ", false},
                {"ИвановSSSS", true},
                {"Пупкович", true},
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

    @DataProvider(name = "avatarFielsName")
    public Object[][] avatarFielsName(){
        return new Object[][]{
                {"Avatar.bmp", false},
                {"Avatar.webp", false},
                {"Avatar.tiff", false},
                {"Avatar.gif", false},
                {"Avatar.jpg", true},
                {"Avatar.png", true},
                {"Avatar.jpe", true},
                {"Avatar.jpeg", true},
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

