public class Main {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        ValueCalculator calculator = new ValueCalculator(10000000);
        calculator.fillArray(1);

        long end = System.currentTimeMillis();
        System.out.println("Час виконання: " + (end - start) + " ms");
    }



}