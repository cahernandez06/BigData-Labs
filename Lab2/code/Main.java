package HMW2_PA_986636;

import java.util.List;

public class Main {


    public Main() {
    }

    public static void main(String[] args) {
        mapper mapper = new mapper("C:\\Users\\DELL\\eclipse-workspace\\BigData\\src\\HMW2_PA_986636\\testDataForW1D1.txt");
        mapper.map();
        mapper.sort();
        List<myPair<String, Integer>> mappedData = mapper.getFileLines();

        System.out.printf("\n%s\n\n","1.Mapper Output:");
        mappedData.forEach(x -> System.out.println("<" + x.getKey() + "," + x.getValue() + ">"));

        reducer reducer = new reducer(mappedData);
        System.out.printf("\n%s\n\n","2.Reducer Input:");
        reducer.getGroupByPairs().forEach(x -> System.out.println("<" + x.getKey() + "," + x.getValue() + ">"));

        reducer.reduceGroups();
        List<myPair<String, Integer>> result = reducer.getReducedList();
        System.out.printf("\n%s\n\n","3.Reducer Output:");
        result.forEach(x -> System.out.println("<" + x.getKey() + "," + x.getValue() + ">"));

    }
}