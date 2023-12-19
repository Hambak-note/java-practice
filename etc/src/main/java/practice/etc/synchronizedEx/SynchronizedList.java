package practice.etc.synchronizedEx;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SynchronizedList {

    private List<Integer> list = Collections.synchronizedList(new ArrayList<Integer>());

    public void addToList(Integer number) {
        list.add(number);
    }

    public List<Integer> getList() {
        return list;
    }
}
