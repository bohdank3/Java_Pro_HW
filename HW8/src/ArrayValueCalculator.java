public class ArrayValueCalculator {
    int[][] arr;

    public static int doCalc(String[][] calc) throws ArraySizeException, ArrayDataException {
        int sumCounter = 0;
        int rows = calc.length;
        int columns = calc[0].length;

        for (int i = 0; i < calc.length; i++) {
            for (int k = 0; k < calc[i].length; k++) {
                try {
                    sumCounter = sumCounter + Integer.parseInt(calc[i][k]);
                } catch (NumberFormatException nfe) {
                    throw new ArrayDataException(i,k);
                }
            }
        }

        if(rows != 4 || columns !=4){
            throw new ArraySizeException(rows,columns);
        }
        return sumCounter;
    }
}
