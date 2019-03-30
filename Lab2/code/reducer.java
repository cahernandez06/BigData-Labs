package HMW2_PA_986636;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class reducer {

    private List<myGroupedPair> groupByPairs;
    private List<myPair<String, Integer>> reducedList;

    public reducer(List<myPair<String, Integer>> mappedData) {
        reducedList = new ArrayList<>();
        groupByPairs = new ArrayList<>();
        groupingByPairs(mappedData);
    }

    public void groupingByPairs(List<myPair<String, Integer>> mappedData) {
        for (myPair<String, Integer> item : mappedData) {
            Optional<myGroupedPair> el = groupByPairs.stream().filter(x -> x.getKey().equals(item.getKey())).findFirst();
            if (!el.isPresent()) {
                groupByPairs.add(new myGroupedPair(item.getKey(), item.getValue()));
            } else {
                el.get().add(item.getValue());
            }
        }
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
}