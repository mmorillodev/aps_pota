public class Arrays {

    public int[] bubbleSort(int[] arr) {
        return null;
    }

    public int[] selectionSort(int[] arr) {
        return null;
    }

    public int[] insertionSort(int[] arr) {
        return null;
    }

    public int[] mergeSort(int[] arr) {
        return null;
    }

    public int[] quickSort(int[] arr) {
        return null;
    }

    public int[] countSort(int[] arr) {
        return null;
    }

    public int[] bucketSort(int[] arr) {
        return null;
    }

    public int[] radixSort(int[] arr) {
        return null;
    }

    public int[] getIntArray(int length) {
        int[] arr = new int[length];

        for(int i = 0; i < length; i++) {
            arr[i] = getRandom(0, 100);
        }

        return arr;
    }

    private int getRandom(int min, int max) {
        return (int) (Math.random()*(max - min)) + min;
    }
}
