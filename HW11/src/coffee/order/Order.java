package coffee.order;

public class Order {
    private int numOrder;
    private String customName;


    public Order(int numOrder, String customName) {
        this.numOrder = numOrder;
        this.customName = customName;
    }

    public int getOrderNumber() {
        return numOrder;
    }

    public String getCustomName() {
        return customName;
    }

    @Override
    public String toString() {
        return "Order{" +
                "numOrder=" + numOrder +
                ", customName='" + customName + '\'' +
                '}';
    }
}
