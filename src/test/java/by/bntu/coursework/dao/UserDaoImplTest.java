package by.bntu.coursework.dao;

import by.bntu.coursework.dao.impl.UserDaoImpl;
import by.bntu.coursework.entity.User;
import by.bntu.coursework.exception.DaoException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class UserDaoImplTest {
    UserDaoImpl userDao;
    User userTestForDaoInsert;
    User userTest1;
    User userTest2;
    User userTest3;


    @BeforeClass
    public void beforeClass() {
        userDao = UserDaoImpl.getInstance();
        userTestForDaoInsert = new User("dog", "999", "Fill", "Chip", 0, "user");
        userTest1 = new User(25, "doggy", "999", "Fill", "Chip", 0, "user");
        userTest3 = new User(25, "doggy", "999", "Fill", "Chip", 0);
    }

    @Test
    public void addWithDaoShouldReturnTrue() {
        try {
            boolean condition = userDao.add(userTestForDaoInsert);
            assertTrue(condition);
        } catch (DaoException exp) {
            fail(exp.getMessage());
        }
    }

    @Test(expectedExceptions = DaoException.class)
    public void addWithDaoShouldThrowException() throws DaoException {
        boolean condition = userDao.add(userTestForDaoInsert);
        assertTrue(condition);

    }

    @Test
    public void findByLoginShouldReturnCorrectUser() {
        try {
            userTest2 = userDao.findByLogin("doggy");
            assertEquals(userTest2, userTest3);
        } catch (DaoException exp) {
            fail(exp.getMessage());
        }
    }

    @Test
    public void findByLoginShouldReturnNull() {
        try {
            userTest2 = userDao.findByLogin("1111");
            assertNull(userTest2);
        } catch (DaoException exp) {
            fail(exp.getMessage());
        }
    }

    @Test
    public void findByLoginAndPasswordShouldReturnCorrectUser() {
        try {
            userTest2 = userDao.findByLoginAndPassword("doggy", "999");
            assertEquals(userTest2, userTest1);
        } catch (DaoException exp) {
            fail(exp.getMessage());
        }
    }

    @Test
    public void findByLoginAndPasswordShouldReturnNull() {
        try {
            userTest2 = userDao.findByLoginAndPassword("111", "999");
            assertNull(userTest2);
        } catch (DaoException exp) {
            fail(exp.getMessage());
        }
    }

    @Test
    public void checkLoginUniqueShouldReturnTrue() {
        try {
            boolean condition = userDao.checkLoginUnique("kuku");
            assertTrue(condition);
        } catch (DaoException exp) {
            fail(exp.getMessage());
        }
    }

    @Test
    public void checkLoginUniqueShouldReturnFalse() {
        try {
            boolean condition = userDao.checkLoginUnique("luki4");
            assertFalse(condition);
        } catch (DaoException exp) {
            fail(exp.getMessage());
        }
    }

    @Test
    public void findAllShouldReturnCorrectListOfUsers() {
        try {
            List<User> allUsers = userDao.findAll();
            assertEquals(7, allUsers.size());
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findAllShouldReturnIncorrectListOfUsers() {
        try {
            List<User> allUsers = userDao.findAll();
            assertNotEquals(5, allUsers.size());
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public void afterClass() {
        userDao = null;
        userTest1 = null;
        userTest2 = null;
        userTest3 = null;
        userTestForDaoInsert = null;
    }
}
