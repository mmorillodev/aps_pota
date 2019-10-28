package executable;

import utils.SortType;
import utils.StopWatch;
import utils.io.FileLoader;

import static utils.Arrays.*;
import static java.lang.System.out;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Tests {
    public static void main(String[] args) throws InterruptedException {
        testSorts();
//        testMergeMaps();
//        testFileLoader();
//        testStopWatch();
    }

    public static void testFileLoader() {
        try {
            FileLoader loader = new FileLoader(System.getProperty("user.dir") + "/src/utils/file/template.html");
            out.println(loader.loadAsString());
        } catch (IOException e) {
            out.println(e.getMessage());
        }
    }

    public static void testMergeMaps() {
        Map<Integer, Map<SortType, Double>> sizeToTotalTime = new HashMap<>();
        sizeToTotalTime.put(10000, new HashMap<>());
        sizeToTotalTime.get(10000).put(SortType.BUBBLE_SORT, 10000000.0);
        sizeToTotalTime.get(10000).put(SortType.SELECTION_SORT, 10000000.0);
        sizeToTotalTime.get(10000).put(SortType.INSERTION_SORT, 10000000.0);
        sizeToTotalTime.get(10000).put(SortType.MERGE_SORT, 100000000.0);

        Map<SortType, Double> map2 = new HashMap<>();
        map2.put(SortType.BUBBLE_SORT, 1000.0);
        map2.put(SortType.SELECTION_SORT, 1000.0);
        map2.put(SortType.INSERTION_SORT, 1000.0);
        map2.put(SortType.MERGE_SORT, 1000.0);

        map2.forEach((key, value) -> sizeToTotalTime.get(10000).merge(key, value, Double::sum));

        out.println(sizeToTotalTime.toString());
    }

    public static void testStopWatch() throws InterruptedException {
        StopWatch watch = new StopWatch();

        watch.start();
        Thread.sleep(1000);
        watch.stop();

        out.println(watch.getResultant(true));

        watch.resume();
        Thread.sleep(2000);
        watch.stop();

        out.println(watch.getResultant(true));
    }

    public static void testSorts() {
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
            errorMsg += (errorMsg.length() > 0 ? "\n" : "") + "Selection";
        }
        if(!areEquals(arr3, correctArray)) {
            errorMsg += (errorMsg.length() > 0 ? "\n" : "") + "Insertion";
        }
        if(!areEquals(arr4, correctArray)) {
            errorMsg += (errorMsg.length() > 0 ? "\n" : "") + "Merge";
        }
        if(!areEquals(arr5, correctArray)) {
            errorMsg += (errorMsg.length() > 0 ? "\n" : "") + "Quick";
        }
        if(!areEquals(arr6, correctArray)) {
            errorMsg += (errorMsg.length() > 0 ? "\n" : "") + "Count";
        }
        if(!areEquals(arr7, correctArray)) {
            errorMsg += (errorMsg.length() > 0 ? "\n" : "") + "Bucket";
        }
        if(!areEquals(arr8, correctArray)) {
            errorMsg += (errorMsg.length() > 0 ? "\n" : "") + "Radix";
        }
        if(!areEquals(arr9, correctArray)) {
            errorMsg += (errorMsg.length() > 0 ? "\n" : "") + "Heap";
        }

        out.println("bubble:\t\t"        + Arrays.toString(arr1));
        out.println("selection:\t"       + Arrays.toString(arr2));
        out.println("insertion:\t"       + Arrays.toString(arr3));
        out.println("heap:\t\t"          + Arrays.toString(arr9));
        out.println("merge:\t\t"         + Arrays.toString(arr4));
        out.println("quick:\t\t"         + Arrays.toString(arr5));
        out.println("count:\t\t"         + Arrays.toString(arr6));
        out.println("bucket:\t\t"        + Arrays.toString(arr7));
        out.println("radix:\t\t"         + Arrays.toString(arr8));

        if(errorMsg.length() > 0) {
            System.err.println("Invalid sort methods:\n" + errorMsg);
        }
        else {
            out.println("Everything OK!");
        }
    }
}
