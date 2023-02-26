package phonebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneDirectory {

    public static Map<String, String> pb = new HashMap<String, String>();

    private static void add(String name, String phone) {
        pb.put(phone, name);
    }

    public static String[] FindNumberPhone(String name) {
        List<String> result = new ArrayList<String>();
        for (Map.Entry entry : pb.entrySet()) {
            if (name.equalsIgnoreCase((String) entry.getValue())) {
                result.add((String) entry.getKey());
            }
        }
        if (result.size() == 0) {
            result.add("не найдено записей");
        }
        return result.toArray(new String[0]);
    }

    public static String find(String name) {
        String result = pb.get(name);
        if (result == null) {
            return "null";
        }
        return result;
    }
}
