package helper;

import java.util.ArrayList;
import java.util.List;

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
        mergeSort(arr, arr.length);
    }

    private static void mergeSort(int[] arr, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = arr[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = arr[i];
        }

        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(arr, l, r, mid, n - mid);
    }

    private static void merge(int[] a, int[] l, int[] r, int left, int right) {
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }

    public static void heapSort(int[] arr) {
        int arrSize = arr.length;

        for (int i = arrSize / 2 - 1; i >= 0; i--)
            heapify(arr, arrSize, i);

        for (int i = arrSize - 1; i >= 0; i--) {
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }
    }

    private static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest])
            largest = left;

        if (right < n && arr[right] > arr[largest])
            largest = right;

        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, n, largest);
        }
    }

    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length-1);
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int pivot = split(arr, start, end);
            quickSort(arr, start, pivot - 1);
            quickSort(arr, pivot + 1, end);
        }
    }

    private static int split(int[] arr, int start, int end) {
        int pivot = arr[start];
        int i, j;
        for (i = start + 1, j = end; i <= j; ) {
            if (arr[i] <= pivot)
                i++;
            else if (pivot < arr[j])
                j--;
            else
                swap(arr, i++, j--);
        }
        swap(arr, start, j);
        return j;
    }

    public static void countSort(int[] arr) {
        int max = getMax(arr);
        int min = getMin(arr);
        int range = max - min + 1;
        int[] count = new int[range];
        int[] output = new int[arr.length];

        for (int value : arr) {
            count[value - min]++;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }

        System.arraycopy(output, 0, arr, 0, arr.length);
    }

    public static void bucketSort(int[] arr) {
        //Verify input
        if (arr == null || arr.length == 0)
            return;

        //Find the maximum and minimum values in the array
        int maxValue = getMax(arr); //start with first element
        int minValue = getMin(arr);

        //Create a temporary bucket
        List<Integer>[] bucket = new List[maxValue - minValue + 1];

        //Initialize the bucket
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new ArrayList<>();
        }

        //Move items to bucket
        for (int value : arr) {
            bucket[value - minValue].add(value);
        }

        //Move items in the bucket back to the original array in order
        int k = 0; //index for original array
        for (List<Integer> bucketValues : bucket) {
            if (bucketValues.size() > 0) {
                for (Integer bucketValue : bucketValues) {
                    arr[k] = bucketValue;
                    k++;
                }
            }
        }
    }

    public static void radixSort(int[] arr) {
        int max = getMax(arr);
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort(arr, arr.length, exp);
        }
    }

    //This is a modified version of Counting Sort
    private static void countSort(int[] array, int length, int exponent) {
        //Create a new "output" array
        int[] output = new int[length]; // output array
        int i;

        //Create a new "counting" array which stores the count of each unique number
        int[] count = new int[10];
        for (i = 0; i < 10; i++) {
            count[i] = 0;
        }
        for (i = 0; i < length; i++) {
            count[(array[i] / exponent) % 10]++;
        }

        //Change count[i] so that count[i] now contains actual position of
        //this character in the output array.
        for (i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        //Build the output array.
        //This is the tricky part.
        for (i = length - 1; i >= 0; i--) {
            output[count[(array[i] / exponent) % 10] - 1] = array[i];
            count[(array[i] / exponent) % 10]--;
        }

        //Copy the output array to the final array.
        for (i = 0; i < length; i++) {
            array[i] = output[i];
        }
    }

    public static int[] getIntArray(int length) {
        int[] arr = new int[length];

        for(int i = 0; i < length; i++) {
            arr[i] = getRandom(0, length);
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

    private static int getMax(int[] arr) {
        int max = arr[0];

        for(int i = 1; i < arr.length; i++) {
            if(arr[i] > max)
                max = arr[i];
        }

        return max;
    }

    private static int getMin(int[] arr) {
        int min = arr[0];

        for(int i = 1; i < arr.length; i++) {
            if(arr[i] < min)
                min = arr[i];
        }

        return min;
    }

    private static void swap(int[] arr, int p1, int p2) {
        int aux = arr[p1];
        arr[p1] = arr[p2];
        arr[p2] = aux;
    }

    private static int getRandom(int min, int max) {
        return (int) (Math.random()*(max - min)) + min;
    }
}
