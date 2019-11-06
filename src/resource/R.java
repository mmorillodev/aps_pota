package resource;

public class R {
    public static final class string {
        public static final String REPORTS_FOLDER_ADDRESS;

        static {
            REPORTS_FOLDER_ADDRESS = System.getProperty("user.dir") + "/reports";
        }
    }

    public static final class template {
        public final static String GENERAL_VISION;
        public final static String SORT_PERSPECTIVE;
        public static final String DIRECT_SORT_COMPARISON;

        static {
            GENERAL_VISION = System.getProperty("user.dir") + "/templates/general_vision.html";
            SORT_PERSPECTIVE = System.getProperty("user.dir") + "/templates/sort_perspective.html";
            DIRECT_SORT_COMPARISON = System.getProperty("user.dir") + "/templates/direct_sort_comparison.html";
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
