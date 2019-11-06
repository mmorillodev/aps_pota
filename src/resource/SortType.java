package resource;

public enum SortType {
    SELECTION_SORT("SELECTION_SORT"),
    INSERTION_SORT("INSERTION_SORT"),
    BUCKET_SORT("BUCKET_SORT"),
    BUBBLE_SORT("BUBBLE_SORT"),
    QUICK_SORT("QUICK_SORT"),
    COUNT_SORT("COUNT_SORT"),
    MERGE_SORT("MERGE_SORT"),
    RADIX_SORT("RADIX_SORT"),
    HEAP_SORT("HEAP_SORT");

    private String value;

    SortType(String value) {
        this.value = value;
    }

    public static String[] toStringArray() {
        SortType[] sortTypes = values();
        final String[] arr = new String[sortTypes.length];

        for(int i = 0; i < sortTypes.length; i++) {
            arr[i] = sortTypes[i].toString();
        }

        return arr;
    }

    public String toString() {
        return value;
    }
}