
public class Order {
    private int orderNumber;
    private String customerName;

    public Order(String customerName) {
        this.customerName = customerName;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNumber=" + orderNumber +
                ", customerName='" + customerName + '\'' +
                '}';
    }
}
