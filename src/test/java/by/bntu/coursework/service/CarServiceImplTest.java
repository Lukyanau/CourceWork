package by.bntu.coursework.service;

import by.bntu.coursework.dao.CarDao;
import by.bntu.coursework.dao.impl.CarDaoImpl;
import by.bntu.coursework.entity.Car;
import by.bntu.coursework.exception.DaoException;
import by.bntu.coursework.exception.ServiceException;
import by.bntu.coursework.service.impl.CarServiceImpl;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.reflect.Whitebox;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.*;

@PrepareForTest(CarDaoImpl.class)

public class CarServiceImplTest {
    private CarDaoImpl daoMock;
    private CarServiceImpl carService;
    private List<Car> carsTestList;

    @BeforeMethod
    public void setUp() {
        daoMock = mock(CarDaoImpl.class);
        carService = CarServiceImpl.getInstance();
        Whitebox.setInternalState(CarDaoImpl.class, "instance", daoMock);

        carsTestList = new ArrayList<>();
        carsTestList.add(new Car("New auto with greatest quality", "BMW i8", "Blue", 100000, "bmw"));
        carsTestList.add(new Car("Best Auto", "Mercedes AMG GT 2", "Yellow", 150000, "mercedes"));
        carsTestList.add(new Car("Unbelievable", "Audi a7", "Black", 70000, "audi"));
    }

    @DataProvider(name = "CorrectMarksToFindCarByMark")
    public Object[] createCorrectMarksToFindCarByMark() {
        return new Object[]
                {
                        "bmw",
                        "mercedes",
                        "audi"
                };
    }

    @DataProvider(name = "IncorrectMarksToFindCarByMark")
    public Object[] createIncorrectMarksToFindCarByMark() {
        return new Object[]
                {
                        "suzuki",
                        "chevrolet",
                        "land rover"
                };
    }

    @Test(dataProvider = "CorrectMarksToFindCarByMark")
    public void findByMarkShouldReturnNotNullListOfCars(String mark) {
        try {
            when(daoMock.findAll()).thenReturn(carsTestList);
            List<Car> foundedCars = carService.findByMark(mark);
            assertEquals(1, foundedCars.size());
        } catch (DaoException | ServiceException exp) {
            fail(exp.getMessage());
        }
    }

    @Test(dataProvider = "IncorrectMarksToFindCarByMark")
    public void findByMarkShouldReturnNullListOfCars(String mark) {
        try {
            when(daoMock.findAll()).thenReturn(carsTestList);
            List<Car> foundedCars = carService.findByMark(mark);
            assertEquals(0, foundedCars.size());
        } catch (DaoException | ServiceException exp) {
            fail(exp.getMessage());
        }
    }

    @Test(expectedExceptions = ServiceException.class)
    public void findByMarkShouldThrowException() throws DaoException, ServiceException {
        when(daoMock.findAll()).thenThrow(DaoException.class);
        List<Car> foundedCars = carService.findByMark(null);
    }


    @DataProvider(name = "CorrectDataForIsActivateCar")
    public Object[][] createCorrectDataForIsActivateCar() {
        return new Object[][]{
                {1, new Car(1, "New auto with greatest quality", "BMW i8", "Blue", 100000, true, "bmw")},
                {2, new Car(2, "Best Auto", "Mercedes AMG GT 2", "Yellow", 150000, true, "mercedes")},
                {3, new Car(3, "Unbelievable", "Audi a7", "Black", 70000, true, "audi")}

        };
    }

    @DataProvider(name = "IncorrectDataForIsActivateCar")
    public Object[][] createIncorrectDataForIsActivateCar() {
        return new Object[][]{
                {-1000, new Car(-3, "New auto with greatest quality", "BMW i8", "Blue", 100000, true, "bmw")},
                {-5, new Car(2, "Best Auto", "Mercedes AMG GT 2", "Yellow", 150000, true, "mercedes")},
                {0, new Car(1, "Unbelievable", "Audi a7", "Black", 70000, true, "audi")}

        };
    }


    @Test(dataProvider = "CorrectDataForIsActivateCar")
    public void isActivateCarShouldReturnTrue(int id, Car car) {
        try {
            when(daoMock.findCarById(any(Integer.class))).thenReturn(car);
            boolean statusChanged = carService.isActivateCar(id);
            assertTrue(statusChanged);
        } catch (DaoException | ServiceException exp) {
            fail(exp.getMessage());
        }
    }

    @Test(dataProvider = "IncorrectDataForIsActivateCar")
    public void isActivateCarShouldReturnFalse(int id, Car car) {
        try {
            when(daoMock.findCarById(any(Integer.class))).thenReturn(car);
            boolean statusChanged = carService.isActivateCar(id);
            assertFalse(statusChanged);
        } catch (DaoException | ServiceException exp) {
            fail(exp.getMessage());
        }
    }

    @Test(expectedExceptions = ServiceException.class)
    public void isActivateCarShouldThrowException() throws DaoException, ServiceException {
        when(daoMock.findCarById(any(Integer.class))).thenThrow(DaoException.class);
        boolean statusChanged = carService.isActivateCar(1);
    }


    @DataProvider(name = "CorrectListOfActiveCars")
    public Object[] createCorrectListOfActiveCars() {
        List<Car> activeCars = new ArrayList<>();
        activeCars.add(new Car("New auto with greatest quality", "BMW i8", "Blue", 100000, "bmw"));
        activeCars.add(new Car("Best Auto", "Mercedes AMG GT 2", "Yellow", 150000, "mercedes"));
        activeCars.add(new Car("Unbelievable", "Audi a7", "Black", 70000, "audi"));
        return new Object[]{
                activeCars
        };
    }

    @DataProvider(name = "IncorrectListOfActiveCars")
    public Object[] createIncorrectListOfActiveCars() {
        List<Car> activeCars = new ArrayList<>();
        activeCars.add(new Car("New auto with greatest quality", "BMW i8", "Blue", 100000, "bmw"));
        return new Object[]{
                activeCars
        };
    }


    @Test(dataProvider = "CorrectListOfActiveCars")
    public void findActiveCarShouldReturnCorrectList(List<Car> list) {
        try {
            when(daoMock.findActiveCars("all")).thenReturn(list);
            List<Car> foundedCars = carService.findActiveCars("all");
            assertEquals(3, foundedCars.size());
        } catch (ServiceException | DaoException exp) {
            fail(exp.getMessage());
        }
    }

    @Test(dataProvider = "IncorrectListOfActiveCars")
    public void findActiveCarShouldReturnIncorrectList(List<Car> list) {
        try {
            when(daoMock.findActiveCars("all")).thenReturn(list);
            List<Car> foundedCars = carService.findActiveCars("all");
            assertNotEquals(3, foundedCars.size());
        } catch (ServiceException | DaoException exp) {
            fail(exp.getMessage());
        }
    }

    @Test(expectedExceptions = ServiceException.class)
    public void findActiveCarThrowException() throws DaoException, ServiceException {
        when(daoMock.findActiveCars("all")).thenThrow(DaoException.class);
        List<Car> foundedCars = carService.findActiveCars("all");
    }

    @Test
    public void banShouldReturnTrue() {
        try {
            when(daoMock.banCar(any(Integer.class))).thenReturn(true);
            boolean isBanned = carService.ban(1);
            assertTrue(isBanned);
        } catch (DaoException | ServiceException exp) {
            fail(exp.getMessage());
        }
    }
    @Test
    public void banShouldReturnFalse() {
        try {
            when(daoMock.banCar(any(Integer.class))).thenReturn(false);
            boolean isBanned = carService.ban(1);
            assertFalse(isBanned);
        } catch (DaoException | ServiceException exp) {
            fail(exp.getMessage());
        }
    }

    @Test(expectedExceptions = ServiceException.class)
    public void banCarThrowException() throws DaoException, ServiceException {
        when(daoMock.banCar(any(Integer.class))).thenThrow(DaoException.class);
        boolean isUnBanned = carService.ban(1);
    }

    @Test
    public void unBanShouldReturnTrue() {
        try {
            when(daoMock.unBanCar(any(Integer.class))).thenReturn(true);
            boolean isUnBanned = carService.unBan(1);
            assertTrue(isUnBanned);
        } catch (DaoException | ServiceException exp) {
            fail(exp.getMessage());
        }
    }

    @Test
    public void unBanShouldReturnFalse() {
        try {
            when(daoMock.unBanCar(any(Integer.class))).thenReturn(false);
            boolean isUnBanned = carService.unBan(1);
            assertFalse(isUnBanned);
        } catch (DaoException | ServiceException exp) {
            fail(exp.getMessage());
        }
    }

    @Test(expectedExceptions = ServiceException.class)
    public void unBanCarThrowException() throws DaoException, ServiceException {
        when(daoMock.unBanCar(any(Integer.class))).thenThrow(DaoException.class);
        boolean isUnBanned = carService.unBan(1);
    }

    @AfterClass
    public void tierDown() {
        daoMock = null;
        carService = null;
        carsTestList = null;

    }
}
