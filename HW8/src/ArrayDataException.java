public  class ArrayDataException extends Exception {
    public int first;
    public int second;

    public ArrayDataException(int i, int j) {
        this.first = i;
        this.second = j;
    }
}