package by.bntu.coursework.dao.impl;

import by.bntu.coursework.dao.CarDao;
import by.bntu.coursework.entity.Car;
import by.bntu.coursework.exception.DaoException;

import java.util.List;

public class CarDaoImpl implements CarDao {

    private static final CarDaoImpl instance = new CarDaoImpl();

    private CarDaoImpl(){}

    public static CarDaoImpl getInstance(){
        return instance;
    }

    @Override
    public boolean add(Car car) throws DaoException {
        return false;
    }

    @Override
    public Car remove(int id) throws DaoException {
        return null;
    }

    @Override
    public List<Car> findAll() throws DaoException {
        return null;
    }

    @Override
    public Car findCarById(int id) throws DaoException {
        return null;
    }

}
