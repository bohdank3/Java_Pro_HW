public class ArraySizeException extends Exception{
    public int line;
    public int col;

    public ArraySizeException(int rows, int columns) {
        this.line = rows;
        this.col = columns;
    }
}
