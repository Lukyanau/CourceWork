package by.bntu.coursework.validator;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CarValidatorTest {

    @Test
    public void checkTitleInputShouldReturnTrue(){
        boolean condition = CarValidator.checkTitleInput("bmw i8");
        assertTrue(condition);
    }

    @Test
    public void checkTitleInputShouldReturnFalse(){
        boolean condition = CarValidator.checkTitleInput("bmw i+8");
        assertFalse(condition);
    }

    @Test
    public void checkDescriptionInputShouldReturnTrue(){
        boolean condition = CarValidator.checkDescriptionInput("This car is actually good in using.");
        assertTrue(condition);
    }

    @Test
    public void checkDescriptionInputShouldReturnFalse(){
        boolean condition = CarValidator.checkDescriptionInput("This car is @actually good in using.");
        assertFalse(condition);
    }

    @Test
    public void checkPriceInputShouldReturnTrue(){
        boolean condition = CarValidator.checkPriceInput("10000$");
        assertTrue(condition);
    }

    @Test
    public void checkPriceInputShouldReturnFalse(){
        boolean condition = CarValidator.checkDescriptionInput("1000$aaa");
        assertFalse(condition);
    }

    @Test
    public void checkColorInputShouldReturnTrue(){
        boolean condition = CarValidator.checkColorInput("Yellow");
        assertTrue(condition);
    }

    @Test
    public void checkColorInputShouldReturnFalse(){
        boolean condition = CarValidator.checkColorInput("123YellowBlackAndWhite");
        assertFalse(condition);
    }

    @Test
    public void checkMarkInputShouldReturnTrue(){
        boolean condition = CarValidator.checkMarkInput("mercedes");
        assertTrue(condition);
    }

    @Test
    public void checkMarkInputShouldReturnFalse(){
        boolean condition = CarValidator.checkMarkInput("1234mercedes");
        assertFalse(condition);
    }

    @Test
    public void checkAllParametersShouldReturnTrue(){
        boolean condition = CarValidator.checkAllParameters("bmw i8","This car is actually good in using.",
                "Yellow","bmw","100000$");
        assertTrue(condition);
    }

    @Test
    public void checkAllParametersShouldReturnFalse(){
        boolean condition = CarValidator.checkAllParameters("bmw i8","This car is actually good in using.",
                "12345Yellow","bmw","100000$");
        assertFalse(condition);
    }
}
