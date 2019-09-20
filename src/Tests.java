public class Tests {
    public static void main(String[] args) {
//        StopWatch stopWatch = new StopWatch();
        int[] arr = {9, 5, 4, 1, 8, 3, 2, 7, 6};
        int[] correctArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] arr1, arr2, arr3, arr4, arr5, arr6, arr7, arr8, arr9;
        String errorMsg = "";

        Arrays.bubbleSort((arr1 = arr.clone()));
        Arrays.selectionSort(arr2 = arr.clone());
        Arrays.insertionSort(arr3 = arr.clone());
        Arrays.heapSort(arr9 = arr.clone());
        Arrays.mergeSort(arr4 = arr.clone());
        Arrays.quickSort(arr5 = arr.clone());
        Arrays.countSort(arr6 = arr.clone());
        Arrays.bucketSort(arr7 = arr.clone());
        Arrays.radixSort(arr8 = arr.clone());

        if(!Arrays.areEquals(arr1, correctArray)) {
            errorMsg += "Bubble";
        }
        if(!Arrays.areEquals(arr2, correctArray)) {
            errorMsg += (errorMsg.length() > 0 ? ", " : "") + "Selection";
        }
        if(!Arrays.areEquals(arr3, correctArray)) {
            errorMsg += (errorMsg.length() > 0 ? ", " : "") + "Insertion";
        }
        if(!Arrays.areEquals(arr4, correctArray)) {
            errorMsg += (errorMsg.length() > 0 ? ", " : "") + "Merge";
        }
        if(!Arrays.areEquals(arr5, correctArray)) {
            errorMsg += (errorMsg.length() > 0 ? ", " : "") + "Quick";
        }
        if(!Arrays.areEquals(arr6, correctArray)) {
            errorMsg += (errorMsg.length() > 0 ? ", " : "") + "Count";
        }
        if(!Arrays.areEquals(arr7, correctArray)) {
            errorMsg += (errorMsg.length() > 0 ? ", " : "") + "Bucket";
        }
        if(!Arrays.areEquals(arr8, correctArray)) {
            errorMsg += (errorMsg.length() > 0 ? ", " : "") + "Radix";
        }
        if(!Arrays.areEquals(arr9, correctArray)) {
            errorMsg += (errorMsg.length() > 0 ? ", " : "") + "Heap";
        }

        if(errorMsg.length() > 0) {
            throw new SortException("Invalid sort methods: " + errorMsg);
        }


        System.out.println("bubble:\t\t"        + java.util.Arrays.toString(arr1));
        System.out.println("selection:\t"       + java.util.Arrays.toString(arr2));
        System.out.println("insertion:\t"       + java.util.Arrays.toString(arr3));
        System.out.println("heap:\t\t"          + java.util.Arrays.toString(arr9));
        System.out.println("merge:\t\t"         + java.util.Arrays.toString(arr4));
        System.out.println("quick:\t\t"         + java.util.Arrays.toString(arr5));
        System.out.println("count:\t\t"         + java.util.Arrays.toString(arr6));
        System.out.println("bucket:\t\t"        + java.util.Arrays.toString(arr7));
        System.out.println("radix:\t\t"         + java.util.Arrays.toString(arr8));
    }

    private static class SortException extends RuntimeException {

        public SortException(String message) {
            super(message);
        }
    }
}
