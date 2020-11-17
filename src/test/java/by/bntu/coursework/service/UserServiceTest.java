package by.bntu.coursework.service;

import by.bntu.coursework.dao.impl.UserDaoImpl;
import by.bntu.coursework.entity.User;
import by.bntu.coursework.exception.DaoException;
import by.bntu.coursework.exception.ServiceException;
import by.bntu.coursework.service.impl.UserServiceImpl;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.reflect.Whitebox;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.*;

@PrepareForTest(UserDaoImpl.class)
public class UserServiceTest {
    private UserDaoImpl daoMock;
    private UserServiceImpl userService;

    private User userTest;

    @BeforeMethod
    public void setUp() {
        daoMock = mock(UserDaoImpl.class);
        userService = UserServiceImpl.getInstance();
        Whitebox.setInternalState(UserDaoImpl.class, "instance", daoMock);

        userTest = new User("login", "password", "name", "surname", "user");
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

    @Test
    public void checkPasswordShouldReturnNotNullUser() {
        try {
            String login = "login";
            String password = "password";
            when(daoMock.findByLoginAndPassword(any(String.class),any(String.class))).thenReturn(userTest);
            User correctUser = userService.checkPassword(login,password);
            assertEquals(correctUser,userTest);
        } catch (DaoException | ServiceException exp) {
            fail(exp.getMessage());
        }
    }

    @Test
    public void checkPasswordShouldReturnNullUser() {
        try {
            String login = "login";
            String password = "password";
            when(daoMock.findByLoginAndPassword(any(String.class),any(String.class))).thenReturn(null);
            User correctUser = userService.checkPassword(login,password);
            assertNull(correctUser);
        } catch (DaoException | ServiceException exp) {
            fail(exp.getMessage());
        }
    }

    @Test(expectedExceptions = ServiceException.class)
    public void checkPasswordShouldThrowException() throws DaoException, ServiceException {
            String login = "login";
            String password = "password";
            when(daoMock.findByLoginAndPassword(any(String.class),any(String.class))).thenThrow(DaoException.class);
            User correctUser = userService.checkPassword(login,password);
    }


    @Test
    public void VerifyPasswordsShouldReturnTrue() {
        String expected = "password";
        String actual = "password";
        boolean condition = userService.verifyPasswords(actual,expected);
        assertTrue(condition);
    }

    @Test
    public void VerifyPasswordsShouldReturnFalse() {
        String expected = "password";
        String actual = "password123";
        boolean condition = userService.verifyPasswords(actual,expected);
        assertFalse(condition);
    }

    @AfterClass
    public void tierDown() {
        userService = null;
        userTest = null;
        daoMock = null;
    }
}
