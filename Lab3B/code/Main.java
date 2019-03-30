package HMW3_PB_986636;

public class Main {

    public static void main(String[] args) {
        inMapperWordCount wordCount = new inMapperWordCount(4, 3, new String[]{"C:\\Users\\DELL\\eclipse-workspace\\BigData\\src\\HMW3_PB_986636\\inputFile1.txt", "C:\\Users\\DELL\\eclipse-workspace\\BigData\\src\\HMW3_PB_986636\\inputFile2.txt", "C:\\Users\\DELL\\eclipse-workspace\\BigData\\src\\HMW3_PB_986636\\inputFile3.txt", "C:\\Users\\DELL\\eclipse-workspace\\BigData\\src\\HMW3_PB_986636\\inputFile4.txt"});

        wordCount.shuffleAndSort();
        wordCount.reduce();
        wordCount.print();

    }
}