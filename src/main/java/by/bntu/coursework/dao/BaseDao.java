package by.bntu.coursework.dao;

import by.bntu.coursework.entity.Entity;
import by.bntu.coursework.exception.DaoException;

import java.util.List;

public interface BaseDao<T extends Entity> {
    boolean add(T t) throws DaoException;

    T remove(int id) throws DaoException;

    List<T> findAll() throws DaoException;

}
