package by.bntu.coursework.service.impl;

import by.bntu.coursework.dao.CarDao;
import by.bntu.coursework.dao.impl.CarDaoImpl;
import by.bntu.coursework.dao.impl.UserDaoImpl;
import by.bntu.coursework.entity.Car;
import by.bntu.coursework.exception.DaoException;
import by.bntu.coursework.exception.ServiceException;
import by.bntu.coursework.service.CarService;

import java.util.ArrayList;
import java.util.List;

public class CarServiceImpl implements CarService {
    private static final CarServiceImpl instance = new CarServiceImpl();

    private CarServiceImpl() {

    }

    public static CarServiceImpl getInstance() {
        return instance;
    }


    @Override
    public boolean add(Car car) throws ServiceException {
        boolean isAdded;
        CarDaoImpl carDao = CarDaoImpl.getInstance();
        try {
            isAdded = carDao.add(car);
        } catch (DaoException exp) {
            throw new ServiceException(exp);
        }
        return isAdded;
    }

    @Override
    public List<Car> findByMark(String mark) throws ServiceException {
        List<Car> foundCarsByMark = new ArrayList<>();
        CarDaoImpl carDao = CarDaoImpl.getInstance();
        try {
            List<Car> cars = carDao.findAll();
            for (Car car : cars) {
                if (car.getMark().toString().equals(mark.toUpperCase())) {
                    foundCarsByMark.add(car);
                }
            }
        } catch (DaoException exp) {
            throw new ServiceException(exp);
        }
        return foundCarsByMark;
    }

    @Override
    public boolean isActivateCar(int id) throws ServiceException {
        boolean isChange = false;
        CarDaoImpl carDao = CarDaoImpl.getInstance();
        if (id < 1) {
            return false;
        }
        try {
            Car foundCar = carDao.findCarById(id);
            if (foundCar == null) {
                throw new ServiceException("car not found");
            }
            if (foundCar.isStatus()) {
                foundCar.setStatus(false);
                isChange = true;
            }
        } catch (DaoException exp) {
            throw new ServiceException(exp);

        }
        return isChange;
    }

    @Override
    public List<Car> findAll() throws ServiceException {
        CarDaoImpl carDao = CarDaoImpl.getInstance();
        try {
            List<Car> allCars = carDao.findAll();
            return allCars;
        } catch (DaoException exp) {
            throw new ServiceException(exp);
        }
    }

    public List<Car> findActiveCars(String mark) throws ServiceException {
        CarDaoImpl carDao = CarDaoImpl.getInstance();
        try {
            List<Car> activeCars = carDao.findActiveCars(mark);
            return activeCars;
        } catch (DaoException exp){
            throw new ServiceException(exp);
        }
    }



    public boolean ban(int carId) throws ServiceException {
        CarDaoImpl carDao = CarDaoImpl.getInstance();
        try {
            return carDao.banCar(carId);
        } catch (DaoException exp) {
            throw new ServiceException(exp);
        }
    }

    public boolean unBan(int carId) throws ServiceException {
        CarDaoImpl carDao = CarDaoImpl.getInstance();
        try {
            return carDao.unBanCar(carId);
        } catch (DaoException exp) {
            throw new ServiceException(exp);
        }
    }


}
