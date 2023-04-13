import java.util.Random;
import java.util.concurrent.Semaphore;

public class PetrolStation {
    private int amount;
    private final Semaphore semaphore = new Semaphore(3);

    public PetrolStation(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void doRefuel(int requestedAmount) throws InterruptedException {
        if (requestedAmount > amount) {
            System.out.println("Недостаточно топлива на заправке!");
            return;
        }

        semaphore.acquire(); // Захватить разрешение на заправку
        System.out.println(Thread.currentThread().getName() + " начал заправку");
        Thread.sleep((long) (Math.random() * 8000) + 3000); // Ожидание 3-10 секунд
        amount -= requestedAmount;
        System.out.println(Thread.currentThread().getName() + " завершил заправку. Осталось топлива: " + amount);
        semaphore.release(); // Освободить разрешение на заправку

        semaphore.release();
    }
}
