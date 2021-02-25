package by.bntu.coursework.dao.impl;

import by.bntu.coursework.connection.ConnectionCreator;
import by.bntu.coursework.creator.CarCreator;
import by.bntu.coursework.dao.CarDao;
import by.bntu.coursework.dao.SqlQuery;
import by.bntu.coursework.entity.Car;
import by.bntu.coursework.exception.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarDaoImpl implements CarDao {

    private static final CarDaoImpl instance = new CarDaoImpl();

    private CarDaoImpl() {
    }

    public static CarDaoImpl getInstance() {
        return instance;
    }


    @Override
    public boolean add(Car car) throws DaoException {
        boolean isAdded;

        try (Connection connection = ConnectionCreator.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(SqlQuery.ADD_CAR);
            statement.setString(1, car.getMark().getNameMark());
            statement.setString(2, car.getTitle());
            statement.setString(3, car.getColor());
            statement.setString(4, car.getDescription());
            statement.setInt(5, car.getPrice());
            isAdded = statement.executeUpdate() > 0;
        } catch (SQLException exp) {
            throw new DaoException(exp);
        }
        return isAdded;
    }

    @Override
    public Car remove(int id) throws DaoException {
        return null;
    }

    @Override
    public List<Car> findAll() throws DaoException {
        List<Car> allCars = new ArrayList<>();
        CarCreator carCreator = CarCreator.getInstance();
        try (Connection connection = ConnectionCreator.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(SqlQuery.FIND_ALL_CARS);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Car car;
                int carId = resultSet.getInt("carId");
                String carTitle = resultSet.getString("title");
                int carPrice = resultSet.getInt("price");
                String carDescription = resultSet.getString("description");
                boolean carStatus = resultSet.getBoolean("status");
                String carColor = resultSet.getString("color");
                String carMark = resultSet.getString("mark");
                car = carCreator.createCar(carId, carDescription, carTitle, carColor, carPrice, carStatus, carMark);
                allCars.add(car);
            }
        } catch (SQLException exp) {
            throw new DaoException(exp);
        }

        return allCars;
    }

    @Override
    public Car findCarById(int id) throws DaoException {
        return null;
    }

    public boolean banCar(int carId) throws DaoException {

        boolean isUpdate;

        try (Connection connection = ConnectionCreator.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(SqlQuery.BAN_CAR_BY_ID);
            statement.setInt(1, carId);
            isUpdate = statement.executeUpdate() > 0;
        } catch (SQLException exp) {
            throw new DaoException(exp);
        }
        return isUpdate;
    }

    public boolean unBanCar(int carId) throws DaoException {
        boolean isUpdate;

        try (Connection connection = ConnectionCreator.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(SqlQuery.UNBAN_CAR_BY_ID);
            statement.setInt(1, carId);
            isUpdate = statement.executeUpdate() > 0;
        } catch (SQLException exp) {
            throw new DaoException(exp);
        }
        return isUpdate;
    }

    public List<Car> findActiveCars(String mark) throws DaoException {
        List<Car> allCars = new ArrayList<>();
        CarCreator carCreator = CarCreator.getInstance();
        try (Connection connection = ConnectionCreator.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(SqlQuery.FIND_ACTIVE_CARS);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Car car;
                int carId = resultSet.getInt("carId");
                String carTitle = resultSet.getString("title");
                int carPrice = resultSet.getInt("price");
                String carDescription = resultSet.getString("description");
                boolean carStatus = resultSet.getBoolean("status");
                String carColor = resultSet.getString("color");
                String carMark = resultSet.getString("mark");
                if (mark.toLowerCase().equals("all")) {
                    car = carCreator.createCar(carId, carDescription, carTitle, carColor, carPrice, carStatus, carMark);
                    allCars.add(car);
                } else if(mark.toLowerCase().equals(carMark)){
                    car = carCreator.createCar(carId, carDescription, carTitle, carColor, carPrice, carStatus, carMark);
                    allCars.add(car);
                }
            }
        } catch (SQLException exp) {
            throw new DaoException(exp);
        }

        return allCars;
    }


}
