package HMW2_PA_986636;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class mapper {

    private List<myPair<String, Integer>> lines;
    private String scapeRegex = "[\\W+,-.]|(\\w+[\\._]\\w+)|\\\"|([A-Za-z]+[\\d]+[\\w]*)|\\d";
    private String inputName;
    private List<String> stringLines;

    public mapper(String fileName) {
        this.inputName = fileName;
        System.out.printf("%s\n","0.Mapper Input:");
        readFile();
        stringLines.forEach(x -> System.out.println(x));
    }

    private void readFile() {
        try (Stream<String> stream = Files.lines(Paths.get(inputName))) {
            stringLines = stream.collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void map() {
        lines = stringLines.stream().map(x -> x.split(scapeRegex))
                .flatMap(Arrays::stream)
                .filter(x -> !x.isEmpty())
                .map(x -> new myPair<>(x, 1))
                .collect(Collectors.toList());
    }

    public List<myPair<String, Integer>> getFileLines() {
        return lines;
    }

    public void sort() {
        lines.sort(Comparator.comparing(x -> x.getKey().toLowerCase()));
    }
}