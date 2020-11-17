package by.bntu.coursework.validator;

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

    @Test
    public void checkSignUpParametersShouldReturnTrue(){
        boolean condition = UserValidator.checkSingUpParameters("Ivan","Lukyanau","luki4","12345");
        assertTrue(condition);
    }

    @Test
    public void checkSignUpParametersShouldReturnFalse(){
        boolean condition = UserValidator.checkSingUpParameters("Ivan123","Lukyanau321","luki4","12345");
        assertFalse(condition);
    }
}
