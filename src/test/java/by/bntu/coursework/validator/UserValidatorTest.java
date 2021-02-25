package by.bntu.coursework.validator;

import by.bntu.coursework.exception.DaoException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;


public class UserValidatorTest {
    @Test
    public void checkLoginInputShouldReturnTrue(){
        boolean condition = UserValidator.checkLoginInput("luki4");
        assertTrue(condition);
    }

    @Test
    public void checkLoginInputShouldReturnFalse(){
        boolean condition = UserValidator.checkLoginInput("luki4.");
        assertFalse(condition);
    }

    @Test
    public void checkPasswordInputShouldReturnTrue(){
        boolean condition = UserValidator.checkPasswordInput("12345");
        assertTrue(condition);
    }

    @Test
    public void checkPasswordInputShouldReturnFalse(){
        boolean condition = UserValidator.checkPasswordInput("12345@");
        assertFalse(condition);
    }

    @Test
    public void checkNameInputShouldReturnTrue(){
        boolean condition = UserValidator.checkNameInput("Ivan");
        assertTrue(condition);
    }

    @Test
    public void checkNameInputShouldReturnFalse(){
        boolean condition = UserValidator.checkNameInput("Ivan1");
        assertFalse(condition);
    }

    @Test
    public void checkSurnameInputShouldReturnTrue(){
        boolean condition = UserValidator.checkSurnameInput("Lukyanau");
        assertTrue(condition);
    }

    @Test
    public void checkSurnameInputShouldReturnFalse(){
        boolean condition = UserValidator.checkNameInput("Lukyanau123");
        assertFalse(condition);
    }

    @DataProvider(name = "CorrectDataToCheckSignUpParameters")
    public Object[][] createCorrectDataToCheckSignUpParameters(){
        return new Object[][]{
                {"Ivan","Lukyanau","luki44","12345"},
                {"Ivan","Yanushkevich","yanush","99999"},
                {"Alina","Kurpata","demotivetor","11111"}
        };
    }
    @DataProvider(name = "IncorrectDataToCheckSignUpParameters")
    public Object[][] createIncorrectDataToCheckSignUpParameters(){
        return new Object[][]{
                {"Ivan123","Lukyanau","luki44","12345"},
                {"999Ivan","Yanushkevich","yanush","99999"},
                {"000Alina","Kurpata","demotivetor","11111"}
        };
    }
    @Test(dataProvider = "CorrectDataToCheckSignUpParameters")
    public void checkSignUpParametersShouldReturnTrue(String name, String surname, String login, String password) throws DaoException {
        boolean condition = UserValidator.checkSingUpParameters(name, surname, login, password);
        assertTrue(condition);
    }

    @Test(dataProvider = "IncorrectDataToCheckSignUpParameters")
    public void checkSignUpParametersShouldReturnFalse(String name, String surname, String login, String password) throws DaoException {
        boolean condition = UserValidator.checkSingUpParameters(name, surname, login, password);
        assertFalse(condition);
    }
}
