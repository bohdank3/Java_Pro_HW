package Builder;

public class Car {
    private String model;
    private String color;
    private int year;
    private int horsepower;
    private int seats;
    private boolean hasGPS;
    private boolean hasBluetooth;

    public Car (){}

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public void setHasGPS(boolean hasGPS) {
        this.hasGPS = hasGPS;
    }

    public void setHasBluetooth(boolean hasBluetooth) {
        this.hasBluetooth = hasBluetooth;
    }

    public static  class CarBuilder {
        private Car car;

        public CarBuilder() {
            car = new Car();
        }

        public CarBuilder setModel(String model) {
            car.setModel(model);
            return this;
        }

        public CarBuilder setColor(String color) {
            car.setColor(color);
            return this;
        }

        public CarBuilder setYear(int year) {
            car.setYear(year);
            return this;
        }

        public CarBuilder setHorsepower(int horsepower) {
            car.setHorsepower(horsepower);
            return this;
        }

        public CarBuilder setSeats(int seats) {
            car.setSeats(seats);
            return this;
        }


        public CarBuilder setHasGPS(boolean hasGPS) {
            car.setHasGPS(hasGPS);
            return this;
        }

        public CarBuilder setHasBluetooth(boolean hasBluetooth) {
            car.setHasBluetooth(hasBluetooth);
            return this;
        }

        public Car build() {
            return car;
        }
    }
}

