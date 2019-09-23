import utils.CSVFactory;
import utils.SortType;
import utils.TestManager;

import java.util.Map;

public class Main {

    private static final CSVFactory factory;

    static {
        factory = new CSVFactory(System.getProperty("user.dir") + "\\reports\\report.csv");
        factory.setHeaders("Test size", "Bubble", "Selection", "Insertion", "Merge", "Heap", "Quick", "Count", "Bucket", "Radix");
    }

    public static void main(String[] args) {
        TestManager[] tests = new TestManager[5];

        //TEST ARRAY SIZE 5
        tests[0] = new TestManager(5);

        //TEST ARRAY SIZE 50
        tests[1] = new TestManager(50);

        //TEST ARRAY SIZE 100
        tests[2] = new TestManager(100);

        //TEST ARRAY SIZE 1000
        tests[3] = new TestManager(1000);

        //TEST ARRAY SIZE 10000
        tests[4] = new TestManager(10000);

        Map<SortType, Double> helper;
        Object[] line = new Object[10];

        for(TestManager manager : tests) {
            helper = manager.getTimestampRatio();

            line[0] = manager.size();
            line[1] = helper.get(SortType.BUBBLE_SORT);
            line[2] = helper.get(SortType.SELECTION_SORT);
            line[3] = helper.get(SortType.INSERTION_SORT);
            line[4] = helper.get(SortType.MERGE_SORT);
            line[5] = helper.get(SortType.HEAP_SORT);
            line[6] = helper.get(SortType.QUICK_SORT);
            line[7] = helper.get(SortType.COUNT_SORT);
            line[8] = helper.get(SortType.BUCKET_SORT);
            line[9] = helper.get(SortType.RADIX_SORT);

            factory.addRecord(line);
        }

        factory.close();
    }
}
