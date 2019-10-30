package resources;

public class R {
    public static final class string {
        public final static String HTML_TEMPLATE_ADDRESS;
        public final static String REPORTS_FOLDER_ADDRESS;

        static {
            HTML_TEMPLATE_ADDRESS = System.getProperty("user.dir") + "/templates/general_vision.html";
            REPORTS_FOLDER_ADDRESS = System.getProperty("user.dir") + "/reports";
        }
    }

    public static final class value {
        public final static String[] CSV_HEADERS = {
                "Test size",
                "BUBBLE_SORT",
                "SELECTION_SORT",
                "INSERTION_SORT",
                "MERGE_SORT",
                "HEAP_SORT",
                "QUICK_SORT",
                "COUNT_SORT",
                "BUCKET_SORT",
                "RADIX_SORT"
        };
        public final static int QTD_TESTS = 50;
    }
}
