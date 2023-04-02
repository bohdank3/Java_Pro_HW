import java.util.Arrays;

public class ValueCalculator {
    private double[] array;
    private int size;

    public ValueCalculator(int size) {
        this.size = Math.max(size, 1000000);
        this.array = new double[this.size];
    }

    public void fillArray(double value) {

        Arrays.fill(array, value);

        double[] array1 = Arrays.copyOfRange(array, 0, size / 2);
        double[] array2 = Arrays.copyOfRange(array, size / 2, size);
        System.out.println("Длинна 1 массива: " + array1.length);
        System.out.println("Длинна 2 массива: " + array2.length);


        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < array1.length; i++) {
                    array1[i] = (float) (array1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < array2.length; i++) {
                    array2[i] = (float) (array2[i] * Math.sin(0.2f + (i + array1.length) / 5) * Math.cos(0.2f + (i + array1.length) / 5) * Math.cos(0.4f + (i + array1.length) / 2));
                }
            }
        });
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(array1, 0, array, 0, array1.length);
        System.arraycopy(array2, 0, array, array1.length, array2.length);
    }

}
