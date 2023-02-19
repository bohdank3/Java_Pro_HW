public class Circle implements Area {

private double param;

    public Circle(double param) {
        this.param = param;
    }

    @Override
    public double getArea() {
        return 3.14*param*param;
    }
}
