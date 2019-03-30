package HMW3_PB_986636;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class reducer {

    private final int id;
    private List<myGroupedPair> groupByPairs;
    private List<myPair<String, myPair<Integer, Integer>>> mappedData;
    private List<myPair<String, Double>> reducedList;

    public reducer(int index) {
        id = index;
        reducedList = new ArrayList<>();
        mappedData = new ArrayList<>();
        groupByPairs = new ArrayList<>();
    }

    public void groupingByPairs(myPair<String, myPair<Integer, Integer>> item) {
        Optional<myGroupedPair> el = groupByPairs.stream().filter(x -> x.getKey().equals(item.getKey())).findFirst();
        if (!el.isPresent()) {
            groupByPairs.add(new myGroupedPair(item.getKey(), item.getValue()));
        } else {
            el.get().add(item.getValue());
        }
        mappedData.add(item);
    }

    public void reduce(myGroupedPair pair) {
        double sumK = pair.getValue().stream().mapToInt(i -> i.getKey()).sum();
        double sumV = pair.getValue().stream().mapToInt(i -> i.getValue()).sum();
        double value = sumV == 0 ? 0 : sumK / sumV;
        reducedList.add(new myPair<>(pair.getKey(), value));
    }

    public List<myGroupedPair> getGroupByPairs() {
        return groupByPairs;
    }

    public void reduceGroups() {
        groupByPairs.forEach(this::reduce);
    }

    public List<myPair<String, Double>> getReducedList() {
        return reducedList;
    }

    public List<myPair<String, myPair<Integer, Integer>>> getMappedData() {
        return mappedData;
    }

    public int getId() {
        return id;
    }

    public void sortGroupedPairs() {
        groupByPairs.sort(Comparator.comparing(x -> x.getKey().toLowerCase()));
    }

    public void sortMappedData() {
        mappedData.sort(Comparator.comparing(x -> x.getKey().toLowerCase()));
    }
}