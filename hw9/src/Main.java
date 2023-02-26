import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        list.add("a");
        list.add("a");
        list.add("a");
        list.add("a");
        list.add("B");
        list.add("B");
        list.add("C");
        Homework.countOccurance(list,"a");
        Homework.findUnique(list);
        Homework.calcOccurrence(list);

    }


}
