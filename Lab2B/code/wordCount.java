package HMW2_PB_986636;

import java.util.Arrays;
import java.util.stream.IntStream;

public class wordCount {
    private final String[] filesPath;
    private final mapper[] mappers;
    private final reducer[] reducers;

    public wordCount(int m, int r, String[] filesPath) {
        mappers = new mapper[m];
        reducers = new reducer[r];
        this.filesPath = filesPath;
        initMappers();
        initReducers();
    }

    private void initReducers() {
        for (int i = 0; i < reducers.length; i++) {
            reducers[i] = new reducer(i);
        }
    }

    private void initMappers() {
        IntStream.range(0, mappers.length).forEach(x -> {
            System.out.printf("%s %d: \n","Mapper Input ", x);
            mappers[x] = new mapper(filesPath[x], x);
            mappers[x].map();
        });

        IntStream.range(0, mappers.length).forEach(i -> {
            System.out.printf("%s %d %s: \n","Mapper ",i," Output");
            mappers[i].getSplits().forEach(x -> {
                System.out.println("<" + x.getKey() + "," + x.getValue() + ">");
            });
        });
    }

    public mapper[] getMappers() {
        return mappers;
    }

    public reducer[] getReducers() {
        return reducers;
    }

    public int getPartition(String key) {
        return (int) key.hashCode() % reducers.length;
    }

    public void shuffleAndSort() {
        Arrays.stream(mappers).forEach(x -> {
            x.getSplits().forEach(z -> {
                int p = getPartition(z.getKey().toLowerCase());
                reducers[p].groupingByPairs(z);
            });
        });

        Arrays.stream(mappers).forEach(x -> {
            Integer lastIndexX = x.getId();
            Arrays.stream(reducers).forEach(y -> {
                y.sortMappedData();
                System.out.println("Pairs sent from Mapper " + lastIndexX + " Reducer " + y.getId());
                y.getMappedData().stream()
                        .filter(z -> x.getSplits().contains(z))
                        .forEach(z -> System.out.println("<" + z.getKey() + "," + z.getValue() + ">"));
            });
        });

        Arrays.stream(reducers).forEach(x -> {
            x.sortGroupedPairs();
            System.out.println("Reducer " + x.getId() + " input:");
            x.getGroupByPairs().forEach(y -> System.out.println("<" + y.getKey() + "," + y.getValue() + ">"));
        });
    }

    public void reduce() {
        Arrays.stream(reducers).forEach(x -> x.reduceGroups());
    }

    public void print() {
        Arrays.stream(reducers)
                .peek(x -> System.out.println("Reducer " + x.getId() + " Output:"))
                .flatMap(x -> x.getReducedList().stream())
                .forEach(x -> System.out.println("<" + x.getKey() + "," + x.getValue() + ">"));
    }

}
