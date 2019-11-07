import com.google.gson.Gson;
import util.io.CSVFactory;
import resource.SortType;
import helper.TestManager;
import util.io.FileLoader;
import util.io.ScannerUtils;
import resource.R;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Main {

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

        System.out.println("\n=====================================");
        System.out.println("========  Starting execution  =======");
        System.out.println("=====================================");

        Map<Integer, Map<SortType, Long>> sizeToTimestampRatio = new LinkedHashMap<>();
        TestManager currentTest;

        for(int currentSize : sizesToTest) {
            currentTest = new TestManager(currentSize);
            sizeToTimestampRatio.put(currentSize, new HashMap<>());
            for(int i = 0; i < R.value.QTD_TESTS; i++) {
                currentTest.trigger();
                currentTest.getTimestampRatio().forEach((key, value) ->
                    sizeToTimestampRatio.get(currentSize).merge(key, value, Long::sum)
                );
            }
        }

        sizeToTimestampRatio.forEach((size, totalTimeBySortType) -> {
            setAverages(totalTimeBySortType);
            factory.addRecord(
                size,
                totalTimeBySortType.get(SortType.BUBBLE_SORT)    /(size >= 1e4 ? 1e6 : 1) + (size >= 1e4 ? " ms" : " ns"),
                totalTimeBySortType.get(SortType.SELECTION_SORT) /(size >= 1e4 ? 1e6 : 1) + (size >= 1e4 ? " ms" : " ns"),
                totalTimeBySortType.get(SortType.INSERTION_SORT) /(size >= 1e4 ? 1e6 : 1) + (size >= 1e4 ? " ms" : " ns"),
                totalTimeBySortType.get(SortType.MERGE_SORT)     /(size >= 1e4 ? 1e6 : 1) + (size >= 1e4 ? " ms" : " ns"),
                totalTimeBySortType.get(SortType.HEAP_SORT)      /(size >= 1e4 ? 1e6 : 1) + (size >= 1e4 ? " ms" : " ns"),
                totalTimeBySortType.get(SortType.QUICK_SORT)     /(size >= 1e4 ? 1e6 : 1) + (size >= 1e4 ? " ms" : " ns"),
                totalTimeBySortType.get(SortType.COUNT_SORT)     /(size >= 1e4 ? 1e6 : 1) + (size >= 1e4 ? " ms" : " ns"),
                totalTimeBySortType.get(SortType.BUCKET_SORT)    /(size >= 1e4 ? 1e6 : 1) + (size >= 1e4 ? " ms" : " ns"),
                totalTimeBySortType.get(SortType.RADIX_SORT)     /(size >= 1e4 ? 1e6 : 1) + (size >= 1e4 ? " ms" : " ns")
            );
        });
        buildCharts(sizeToTimestampRatio);
        factory.close();
        
        long afterUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        System.out.println("\n=====================================");
        System.out.println("========   End of execution   =======");
        System.out.println("=====================================");

        System.out.println("Program used " + (afterUsedMem-beforeUsedMem)/1e6 + "MB");
    }

    private static void setAverages(Map<SortType, Long> totalTimeBySortType) {
        totalTimeBySortType.forEach(((sortType, totalTime) ->
                totalTimeBySortType.put(sortType, totalTimeBySortType.get(sortType).longValue()/R.value.QTD_TESTS))
        );
    }

    private static void buildCharts(Map<Integer, Map<SortType, Long>> sizeToTotalTime) {
        File file = new File(R.string.REPORTS_FOLDER_ADDRESS + "/default_charts.html");
        File file2 = new File(R.string.REPORTS_FOLDER_ADDRESS + "/charts_sort_perspective.html");
        File file3 = new File(R.string.REPORTS_FOLDER_ADDRESS + "/direct_sort_comparison.html");
        Gson json = new Gson();

        loadAndWrite(file, R.template.GENERAL_VISION, json.toJson(sizeToTotalTime));
        loadAndWrite(file2, R.template.SORT_PERSPECTIVE, json.toJson(sizeToTotalTime));
        loadAndWrite(file3, R.template.DIRECT_SORT_COMPARISON, json.toJson(sizeToTotalTime));

        try {
            Desktop.getDesktop().browse(file.toURI());
            Desktop.getDesktop().browse(file2.toURI());
            Desktop.getDesktop().browse(file3.toURI());
        } catch (IOException e) {
            System.err.println("Failed opening the charts");
        }
    }

    private static void loadAndWrite(File file, String template, String data) {
        try {
            Path path = Paths.get(R.string.REPORTS_FOLDER_ADDRESS);
            if(!Files.exists(path))
                Files.createDirectories(path);
            if(!file.exists())
                file.createNewFile();

            PrintWriter pw = new PrintWriter(file);
            FileLoader loader = new FileLoader(template);

            String html = loader.loadAsString().replace("$data", data);

            pw.print(html);
            loader.close();
            pw.close();
        } catch (IOException e) {
            System.err.println("Failed creating file " + file.getName() + "\nError: " + e.getMessage());
        }
    }
}