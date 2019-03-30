package HMW1_986636;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class wrapper {

    List<myPair> lines;
    private String RegexSplit = "[\\W+,-.]|(\\w+[\\._]\\w+)|\\\"|([A-Za-z]+[\\d]+[\\w]*)|\\d";

    public wrapper() {
    }

    private void readInput(String inputName) {

        try (Stream<String> stream = Files.lines(Paths.get(inputName))) {
            lines = stream.map(x -> x.split(RegexSplit))
                    .flatMap(Arrays::stream)
                    .filter(x -> !x.isEmpty())
                    .map(x -> new myPair<>(x, 1))
                    .sorted(Comparator.comparing(x -> x.getKey().toLowerCase()))
                    .collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        wrapper wrap = new wrapper();
        System.out.println("Reading input file:");
        wrap.readInput("C:\\Users\\DELL\\eclipse-workspace\\BigData\\src\\HMW1_986636\\testDataForW1D1.txt");
        System.out.println(Arrays.deepToString(wrap.lines.toArray()));
    }
}