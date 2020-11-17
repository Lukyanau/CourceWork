package by.bntu.coursework.dao;

import by.bntu.coursework.entity.Car;
import by.bntu.coursework.exception.DaoException;

import java.util.List;

public interface CarDao extends BaseDao<Car>{
    Car findCarById(int id) throws DaoException;


}
