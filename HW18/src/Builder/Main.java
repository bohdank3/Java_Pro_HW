package Builder;

public class Main {
    public static void main(String[] args) {
        Car car = new Car.CarBuilder()
                .setModel("BMW")
                .setColor("Black")
                .setYear(2022)
                .setHorsepower(400)
                .setSeats(4)
                .setHasGPS(true)
                .setHasBluetooth(true)
                .build();
    }

}
