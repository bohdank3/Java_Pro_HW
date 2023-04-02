public class Main {
    public static void main(String[] args) {
        PetrolStation station = new PetrolStation(100);

        Thread car1 = new Thread(() -> {
            try {
                station.doRefuel(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread car2 = new Thread(() -> {
            try {
                station.doRefuel(15);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread car3 = new Thread(() -> {
            try {
                station.doRefuel(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread car4 = new Thread(() -> {
            try {
                station.doRefuel(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        Thread car5 = new Thread(() -> {
            try {
                station.doRefuel(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });



        car1.start();
        car2.start();
        car3.start();
        car4.start();
        car5.start();
    }
}