package Strategy;

public class AreaCalculator {
    private Shape shape;

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public double getArea() {
        if (shape == null) {
            throw new RuntimeException("Не задана стратегия формы");
        }
        return shape.calculateArea();
    }
}
