import utils.CSVFactory;
import utils.SortType;
import utils.TestManager;

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
        final List<Integer> sizesToTests = new ArrayList<Integer>(5){{
            add(5);
            add(50);
            add(100);
            add(1000);
            add(10000);
            add(15000);
        }};

        Map<Integer, Map<SortType, Double>> sizeToTotalTime = new LinkedHashMap<>();
        TestManager currentTest;

        for(int currentSize : sizesToTests) {
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
        totalTimeBySortType.forEach(((sortType, totalTime) -> totalTimeBySortType.put(sortType, totalTimeBySortType.get(sortType)/QTD_TESTS)));
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
            pw.print(
                "<!DOCTYPE html>\n"                                                                                 +
                    "<html>\n"                                                                                      +
                    "<head>\n"                                                                                      +
                    "    <meta charset='utf-8'>\n"                                                                  +
                    "    <title>Sort methods by time " + size + "</title>\n"                                        +
                    "    <script src='../libs/chart.js'></script>\n"                                                +
                    "    <script>\n"                                                                                +
                    "        function createChart() {\n"                                                            +
                    "            var ctx = document.getElementById('chart');\n"                                     +
                    "            new Chart(ctx, {\n"                                                                +
                    "                type: 'bar',\n"                                                                +
                    "                data: {\n"                                                                     +
                    "                    labels: " + toString(totalTimeBySortType.keySet()) + ",\n"                 +
                    "                    datasets: [{\n"                                                            +
                    "                        label: 'Time " + (size >= 1e4 ? " ms" : " ns") + "',\n"                +
                    "                        backgroundColor: \"#c95948\",\n"                                       +
                    "                        data: " + totalTimeBySortType.values() + ",\n"                         +
                    "                        borderWidth: 0\n"                                                      +
                    "                    }]\n"                                                                      +
                    "                },\n"                                                                          +
                    "                options: {\n"                                                                  +
                    "                     title: {\n"                                                               +
                    "                        display: true,\n"                                                      +
                    "                        text: 'Sort methods by time. Array size " + size + "' \n"              +
                    "                     },\n"                                                                     +
                    "                     legend: {\n"                                                              +
                    "                        display: false\n"                                                      +
                    "                     }\n"                                                                      +
                    "                }\n"                                                                           +
                    "            });\n"                                                                             +
                    "        }\n"                                                                                   +
                    "    </script>\n"                                                                               +
                    "</head>\n"                                                                                     +
                    "<body onload='createChart()'>\n"                                                               +
                    "    <canvas id=\"chart\"/>\n"                                                                  +
                    "</body>\n"                                                                                     +
                    "</html>"
            );
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