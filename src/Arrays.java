public class Arrays {

    static int[] bubbleSort(int[] arr) {
        for(int i = 1; i <= arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1])
                    swap(arr, j, j + 1);
            }
        }
        return arr;
    }

    static int[] selectionSort(int[] arr) {
        int current_min = 0;

        for(int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[current_min])
                    current_min = j;
            }
            swap(arr, i, current_min);
        }

        return arr;
    }

    static int[] insertionSort(int[] arr) {
        return arr;
    }

    static int[] mergeSort(int[] arr) {
        return arr;
    }

    static int[] quickSort(int[] arr) {
        return arr;
    }

    static int[] countSort(int[] arr) {
        return arr;
    }

    static int[] bucketSort(int[] arr) {
        return arr;
    }

    static int[] radixSort(int[] arr) {
        return arr;
    }

    static int[] getIntArray(int length) {
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
