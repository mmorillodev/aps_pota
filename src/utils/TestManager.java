package utils;

import static java.lang.System.arraycopy;
import java.util.HashMap;
import java.util.Map;

public class TestManager {

    private Map<SortType, Double> sortTypeToTimestamp;
    private int[] arr;

    public TestManager(int arrSize) {
        this.arr = Arrays.getIntArray(arrSize);
        sortTypeToTimestamp = new HashMap<>();
    }

    public void trigger() {
        double  timestampBubble,
                timestampSelection,
                timestampInsertion,
                timestampHeap,
                timestampMerge,
                timestampQuick,
                timestampCount,
                timestampBucket,
                timestampRadix;

        StopWatch stopWatch = new StopWatch();

        int[] aux = new int[arr.length];
        copyArrTo(aux);

        stopWatch.start();
        Arrays.bubbleSort(aux);
        stopWatch.stop();

        timestampBubble = stopWatch.getResultant(false);

        //-------------------------------------------------------------

        copyArrTo(aux);

        stopWatch.start();
        Arrays.selectionSort(aux);
        stopWatch.stop();

        timestampSelection = stopWatch.getResultant(false);

        //-------------------------------------------------------------

        copyArrTo(aux);

        stopWatch.start();
        Arrays.insertionSort(aux);
        stopWatch.stop();

        timestampInsertion = stopWatch.getResultant(false);

        //-------------------------------------------------------------

        copyArrTo(aux);

        stopWatch.start();
        Arrays.heapSort(aux);
        stopWatch.stop();

        timestampHeap = stopWatch.getResultant(false);

        //-------------------------------------------------------------

        copyArrTo(aux);

        stopWatch.start();
        Arrays.mergeSort(aux);
        stopWatch.stop();

        timestampMerge = stopWatch.getResultant(false);

        //-------------------------------------------------------------

        copyArrTo(aux);

        stopWatch.start();
        Arrays.quickSort(aux);
        stopWatch.stop();

        timestampQuick = stopWatch.getResultant(false);

        //-------------------------------------------------------------

        copyArrTo(aux);

        stopWatch.start();
        Arrays.countSort(aux);
        stopWatch.stop();

        timestampCount = stopWatch.getResultant(false);

        //-------------------------------------------------------------

        copyArrTo(aux);

        stopWatch.start();
        Arrays.bucketSort(aux);
        stopWatch.stop();

        timestampBucket = stopWatch.getResultant(false);

        //-------------------------------------------------------------

        copyArrTo(aux);

        stopWatch.start();
        Arrays.radixSort(aux);
        stopWatch.stop();

        timestampRadix = stopWatch.getResultant(false);

        this.sortTypeToTimestamp.put(SortType.BUBBLE_SORT,      timestampBubble);
        this.sortTypeToTimestamp.put(SortType.SELECTION_SORT,   timestampSelection);
        this.sortTypeToTimestamp.put(SortType.INSERTION_SORT,   timestampInsertion);
        this.sortTypeToTimestamp.put(SortType.MERGE_SORT,       timestampMerge);
        this.sortTypeToTimestamp.put(SortType.HEAP_SORT,        timestampHeap);
        this.sortTypeToTimestamp.put(SortType.QUICK_SORT,       timestampQuick);
        this.sortTypeToTimestamp.put(SortType.COUNT_SORT,       timestampCount);
        this.sortTypeToTimestamp.put(SortType.BUCKET_SORT,      timestampBucket);
        this.sortTypeToTimestamp.put(SortType.RADIX_SORT,       timestampRadix);
    }

    private void copyArrTo(int[] to) {
        arraycopy(arr, 0, to, 0, arr.length);
    }

    public Map<SortType, Double> getTimestampRatio() {
        return sortTypeToTimestamp;
    }

    public int size() {
        return arr.length;
    }

    public String toString() {
        return sortTypeToTimestamp.toString();
    }
}