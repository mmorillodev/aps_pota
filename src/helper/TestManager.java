package helper;

import resource.SortType;

import static java.lang.System.arraycopy;
import java.util.HashMap;
import java.util.Map;

public class TestManager {

    private Map<SortType, Long> sortTypeToTimestamp;
    private int arrSize;

    public TestManager(int arrSize) {
        this.arrSize = arrSize;
        sortTypeToTimestamp = new HashMap<>();
    }

    public void trigger() {
        long  timestampBubble,
                timestampSelection,
                timestampInsertion,
                timestampHeap,
                timestampMerge,
                timestampQuick,
                timestampCount,
                timestampBucket,
                timestampRadix;

        StopWatch stopWatch = new StopWatch();
        
        int[] arr = Arrays.getIntArray(this.arrSize);

        stopWatch.start();
        Arrays.bubbleSort(copyArr(arr));
        stopWatch.stop();

        timestampBubble = stopWatch.getResultantNano();

        //-------------------------------------------------------------

        stopWatch.start();
        Arrays.selectionSort(copyArr(arr));
        stopWatch.stop();

        timestampSelection = stopWatch.getResultantNano();

        //-------------------------------------------------------------

        stopWatch.start();
        Arrays.insertionSort(copyArr(arr));
        stopWatch.stop();

        timestampInsertion = stopWatch.getResultantNano();

        //-------------------------------------------------------------

        stopWatch.start();
        Arrays.heapSort(copyArr(arr));
        stopWatch.stop();

        timestampHeap = stopWatch.getResultantNano();

        //-------------------------------------------------------------

        stopWatch.start();
        Arrays.mergeSort(copyArr(arr));
        stopWatch.stop();

        timestampMerge = stopWatch.getResultantNano();

        //-------------------------------------------------------------

        stopWatch.start();
        Arrays.quickSort(copyArr(arr));
        stopWatch.stop();

        timestampQuick = stopWatch.getResultantNano();

        //-------------------------------------------------------------

        stopWatch.start();
        Arrays.countSort(copyArr(arr));
        stopWatch.stop();

        timestampCount = stopWatch.getResultantNano();

        //-------------------------------------------------------------

        stopWatch.start();
        Arrays.bucketSort(copyArr(arr));
        stopWatch.stop();

        timestampBucket = stopWatch.getResultantNano();

        //-------------------------------------------------------------

        stopWatch.start();
        Arrays.radixSort(copyArr(arr));
        stopWatch.stop();

        timestampRadix = stopWatch.getResultantNano();

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

    private int[] copyArr(int[] from) {
        int[] to = new int[from.length];

        arraycopy(from, 0, to, 0, from.length);
        
        return to;
    }

    public Map<SortType, Long> getTimestampRatio() {
        return sortTypeToTimestamp;
    }

    public int size() {
        return arrSize;
    }

    public String toString() {
        return sortTypeToTimestamp.toString();
    }
}