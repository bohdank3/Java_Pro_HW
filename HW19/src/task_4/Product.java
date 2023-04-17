package task_4;

import java.time.LocalDateTime;


    class Product {
        private String type;
        private double price;
        private boolean discount;
        private LocalDateTime dateAdded;

        public Product(String type, double price, boolean discount, LocalDateTime dateAdded) {
            this.type = type;
            this.price = price;
            this.discount = discount;
            this.dateAdded = dateAdded;
        }

        public String getType() {
            return type;
        }

        public double getPrice() {
            return price;
        }

        public boolean hasDiscount() {
            return discount;
        }

        public LocalDateTime getDateAdded() {
            return dateAdded;
        }

        public void applyDiscount() {
            if (hasDiscount()) {
                price *= 0.9;
            }
        }
    }

