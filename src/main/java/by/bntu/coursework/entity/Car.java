package by.bntu.coursework.entity;

import java.util.Objects;

public class Car extends Entity{
   public enum Marks{
        BMW,
        AUDI,
        MERCEDES,
        TESLA,
        VOLKSWAGEN,
        PEUGEOT,
        RENAULT,
    }
    private int carId;
    private String description;
    private String title;
    private String color;
    private int price;
    private boolean status;
    private Marks mark;

    public Car(int carId, String description, String title, String color, int price, boolean status, String mark) {
        this.carId = carId;
        this.description = description;
        this.title = title;
        this.color = color;
        this.price = price;
        this.status = status;
        this.mark = Marks.valueOf(mark.toUpperCase());
    }
    public Car( String description, String title, String color, int price, boolean status, String mark) {
        this.description = description;
        this.title = title;
        this.color = color;
        this.price = price;
        this.status = status;
        this.mark = Marks.valueOf(mark.toUpperCase());
    }

    public Car(String description, String title, String color, int price, String mark) {
        this.description = description;
        this.title = title;
        this.color = color;
        this.price = price;
        this.status = true;
        this.mark = Marks.valueOf(mark.toUpperCase());
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Marks getMark() {
        return mark;
    }

    public void setMark(Marks mark) {
        this.mark = mark;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (carId != car.carId) return false;
        if (price != car.price) return false;
        if (status != car.status) return false;
        if (description != null ? !description.equals(car.description) : car.description != null) return false;
        if (title != null ? !title.equals(car.title) : car.title != null) return false;
        if (color != null ? !color.equals(car.color) : car.color != null) return false;
        return mark == car.mark;
    }

    @Override
    public int hashCode() {
        int result = carId;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + price;
        result = 31 * result + (status ? 1 : 0);
        result = 31 * result + (mark != null ? mark.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", description='" + description + '\'' +
                ", title='" + title + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", status=" + status +
                ", mark=" + mark +
                '}';
    }
}
