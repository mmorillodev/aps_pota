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
            add(10500);
        }};
        final int QTD_TESTS = 50;

        List<TestManager> current;
        Map<Integer, List<TestManager>> sizeToManager = new LinkedHashMap<>();

        for(int currentSize : sizesToTests) {
            sizeToManager.put(currentSize, current = new ArrayList<>(QTD_TESTS));
            for(int i = 0; i < QTD_TESTS; i++) {
                current.add(new TestManager(currentSize));
            }
        }

        sizeToManager.values().forEach(managers -> {
            factory.addRecord(
                    managers.get(0).size(),
                    (managers.stream().mapToDouble(manager -> manager.getTimestampRatio().get(SortType.BUBBLE_SORT)).sum()
                            / QTD_TESTS) / (managers.get(0).size() >= 10000 ? 1e3 : 1) + (managers.get(0).size() >= 1e3 ? " us" : " ns"),
                    (managers.stream().mapToDouble(manager -> manager.getTimestampRatio().get(SortType.SELECTION_SORT)).sum()
                            / QTD_TESTS) / (managers.get(0).size() >= 10000 ? 1e3 : 1) + (managers.get(0).size() >= 1e3 ? " us" : " ns"),
                    (managers.stream().mapToDouble(manager -> manager.getTimestampRatio().get(SortType.INSERTION_SORT)).sum()
                            / QTD_TESTS) / (managers.get(0).size() >= 10000 ? 1e3 : 1) + (managers.get(0).size() >= 1e3 ? " us" : " ns"),
                    (managers.stream().mapToDouble(manager -> manager.getTimestampRatio().get(SortType.MERGE_SORT)).sum()
                            / QTD_TESTS) / (managers.get(0).size() >= 10000 ? 1e3 : 1) + (managers.get(0).size() >= 1e3 ? " us" : " ns"),
                    (managers.stream().mapToDouble(manager -> manager.getTimestampRatio().get(SortType.HEAP_SORT)).sum()
                            / QTD_TESTS) / (managers.get(0).size() >= 10000 ? 1e3 : 1) + (managers.get(0).size() >= 1e3 ? " us" : " ns"),
                    (managers.stream().mapToDouble(manager -> manager.getTimestampRatio().get(SortType.QUICK_SORT)).sum()
                            / QTD_TESTS) / (managers.get(0).size() >= 10000 ? 1e3 : 1) + (managers.get(0).size() >= 1e3 ? " us" : " ns"),
                    (managers.stream().mapToDouble(manager -> manager.getTimestampRatio().get(SortType.COUNT_SORT)).sum()
                            / QTD_TESTS) / (managers.get(0).size() >= 10000 ? 1e3 : 1) + (managers.get(0).size() >= 1e3 ? " us" : " ns"),
                    (managers.stream().mapToDouble(manager -> manager.getTimestampRatio().get(SortType.BUCKET_SORT)).sum()
                            / QTD_TESTS) / (managers.get(0).size() >= 10000 ? 1e3 : 1) + (managers.get(0).size() >= 1e3 ? " us" : " ns"),
                    (managers.stream().mapToDouble(manager -> manager.getTimestampRatio().get(SortType.RADIX_SORT)).sum()
                            / QTD_TESTS) / (managers.get(0).size() >= 10000 ? 1e3 : 1) + (managers.get(0).size() >= 1e3 ? " us" : " ns")
            );
            managers.clear();
            managers = null;
            //Runs garbage collector
            System.gc();
        });
        factory.close();
        
        long afterUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("Program used " + (afterUsedMem-beforeUsedMem)/1e6 + "MB");
    }
}