package HMW2_PA_986636;

import java.util.ArrayList;
import java.util.List;

public class myGroupedPair extends myPair<String, List<Integer>> {

    public myGroupedPair(String key) {
        super(key, new ArrayList<>());
    }

    public myGroupedPair(String key, int value) {
        super(key, new ArrayList<>());
        add(value);
    }

    public void add(Integer p) {
        this.getValue().add(p);
    }
}