package utils;

import java.util.HashMap;
import java.util.Map;

public class TestManager {

    private Map<SortType, Double> sortTypeToTimestamp;
    private int[] arr;

    public TestManager(int size) {
        arr = Arrays.getIntArray(size);
        sortTypeToTimestamp = new HashMap<>();

        trigger();
    }

    public void trigger() {
        StopWatch stopWatch = new StopWatch();
        int[] aux;

        double  avgBubble       = 0.0,
                avgSelection    = 0.0,
                avgInsertion    = 0.0,
                avgHeap         = 0.0,
                avgMerge        = 0.0,
                avgQuick        = 0.0,
                avgCount        = 0.0,
                avgBucket       = 0.0,
                avgRadix        = 0.0;

        for(int i = 0; i < 50; i++) {
            aux = new int[arr.length];
            System.arraycopy(arr, 0, aux, 0, arr.length);

            stopWatch.start();
            Arrays.bubbleSort(aux);
            stopWatch.stop();

            avgBubble += stopWatch.getResultant(false);

            //-------------------------------------------------------------

            System.arraycopy(arr, 0, aux, 0, arr.length);

            stopWatch.start();
            Arrays.selectionSort(aux);
            stopWatch.stop();

            avgSelection += stopWatch.getResultant(false);

            //-------------------------------------------------------------

            System.arraycopy(arr, 0, aux, 0, arr.length);

            stopWatch.start();
            Arrays.insertionSort(aux);
            stopWatch.stop();

            avgInsertion += stopWatch.getResultant(false);

            //-------------------------------------------------------------

            System.arraycopy(arr, 0, aux, 0, arr.length);

            stopWatch.start();
            Arrays.heapSort(aux);
            stopWatch.stop();

            avgHeap += stopWatch.getResultant(false);

            //-------------------------------------------------------------

            System.arraycopy(arr, 0, aux, 0, arr.length);

            stopWatch.start();
            Arrays.mergeSort(aux);
            stopWatch.stop();

            avgMerge += stopWatch.getResultant(false);

            //-------------------------------------------------------------

            System.arraycopy(arr, 0, aux, 0, arr.length);

            stopWatch.start();
            Arrays.quickSort(aux);
            stopWatch.stop();

            avgQuick += stopWatch.getResultant(false);

            //-------------------------------------------------------------

            System.arraycopy(arr, 0, aux, 0, arr.length);

            stopWatch.start();
            Arrays.countSort(aux);
            stopWatch.stop();

            avgCount += stopWatch.getResultant(false);

            //-------------------------------------------------------------

            System.arraycopy(arr, 0, aux, 0, arr.length);

            stopWatch.start();
            Arrays.bucketSort(aux);
            stopWatch.stop();

            avgBucket += stopWatch.getResultant(false);

            //-------------------------------------------------------------

            System.arraycopy(arr, 0, aux, 0, arr.length);

            stopWatch.start();
            Arrays.radixSort(aux);
            stopWatch.stop();

            avgRadix += stopWatch.getResultant(false);
        }

        this.sortTypeToTimestamp.put(SortType.BUBBLE_SORT,      avgBubble/50);
        this.sortTypeToTimestamp.put(SortType.SELECTION_SORT,   avgSelection/50);
        this.sortTypeToTimestamp.put(SortType.INSERTION_SORT,   avgInsertion/50);
        this.sortTypeToTimestamp.put(SortType.MERGE_SORT,       avgMerge/50);
        this.sortTypeToTimestamp.put(SortType.QUICK_SORT,       avgQuick/50);
        this.sortTypeToTimestamp.put(SortType.HEAP_SORT,        avgHeap/50);
        this.sortTypeToTimestamp.put(SortType.BUCKET_SORT,      avgBucket/50);
        this.sortTypeToTimestamp.put(SortType.RADIX_SORT,       avgRadix/50);
        this.sortTypeToTimestamp.put(SortType.COUNT_SORT,       avgCount/50);
    }

    public Map<SortType, Double> getTimestampRatio() {
        return sortTypeToTimestamp;
    }

    public int size() {
        return arr.length;
    }
}