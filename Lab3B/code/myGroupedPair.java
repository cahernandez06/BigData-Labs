package HMW3_PB_986636;

import java.util.ArrayList;
import java.util.List;

public class myGroupedPair extends myPair<String, List<myPair<Integer, Integer>>> {

    public myGroupedPair(String key) {
        super(key, new ArrayList<>());
    }

    public myGroupedPair(String key, myPair<Integer, Integer> value) {
        super(key, new ArrayList<>());
        add(value);
    }

    public void add(myPair<Integer, Integer> p) {
        this.getValue().add(p);
    }

    @Override
    public String toString() {
        return new StringBuilder().append(getKey()).append(", ").append(getValue()).toString();
    }
}