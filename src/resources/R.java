package resources;

public class R {
    public static final class string {
        public final static String GENERAL_VISION_TEMPLATE_ADDRESS;
        public final static String REPORTS_FOLDER_ADDRESS;
        public final static String SORT_PERSPECTIVE_TEMPLATE_ADDRESS;

        static {
            GENERAL_VISION_TEMPLATE_ADDRESS = System.getProperty("user.dir") + "/templates/general_vision.html";
            SORT_PERSPECTIVE_TEMPLATE_ADDRESS = System.getProperty("user.dir") + "/templates/sort_perspective.html";
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
