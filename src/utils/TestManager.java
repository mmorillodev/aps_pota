package utils;

import java.util.HashMap;
import java.util.Map;

public class TestManager {

    private Map<SortType, Double> sortTypeToTimestamp;
    private int[] arr;

    public TestManager(int arrSize) {
        this.arr = Arrays.getIntArray(arrSize);
        sortTypeToTimestamp = new HashMap<>();

        trigger();
    }

    public void trigger() {
        double avgBubble, avgSelection, avgInsertion, avgHeap, avgMerge, avgQuick,  avgCount, avgBucket, avgRadix;
        int[] aux;

        StopWatch stopWatch = new StopWatch();

        aux = new int[arr.length];
        System.arraycopy(arr, 0, aux, 0, arr.length);

        stopWatch.start();
        Arrays.bubbleSort(aux);
        stopWatch.stop();

        avgBubble = stopWatch.getResultant(false);

        //-------------------------------------------------------------

        System.arraycopy(arr, 0, aux, 0, arr.length);

        stopWatch.start();
        Arrays.selectionSort(aux);
        stopWatch.stop();

        avgSelection = stopWatch.getResultant(false);

        //-------------------------------------------------------------

        System.arraycopy(arr, 0, aux, 0, arr.length);

        stopWatch.start();
        Arrays.insertionSort(aux);
        stopWatch.stop();

        avgInsertion = stopWatch.getResultant(false);

        //-------------------------------------------------------------

        System.arraycopy(arr, 0, aux, 0, arr.length);

        stopWatch.start();
        Arrays.heapSort(aux);
        stopWatch.stop();

        avgHeap = stopWatch.getResultant(false);

        //-------------------------------------------------------------

        System.arraycopy(arr, 0, aux, 0, arr.length);

        stopWatch.start();
        Arrays.mergeSort(aux);
        stopWatch.stop();

        avgMerge = stopWatch.getResultant(false);

        //-------------------------------------------------------------

        System.arraycopy(arr, 0, aux, 0, arr.length);

        stopWatch.start();
        Arrays.quickSort(aux);
        stopWatch.stop();

        avgQuick = stopWatch.getResultant(false);

        //-------------------------------------------------------------

        System.arraycopy(arr, 0, aux, 0, arr.length);

        stopWatch.start();
        Arrays.countSort(aux);
        stopWatch.stop();

        avgCount = stopWatch.getResultant(false);

        //-------------------------------------------------------------

        System.arraycopy(arr, 0, aux, 0, arr.length);

        stopWatch.start();
        Arrays.bucketSort(aux);
        stopWatch.stop();

        avgBucket = stopWatch.getResultant(false);

        //-------------------------------------------------------------

        System.arraycopy(arr, 0, aux, 0, arr.length);

        stopWatch.start();
        Arrays.radixSort(aux);
        stopWatch.stop();

        avgRadix = stopWatch.getResultant(false);

        this.sortTypeToTimestamp.put(SortType.BUBBLE_SORT,      avgBubble);
        this.sortTypeToTimestamp.put(SortType.SELECTION_SORT,   avgSelection);
        this.sortTypeToTimestamp.put(SortType.INSERTION_SORT,   avgInsertion);
        this.sortTypeToTimestamp.put(SortType.MERGE_SORT,       avgMerge);
        this.sortTypeToTimestamp.put(SortType.QUICK_SORT,       avgQuick);
        this.sortTypeToTimestamp.put(SortType.HEAP_SORT,        avgHeap);
        this.sortTypeToTimestamp.put(SortType.BUCKET_SORT,      avgBucket);
        this.sortTypeToTimestamp.put(SortType.RADIX_SORT,       avgRadix);
        this.sortTypeToTimestamp.put(SortType.COUNT_SORT,       avgCount);
    }

    public Map<SortType, Double> getTimestampRatio() {
        return sortTypeToTimestamp;
    }

    public int size() {
        return arr.length;
    }
}