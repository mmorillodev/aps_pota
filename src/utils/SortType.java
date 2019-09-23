package utils;

public enum SortType {
    SELECTION_SORT("Selection"),
    INSERTION_SORT("Insertion"),
    BUCKET_SORT("Bucket"),
    BUBBLE_SORT("Bubble"),
    QUICK_SORT("Quick"),
    COUNT_SORT("Count"),
    MERGE_SORT("Merge"),
    RADIX_SORT("Radix"),
    HEAP_SORT("Heap");

    private String type;

    SortType(String type) {
        this.type = type;
    }

    public String toString() {
        return type;
    }
}