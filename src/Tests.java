import static utils.Arrays.*;
import java.util.Arrays;

public class Tests {
    public static void main(String[] args) {
//        utils.StopWatch stopWatch = new utils.StopWatch();
        int[] arr = getIntArray(10);
        int[] correctArray = arr.clone();
        int[] arr1, arr2, arr3, arr4, arr5, arr6, arr7, arr8, arr9;
        String errorMsg = "";

        Arrays.sort(correctArray);

        bubbleSort((arr1 = arr.clone()));
        selectionSort(arr2 = arr.clone());
        insertionSort(arr3 = arr.clone());
        heapSort(arr9 = arr.clone());
        mergeSort(arr4 = arr.clone());
        quickSort(arr5 = arr.clone());
        countSort(arr6 = arr.clone());
        bucketSort(arr7 = arr.clone());
        radixSort(arr8 = arr.clone());

        if(!areEquals(arr1, correctArray)) {
            errorMsg += "Bubble";
        }
        if(!areEquals(arr2, correctArray)) {
            errorMsg += (errorMsg.length() > 0 ? ", " : "") + "Selection";
        }
        if(!areEquals(arr3, correctArray)) {
            errorMsg += (errorMsg.length() > 0 ? ", " : "") + "Insertion";
        }
        if(!areEquals(arr4, correctArray)) {
            errorMsg += (errorMsg.length() > 0 ? ", " : "") + "Merge";
        }
        if(!areEquals(arr5, correctArray)) {
            errorMsg += (errorMsg.length() > 0 ? ", " : "") + "Quick";
        }
        if(!areEquals(arr6, correctArray)) {
            errorMsg += (errorMsg.length() > 0 ? ", " : "") + "Count";
        }
        if(!areEquals(arr7, correctArray)) {
            errorMsg += (errorMsg.length() > 0 ? ", " : "") + "Bucket";
        }
        if(!areEquals(arr8, correctArray)) {
            errorMsg += (errorMsg.length() > 0 ? ", " : "") + "Radix";
        }
        if(!areEquals(arr9, correctArray)) {
            errorMsg += (errorMsg.length() > 0 ? " and " : "") + "Heap";
        }

        System.out.println("bubble:\t\t"        + Arrays.toString(arr1));
        System.out.println("selection:\t"       + Arrays.toString(arr2));
        System.out.println("insertion:\t"       + Arrays.toString(arr3));
        System.out.println("heap:\t\t"          + Arrays.toString(arr9));
        System.out.println("merge:\t\t"         + Arrays.toString(arr4));
        System.out.println("quick:\t\t"         + Arrays.toString(arr5));
        System.out.println("count:\t\t"         + Arrays.toString(arr6));
        System.out.println("bucket:\t\t"        + Arrays.toString(arr7));
        System.out.println("radix:\t\t"         + Arrays.toString(arr8));

        if(errorMsg.length() > 0) {
            throw new SortException("Invalid sort methods: " + errorMsg);
        }
        else {
            System.out.println("Everything OK!");
        }
    }

    private static class SortException extends RuntimeException {
        SortException(String message) {
            super(message);
        }
    }
}
