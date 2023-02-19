import java.util.*;

public class Homework {
    public static int countOccurance(ArrayList<String> list, String elem) {
        int result = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(elem)) {
                result++;
            }
        }
        System.out.println("countOccurance(): В листе розмером: " + list.size() + " cлов " + elem + " встречается " + result + " раз");
        return result;
    }

    public static ArrayList<String> toList(String arr[]) {
        ArrayList<String> result = new ArrayList<String>();
        for (int i = 0; i < arr.length; i++) {
            result.add(arr[i]);
        }
        System.out.println("toList(): Смогли перевести в новый ArrayList: " + arr.length + " .Элименты которые попали: " + result);
        return result;
    }


    public static Set<String> findUnique(ArrayList<String> arrayList) {
        Set<String> result = new LinkedHashSet<String>(arrayList);
        System.out.println("findUnique() : \n Оригинальный: " + arrayList + "\n Уникальные значения:" + result);
        return result;
    }

    public static Map<String, Integer> calcOccurrence(ArrayList<String> arrList) {

        Map<String, Integer> result = new HashMap<String, Integer>();
        for (String x : arrList) {
            int newValue = result.getOrDefault(x, 0) + 1;
            result.put(x, newValue);
        }

        System.out.println("calcOccurrence():\n " + result);

        return result;
    }
// c findOccurance не смог разобраться как сделать

}



