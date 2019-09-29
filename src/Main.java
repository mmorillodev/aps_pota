import utils.CSVFactory;
import utils.SortType;
import utils.TestManager;

import java.util.*;

public class Main {

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
        }};
        final int QTD_TESTS = 50;

        Map<Integer, Map<SortType, Double>> sizeToTotalTime = new LinkedHashMap<>();
        TestManager currentTest;

        for(int currentSize : sizesToTests) {
            currentTest = new TestManager(currentSize);
            for(int i = 0; i < QTD_TESTS; i++) {
                currentTest.trigger();
                sizeToTotalTime.put(currentSize, currentTest.getTimestampRatio());
                currentTest.getTimestampRatio().forEach((key, value) -> sizeToTotalTime.get(currentSize).merge(key, value, Double::sum));
            }
        }

        sizeToTotalTime.forEach((size, timestampRatio_) -> {
            factory.addRecord(
                    size,
                    timestampRatio_.get(SortType.BUBBLE_SORT)/50    / (size >= 10000 ? 1e3 : 1) + (size >= 1e4 ? " us" : " ns"),
                    timestampRatio_.get(SortType.SELECTION_SORT)/50 / (size >= 10000 ? 1e3 : 1) + (size >= 1e4 ? " us" : " ns"),
                    timestampRatio_.get(SortType.INSERTION_SORT)/50 / (size >= 10000 ? 1e3 : 1) + (size >= 1e4 ? " us" : " ns"),
                    timestampRatio_.get(SortType.MERGE_SORT)/50     / (size >= 10000 ? 1e3 : 1) + (size >= 1e4 ? " us" : " ns"),
                    timestampRatio_.get(SortType.HEAP_SORT)/50      / (size >= 10000 ? 1e3 : 1) + (size >= 1e4 ? " us" : " ns"),
                    timestampRatio_.get(SortType.QUICK_SORT)/50     / (size >= 10000 ? 1e3 : 1) + (size >= 1e4 ? " us" : " ns"),
                    timestampRatio_.get(SortType.COUNT_SORT)/50     / (size >= 10000 ? 1e3 : 1) + (size >= 1e4 ? " us" : " ns"),
                    timestampRatio_.get(SortType.BUCKET_SORT)/50    / (size >= 10000 ? 1e3 : 1) + (size >= 1e4 ? " us" : " ns"),
                    timestampRatio_.get(SortType.RADIX_SORT)/50     / (size >= 10000 ? 1e3 : 1) + (size >= 1e4 ? " us" : " ns")
            );
            //Runs garbage collector
            //System.gc();
        });
        factory.close();
        
        long afterUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("Program used " + (afterUsedMem-beforeUsedMem)/1e6 + "MB");
    }
}