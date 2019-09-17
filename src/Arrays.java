public class Arrays {

    static void bubbleSort(int[] arr) {
        for(int i = 1; i <= arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1])
                    swap(arr, j, j + 1);
            }
        }
    }

    static void selectionSort(int[] arr) {
        int current_min;

        for(int i = 0; i < arr.length; i++) {
            current_min = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[current_min])
                    current_min = j;
            }
            swap(arr, i, current_min);
        }
    }

    static void insertionSort(int[] arr) {
        for(int i = 1; i < arr.length; i++) {
            for(int j = i - 1; j >= 0; j--) {
                if(arr[i] < arr[j]) {
                    swap(arr, i, j);
                    i--;
                }
            }
        }
    }

    static void heapSort(int[] arr) {

    }

    static void mergeSort(int[] arr) {

    }

    static void quickSort(int[] arr) {

    }

    static void countSort(int[] arr) {

    }

    static void bucketSort(int[] arr) {

    }

    static void radixSort(int[] arr) {

    }

    static int[] getIntArray(int length) {
        int[] arr = new int[length];

        for(int i = 0; i < length; i++) {
            arr[i] = getRandom(0, 1000);
        }

        return arr;
    }

    static boolean areEquals(int[] arr1, int[] arr2) {
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
