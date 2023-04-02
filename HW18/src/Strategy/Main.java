package Strategy;

import Builder.Car;

public class Main {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(5, 10);
        Triangle triangle = new Triangle(3, 4);
        AreaCalculator calculator = new AreaCalculator();

        calculator.setShape(rectangle);
        double rectangleArea = calculator.getArea();

        calculator.setShape(triangle);
        double triangleArea = calculator.getArea();
    }
}
