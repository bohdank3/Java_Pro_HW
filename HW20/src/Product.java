import java.time.LocalDateTime;

public class Product {
    private long id;
    private String type;
    private double price;
    private boolean canApplyDiscount;
    private LocalDateTime dateAdded;

    public Product(long id, String type, double price, boolean canApplyDiscount, LocalDateTime dateAdded) {
        this.id = id;
        this.type = type;
        this.price = price;
        this.canApplyDiscount = canApplyDiscount;
        this.dateAdded = dateAdded;
    }


    public String getType() {
        return type;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public LocalDateTime getDateAdded() {
        return dateAdded;
    }

    public boolean hasDiscount() {
        return canApplyDiscount;
    }

    public void applyDiscount() {
        if (hasDiscount()) {
            price *= 0.9;
        }
    }

    public void setDateAdded(LocalDateTime dateAdded) {
        this.dateAdded = dateAdded;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", dateAdded=" + dateAdded +
                '}';
    }
}
