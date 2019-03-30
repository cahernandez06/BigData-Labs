package HMW2_PB_986636;

import java.util.ArrayList;
import java.util.List;

public class myGroupedPair extends myPair<String, List<Integer>> {

    public myGroupedPair(String key) {
        super(key, new ArrayList<>());
    }

    public myGroupedPair(String key, int value) {
        super(key, new ArrayList<>());
        addValue(value);
    }

    public void addValue(Integer p) {
        this.getValue().add(p);
    }
}