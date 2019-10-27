import utils.file.CSVFactory;
import utils.SortType;
import utils.TestManager;
import utils.file.FileLoader;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Main {

    private static final int QTD_TESTS = 50;

    public static void main(String[] args) {
        long beforeUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        final CSVFactory factory = new CSVFactory(System.getProperty("user.dir") + "\\reports\\report.csv",
                "Test size",
                "Bubble",
                "Selection",
                "Insertion",
                "Merge",
                "Heap",
                "Quick",
                "Count",
                "Bucket",
                "Radix"
        );
        final List<Integer> sizesToTest = Arrays.asList(5, 50, 100, 1000, 10000);

        Map<Integer, Map<SortType, Double>> sizeToTotalTime = new LinkedHashMap<>();
        TestManager currentTest;

        for(int currentSize : sizesToTest) {
            currentTest = new TestManager(currentSize);
            sizeToTotalTime.put(currentSize, new HashMap<>());
            for(int i = 0; i < QTD_TESTS; i++) {
                currentTest.trigger();
                currentTest.getTimestampRatio().forEach((key, value) ->
                        sizeToTotalTime.get(currentSize).merge(key, value, Double::sum)
                );
            }
        }

        sizeToTotalTime.forEach((size, totalTimeBySortType) -> {
            setAverages(totalTimeBySortType);
            setScientificNotation(totalTimeBySortType, size);

            factory.addRecord(
                size,
                totalTimeBySortType.get(SortType.BUBBLE_SORT)       + (size >= 1e4 ? " ms" : " ns"),
                totalTimeBySortType.get(SortType.SELECTION_SORT)    + (size >= 1e4 ? " ms" : " ns"),
                totalTimeBySortType.get(SortType.INSERTION_SORT)    + (size >= 1e4 ? " ms" : " ns"),
                totalTimeBySortType.get(SortType.MERGE_SORT)        + (size >= 1e4 ? " ms" : " ns"),
                totalTimeBySortType.get(SortType.HEAP_SORT)         + (size >= 1e4 ? " ms" : " ns"),
                totalTimeBySortType.get(SortType.QUICK_SORT)        + (size >= 1e4 ? " ms" : " ns"),
                totalTimeBySortType.get(SortType.COUNT_SORT)        + (size >= 1e4 ? " ms" : " ns"),
                totalTimeBySortType.get(SortType.BUCKET_SORT)       + (size >= 1e4 ? " ms" : " ns"),
                totalTimeBySortType.get(SortType.RADIX_SORT)        + (size >= 1e4 ? " ms" : " ns")
            );

            buildChart(totalTimeBySortType, size);
        });
        factory.close();
        
        long afterUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("Program used " + (afterUsedMem-beforeUsedMem)/1e6 + "MB");
    }

    private static void setAverages(Map<SortType, Double> totalTimeBySortType) {
        totalTimeBySortType.forEach(((sortType, totalTime) ->
                totalTimeBySortType.put(sortType, totalTimeBySortType.get(sortType)/QTD_TESTS))
        );
    }

    private static void setScientificNotation(Map<SortType, Double> totalTimeBySortType, int size) {
        totalTimeBySortType.forEach((sortType, totalTime) ->
                totalTimeBySortType.put(sortType, totalTimeBySortType.get(sortType)/(size >= 1e4 ? 1e6 : 1))
        );
    }

    private static void buildChart(Map<SortType, Double> totalTimeBySortType, int size) {
        File file = new File("./reports/chart_size_" + size + ".html");
        try {
            file.createNewFile();

            PrintWriter pw = new PrintWriter(file);
            FileLoader loader = new FileLoader(System.getProperty("user.dir") + "/src/utils/file/template.html");

            String html = loader.loadAsString()
                        .replace("$page_title", "Sort methods by time " + size)
                        .replace("$labels", toString(totalTimeBySortType.keySet()))
                        .replace("$bar_label", "Time" + (size >= 1e4 ? " ms" : " ns"))
                        .replace("$data", totalTimeBySortType.values().toString())
                        .replace("$title", "Sort methods by time. Array size " + size);

            System.out.println(html);
            pw.print(html);
            loader.close();
            pw.close();
        } catch (IOException e) {
            System.err.println("Failed creating file chart" + size + ".html\nError: " + e.getMessage());
        }
    }

    private static String toString(Set<SortType> sortTypes) {
        final StringBuilder builder = new StringBuilder("[");

        int i = 0;
        for(SortType element : sortTypes) {
            builder.append("'").append(element).append("'").append(i < sortTypes.size() - 1 ? ", " : "");
            i++;
        }

        return builder.append("]").toString();
    }
}