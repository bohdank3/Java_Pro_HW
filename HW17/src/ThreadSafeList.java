import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ThreadSafeList {
    List<Integer> syncList = Collections.synchronizedList(new ArrayList<>());


    public void add(int element) {
        synchronized (syncList) {
            syncList.add(element);
        }
    }

    public void remove(int index) {
        synchronized (syncList) {
            syncList.remove(index);
        }
    }

    public int get(int index) {
        synchronized (syncList) {
            return syncList.get(index);
        }
    }
}


