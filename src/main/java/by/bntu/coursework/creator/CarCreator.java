package by.bntu.coursework.creator;

import by.bntu.coursework.entity.Car;
import by.bntu.coursework.entity.User;

public class CarCreator {
    public static CarCreator instance = new CarCreator();

    private CarCreator() {
    }

    public static CarCreator getInstance() {
        return instance;
    }

    public Car createCar(int carId, String description, String title, String color, int price, boolean status, String mark) {
        Car car = new Car(carId,description,title,color,price,status,mark);
        return car;
    }

    public Car createCar(String description, String title, String color, int price, boolean status, String mark) {
        Car car = new Car(description,title,color,price,status,mark);
        return car;
    }

    public Car createCar(String description, String title, String color, int price, String mark) {
        Car car = new Car(description,title,color,price,mark);
        return car;
    }
}
