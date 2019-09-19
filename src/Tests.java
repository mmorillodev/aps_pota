public class Tests {
    public static void main(String[] args) {
//        int[] arr = {9, 5, 4, 1, 8, 3, 2, 7, 6};
//        int[] arr1, arr2, arr3, arr4, arr5, arr6, arr7, arr8, arr9;
//
//        Arrays.bubbleSort((arr1 = arr.clone()));
//        Arrays.selectionSort(arr2 = arr.clone());
//        Arrays.insertionSort(arr3 = arr.clone());
//        Arrays.heapSort(arr9 = arr.clone());
//        Arrays.mergeSort(arr4 = arr.clone());
//        Arrays.quickSort(arr5 = arr.clone());
//        Arrays.countSort(arr6 = arr.clone());
//        Arrays.bucketSort(arr7 = arr.clone());
//        Arrays.radixSort(arr8 = arr.clone());
//
//        System.out.println("bubble:\t\t"        + java.util.Arrays.toString(arr1));
//        System.out.println("selection:\t"       + java.util.Arrays.toString(arr2));
//        System.out.println("insertion:\t"       + java.util.Arrays.toString(arr3));
//        System.out.println("heap:\t\t"          + java.util.Arrays.toString(arr9));
//        System.out.println("merge:\t\t"         + java.util.Arrays.toString(arr4));
//        System.out.println("quick:\t\t"         + java.util.Arrays.toString(arr5));
//        System.out.println("count:\t\t"         + java.util.Arrays.toString(arr6));
//        System.out.println("bucket:\t\t"        + java.util.Arrays.toString(arr7));
//        System.out.println("radix:\t\t"         + java.util.Arrays.toString(arr8));
        int[] bigArr = Arrays.getIntArray(10000);
        Arrays.insertionSort(bigArr);
        System.out.println(java.util.Arrays.toString(bigArr));
    }
}
