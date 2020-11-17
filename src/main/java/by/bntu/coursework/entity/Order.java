package by.bntu.coursework.entity;

public class Order extends Entity{
    private int orderId;
    private int carId;
    private int userId;

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (orderId != order.orderId) return false;
        if (carId != order.carId) return false;
        return userId == order.userId;
    }

    @Override
    public int hashCode() {
        int result = orderId;
        result = 31 * result + carId;
        result = 31 * result + userId;
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", carId=" + carId +
                ", userId=" + userId +
                '}';
    }
}
