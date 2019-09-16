public class Arrays {

    public static int[] bubbleSort(int[] arr) {
        return null;
    }

    public static int[] selectionSort(int[] arr) {
        return null;
    }

    public static int[] insertionSort(int[] arr) {
        return null;
    }

    public static int[] mergeSort(int[] arr) {
        return null;
    }

    public static int[] quickSort(int[] arr) {
        return null;
    }

    public static int[] countSort(int[] arr) {
        return null;
    }

    public static int[] bucketSort(int[] arr) {
        return null;
    }

    public static int[] radixSort(int[] arr) {
        return null;
    }

    public static int[] getIntArray(int length) {
        int[] arr = new int[length];

        for(int i = 0; i < length; i++) {
            arr[i] = getRandom(0, 1000);
        }

        return arr;
    }

    private static int getRandom(int min, int max) {
        return (int) (Math.random()*(max - min)) + min;
    }
}
