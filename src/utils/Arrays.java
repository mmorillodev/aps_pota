package utils;

public class Arrays {

    public static void bubbleSort(int[] arr) {
        for(int i = 1; i <= arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1])
                    swap(arr, j, j + 1);
            }
        }
    }

    public static void selectionSort(int[] arr) {
        int current_min;

        for(int i = 0; i < arr.length; i++) {
            for (int j = current_min = i; j < arr.length; j++) {
                if (arr[j] < arr[current_min])
                    current_min = j;
            }
            swap(arr, i, current_min);
        }
    }

    public static void insertionSort(int[] arr) {
        for(int i = 1; i < arr.length; i++) {
            for(int j = i - 1, k = i; j >= 0 && arr[k] < arr[j]; j--, k--) {
                swap(arr, k, j);
            }
        }
    }

    public static void mergeSort(int[] arr) {

    }

    public static void heapSort(int[] arr) {

    }

    public static void quickSort(int[] arr) {

    }

    public static void countSort(int[] arr) {

    }

    public static void bucketSort(int[] arr) {

    }

    public static void radixSort(int[] arr) {

    }

    public static int[] getIntArray(int length) {
        int[] arr = new int[length];

        for(int i = 0; i < length; i++) {
            arr[i] = getRandom(0, 1000);
        }

        return arr;
    }

    public static boolean areEquals(int[] arr1, int[] arr2) {
        if(arr1 == arr2)
            return true;

        if(arr1.length != arr2.length)
            return false;

        for(int i = 0; i < arr1.length; i++) {
            if(arr1[i] != arr2[i])
                return false;
        }

        return true;
    }

    private static void swap(int[] arr, int p1, int p2) {
        if(p1 == p2) return;

        int aux = arr[p1];
        arr[p1] = arr[p2];
        arr[p2] = aux;
    }

    private static int getRandom(int min, int max) {
        return (int) (Math.random()*(max - min)) + min;
    }
}
