package by.bntu.coursework.service;

import by.bntu.coursework.entity.Car;
import by.bntu.coursework.exception.ServiceException;

import java.util.List;

public interface CarService {
    List<Car> findByMark(String mark) throws ServiceException;
    boolean isActivateCar(int id) throws ServiceException;
}
