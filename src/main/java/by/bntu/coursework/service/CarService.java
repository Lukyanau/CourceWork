package by.bntu.coursework.service;

import by.bntu.coursework.entity.Car;
import by.bntu.coursework.exception.ServiceException;

import java.util.List;

public interface CarService {
    boolean add(Car car) throws ServiceException;
    List<Car> findByMark(String mark) throws ServiceException;
    boolean isActivateCar(int id) throws ServiceException;
    List<Car> findAll() throws ServiceException;
}
