package HMW2_PB_986636;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class reducer {

    private final int id;
    private List<myGroupedPair> groupByPairs;
    private List<myPair<String, Integer>> mappedData;
    private List<myPair<String, Integer>> reducedList;

    public reducer(int index) {
        id = index;
        reducedList = new ArrayList<>();
        mappedData = new ArrayList<>();
        groupByPairs = new ArrayList<>();
    }

    public void groupingByPairs(myPair<String, Integer> item) {
        Optional<myGroupedPair> el = groupByPairs.stream().filter(x -> x.getKey().equals(item.getKey())).findFirst();
        if (!el.isPresent()) {
            groupByPairs.add(new myGroupedPair(item.getKey(), item.getValue()));
        } else {
            el.get().addValue(item.getValue());
        }
        mappedData.add(item);
    }

    public void reduce(myGroupedPair pair) {
        int sum = pair.getValue().stream().mapToInt(i -> i).sum();
        reducedList.add(new myPair<>(pair.getKey(), sum));
    }

    public List<myGroupedPair> getGroupByPairs() {
        return groupByPairs;
    }

    public void reduceGroups() {
        groupByPairs.forEach(this::reduce);
    }

    public List<myPair<String, Integer>> getReducedList() {
        return reducedList;
    }

    public List<myPair<String, Integer>> getMappedData() {
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