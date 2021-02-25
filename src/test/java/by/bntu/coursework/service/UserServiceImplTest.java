package by.bntu.coursework.service;

import by.bntu.coursework.dao.impl.UserDaoImpl;
import by.bntu.coursework.entity.User;
import by.bntu.coursework.exception.DaoException;
import by.bntu.coursework.exception.ServiceException;
import by.bntu.coursework.service.impl.UserServiceImpl;
import org.testng.annotations.*;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.reflect.Whitebox;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.*;

@PrepareForTest(UserDaoImpl.class)
public class UserServiceImplTest {
    private UserDaoImpl daoMock;
    private UserServiceImpl userService;

    private User userTest;

    @BeforeClass
    public void setUp() {
        daoMock = mock(UserDaoImpl.class);
        userService = UserServiceImpl.getInstance();
        Whitebox.setInternalState(UserDaoImpl.class, "instance", daoMock);

        userTest = new User("login", "password", "name", "surname", "user");
    }

    @DataProvider(name = "CorrectDataToCheckPassword")
    public Object[][] createCorrectDataToCheckPassword() {
        return new Object[][]{
                {"ivan", "12345"},
                {"alina", "kira123"},
                {"ego123", "chicago"},
                {"vitya666", "hello"}
        };
    }

    @DataProvider(name = "IncorrectDataToCheckPassword")
    public Object[][] createIncorrectDataToCheckPassword() {
        return new Object[][]{
                {"-ivan", "12345"},
                {"alina", "жора"},
                {"", "chicago"},
                {"Андрей", "hello"}
        };
    }

    @Test(dataProvider = "CorrectDataToCheckPassword")
    public void checkPasswordShouldReturnCorrectUser(String login, String password) {
        try {
            when(daoMock.findByLoginAndPassword(any(String.class), any(String.class))).thenReturn(userTest);
            User correctUser = userService.checkPassword(login, password);
            assertEquals(correctUser, userTest);
        } catch (DaoException | ServiceException exp) {
            fail(exp.getMessage());
        }
    }

    @Test(dataProvider = "IncorrectDataToCheckPassword", expectedExceptions = ServiceException.class)
    public void checkPasswordShouldThrowException(String login, String password) throws ServiceException, DaoException {
        when(daoMock.findByLoginAndPassword(any(String.class), any(String.class))).thenThrow(DaoException.class);
        User correctUser = userService.checkPassword(login, password);
    }


    @DataProvider(name = "CorrectDataToVerifyPasswords")
    public Object[][] createCorrectDataToVerifyPasswords() {
        return new Object[][]{
                {"1234", "1234"},
                {"chipolino", "chipolino"},
                {"mypassword", "mypassword"},
                {"hello", "hello"}
        };
    }

    @DataProvider(name = "IncorrectDataToVerifyPasswords")
    public Object[][] createIncorrectDataToVerifyPasswords() {
        return new Object[][]{
                {"1234", "12345"},
                {"chipolino", "chipolino@"},
                {"mypassword123", "mypassword"},
                {"helloWorld", "hello"}
        };
    }

    @Test(dataProvider = "CorrectDataToVerifyPasswords")
    public void verifyPasswordsShouldReturnTrue(String password, String confirmPassword) {
        boolean condition = userService.verifyPasswords(password, confirmPassword);
        assertTrue(condition);
    }

    @Test(dataProvider = "IncorrectDataToVerifyPasswords")
    public void verifyPasswordsShouldReturnFalse(String password, String confirmPassword) {
        boolean condition = userService.verifyPasswords(password, confirmPassword);
        assertFalse(condition);
    }


    @Test
    public void signUpUserShouldReturnTrue() {
        try {
            when(daoMock.add(any(User.class))).thenReturn(true);
            boolean condition = userService.signUpUser(userTest);
            assertTrue(condition);

        } catch (DaoException | ServiceException exp) {
            fail(exp.getMessage());
        }
    }

    @Test
    public void signUpUserShouldReturnFalse() {
        try {
            when(daoMock.add(any(User.class))).thenReturn(false);
            boolean condition = userService.signUpUser(userTest);
            assertFalse(condition);

        } catch (DaoException | ServiceException exp) {
            fail(exp.getMessage());
        }
    }

    @Test(expectedExceptions = ServiceException.class)
    public void signUpUserShouldThrowException() throws DaoException, ServiceException {
        when(daoMock.add(any(User.class))).thenThrow(DaoException.class);
        userService.signUpUser(userTest);
    }


    @AfterClass
    public void tierDown() {
        userService = null;
        userTest = null;
        daoMock = null;
    }
}