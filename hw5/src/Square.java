public class Square implements Area{

        //Сторона
        private final double param;

        public Square(double param) {
            this.param = param;
        }

    @Override
    public double getArea() {
        return param * param;
    }

}
