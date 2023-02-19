public class Triangle implements Area{
    //Сторона
    private final double param;

    public Triangle(double param) {
        this.param = param;
    }

    @Override
    public double getArea() {
        return (param*param*1.73)/4;
    }

}
