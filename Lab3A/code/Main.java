package HMW3_PA_986636;

public class Main {

    public static void main(String[] args) {
        inMapperWordCount wordCount = new inMapperWordCount(3, 4, new String[]{"C:\\Users\\DELL\\eclipse-workspace\\BigData\\src\\HMW3_PA_986636\\inputFile1.txt", "C:\\Users\\DELL\\eclipse-workspace\\BigData\\src\\HMW3_PA_986636\\inputFile2.txt", "C:\\Users\\DELL\\eclipse-workspace\\BigData\\src\\HMW3_PA_986636\\inputFile3.txt"});

        wordCount.shuffleAndSort();
        wordCount.reduce();
        wordCount.print();

    }
}