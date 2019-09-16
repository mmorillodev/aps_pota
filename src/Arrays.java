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

    private static int getRandom(int min, int max) {
        return (int) (Math.random()*(max - min)) + min;
    }
}
