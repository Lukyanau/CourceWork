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
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.*;

@PrepareForTest(CarDaoImpl.class)

public class CarServiceTest {
    private CarDao daoMock;
    private CarServiceImpl carService;
    private List<Car> carsTestList;

    @BeforeMethod
    public void setUp() {
        daoMock = mock(CarDaoImpl.class);
        carService = CarServiceImpl.getInstance();
        Whitebox.setInternalState(CarDaoImpl.class, "instance", daoMock);

        carsTestList = new ArrayList<>();

    }

    @Test
    public void findByMarkShouldReturnNotNullListOfCars() {
        Car bmw = new Car("New auto with greatest quality", "BMW i8", "Blue", 100000, "bmw");
        carsTestList.add(bmw);
        try {
            when(daoMock.findAll()).thenReturn(carsTestList);
            List<Car> foundedCars = carService.findByMark("bmw");
            assertEquals(carsTestList, foundedCars);
        } catch (DaoException | ServiceException exp) {
            fail(exp.getMessage());
        }
    }

    @Test(expectedExceptions = ServiceException.class)
    public void findByMarkShouldThrowException() throws DaoException, ServiceException {
        when(daoMock.findAll()).thenThrow(DaoException.class);
        List<Car> foundedCars = carService.findByMark("bmw");
    }


    @Test
    public void isActivateCarShouldReturnTrue() {
        Car bmw = new Car("New auto with greatest quality", "BMW i8", "Blue", 100000, "bmw");
        try {
            when(daoMock.findCarById(any(Integer.class))).thenReturn(bmw);
            boolean statusChanged = carService.isActivateCar(1);
            assertTrue(statusChanged);
        } catch (DaoException | ServiceException exp) {
            fail(exp.getMessage());
        }
    }

    @Test
    public void isActivateCarShouldReturnFalse() {
        Car bmw = new Car("New auto with greatest quality", "BMW i8", "Blue", 100000, false, "bmw");
        try {
            when(daoMock.findCarById(any(Integer.class))).thenReturn(bmw);
            boolean statusChanged = carService.isActivateCar(1);
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

    @AfterClass
    public void tierDown() {
        daoMock = null;
        carService = null;
        carsTestList = null;

    }
}
