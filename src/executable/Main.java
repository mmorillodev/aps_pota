package executable;

import com.google.gson.Gson;
import utils.io.CSVFactory;
import utils.SortType;
import utils.TestManager;
import utils.io.FileLoader;
import utils.io.ScannerUtils;
import utils.resources.R;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Main {

    private static final int QTD_TESTS = 50;

    public static void main(String[] args) {
        long beforeUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        final CSVFactory factory = new CSVFactory(
                R.string.REPORTS_FOLDER_ADDRESS + "/report.csv",
                R.value.CSV_HEADERS
        );
        final Set<Integer> sizesToTest = new LinkedHashSet<Integer>() {{
            ScannerUtils scanner = new ScannerUtils();
            for(int entry = 1; entry > 0; ) {
                entry = scanner.getInt("Enter the test length (greater than 0): ");
                if(entry > 0) add(entry);
            }
        }};

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
        });
        buildCharts(sizeToTotalTime);
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

    private static void buildCharts(Map<Integer, Map<SortType, Double>> sizeToTotalTime) {
        File file = new File(R.string.REPORTS_FOLDER_ADDRESS + "/charts.html");

        try {
            file.createNewFile();

            PrintWriter pw = new PrintWriter(file);
            FileLoader loader = new FileLoader(R.string.HTML_TEMPLATE_ADDRESS);

            String html = loader.loadAsString()
                        .replace("$data", new Gson().toJson(sizeToTotalTime));

            pw.print(html);
            loader.close();
            pw.close();
        } catch (IOException e) {
            System.err.println("Failed creating file charts.html\nError: " + e.getMessage());
        }
    }
}