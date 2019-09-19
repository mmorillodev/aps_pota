public class Main {

    private static final CSVFactory factory;
    private static final int TESTS_QTD;

    static {
        factory = new CSVFactory(System.getProperty("user.dir") + "\\reports\\arraysTest5.csv");
        factory.setHeaders("test_id", "array_size", "sort_method", "timestamp");
        factory.printTrace(false);

        TESTS_QTD = 50;
    }

    public static void main(String[] args) {


        //TEST ARRAY SIZE 5
        testSortMethods(5);
        //TEST ARRAY SIZE 50
        factory.newFile(System.getProperty("user.dir") + "\\reports\\arraysTest50.csv");
        testSortMethods(50);
        //TEST ARRAY SIZE 100
        factory.newFile(System.getProperty("user.dir") + "\\reports\\arraysTest100.csv");
        testSortMethods(100);
        //TEST ARRAY SIZE 1000
        factory.newFile(System.getProperty("user.dir") + "\\reports\\arraysTest1000.csv");
        testSortMethods(1000);
        //TEST ARRAY SIZE 10000
        factory.newFile(System.getProperty("user.dir") + "\\reports\\arraysTest10000.csv");
        testSortMethods(10000);

        factory.close();
    }

    private static void testSortMethods(int length) {
        int[] aux, arr;
        double initial, totalTime;

        double  avgBubble       = 0.0,
                avgSelection    = 0.0,
                avgInsertion    = 0.0,
                avgHeap         = 0.0,
                avgMerge        = 0.0,
                avgQuick        = 0.0,
                avgCount        = 0.0,
                avgBucket       = 0.0,
                avgRadix        = 0.0;

        for(int i = 0, test_id = 0; i < TESTS_QTD; i++, test_id++) {
            arr = Arrays.getIntArray(length);

            aux = new int[length];
            System.arraycopy(arr, 0, aux, 0, arr.length);

            initial = (length < 10000 ? System.nanoTime() : System.currentTimeMillis());
            Arrays.bubbleSort(aux);
            avgBubble += totalTime = (length < 10000 ? System.nanoTime() : System.currentTimeMillis()) - initial;

            factory.addRecord(test_id, length, "bubble_sort", totalTime + (length < 10000 ? " ns" : " ms"));

            //-------------------------------------------------------------

            System.arraycopy(arr, 0, aux, 0, arr.length);

            initial = (length < 10000 ? System.nanoTime() : System.currentTimeMillis());
            Arrays.selectionSort(aux);
            avgSelection += totalTime = (length < 10000 ? System.nanoTime() : System.currentTimeMillis()) - initial;

            factory.addRecord(test_id, length, "selection_sort", totalTime + (length < 10000 ? " ns" : " ms"));

            //-------------------------------------------------------------

            System.arraycopy(arr, 0, aux, 0, arr.length);

            initial = (length < 10000 ? System.nanoTime() : System.currentTimeMillis());
            Arrays.insertionSort(aux);
            avgInsertion += totalTime = (length < 10000 ? System.nanoTime() : System.currentTimeMillis()) - initial;

            factory.addRecord(test_id, length, "insertion_sort", totalTime + (length < 10000 ? " ns" : " ms"));

            //-------------------------------------------------------------

            System.arraycopy(arr, 0, aux, 0, arr.length);

            initial = (length < 10000 ? System.nanoTime() : System.currentTimeMillis());
            Arrays.heapSort(aux);
            avgHeap += totalTime = (length < 10000 ? System.nanoTime() : System.currentTimeMillis()) - initial;

            factory.addRecord(test_id, length, "heap_sort", totalTime + (length < 10000 ? " ns" : " ms"));

            //-------------------------------------------------------------

            System.arraycopy(arr, 0, aux, 0, arr.length);

            initial = (length < 10000 ? System.nanoTime() : System.currentTimeMillis());
            Arrays.mergeSort(aux);
            avgMerge += totalTime = initial - (length < 10000 ? System.nanoTime() : System.currentTimeMillis());

            factory.addRecord(test_id, length, "merge_sort", totalTime + (length < 10000 ? " ns" : " ms"));

            //-------------------------------------------------------------

            System.arraycopy(arr, 0, aux, 0, arr.length);

            initial = (length < 10000 ? System.nanoTime() : System.currentTimeMillis());
            Arrays.quickSort(aux);
            avgQuick += totalTime = (length < 10000 ? System.nanoTime() : System.currentTimeMillis()) - initial;

            factory.addRecord(test_id, length, "quick_sort", totalTime + (length < 10000 ? " ns" : " ms"));

            //-------------------------------------------------------------

            System.arraycopy(arr, 0, aux, 0, arr.length);

            initial = (length < 10000 ? System.nanoTime() : System.currentTimeMillis());
            Arrays.countSort(aux);
            avgCount += totalTime = (length < 10000 ? System.nanoTime() : System.currentTimeMillis()) - initial;

            factory.addRecord(test_id, length, "count_sort", totalTime + (length < 10000 ? " ns" : " ms"));

            //-------------------------------------------------------------

            System.arraycopy(arr, 0, aux, 0, arr.length);

            initial = (length < 10000 ? System.nanoTime() : System.currentTimeMillis());
            Arrays.bucketSort(aux);
            avgBucket += totalTime = (length < 10000 ? System.nanoTime() : System.currentTimeMillis()) - initial;

            factory.addRecord(test_id, length, "bucket_sort", totalTime + (length < 10000 ? " ns" : " ms"));

            //-------------------------------------------------------------

            System.arraycopy(arr, 0, aux, 0, arr.length);

            initial = (length < 10000 ? System.nanoTime() : System.currentTimeMillis());;
            Arrays.radixSort(aux);
            avgRadix += totalTime = (length < 10000 ? System.nanoTime() : System.currentTimeMillis()) - initial;

            factory.addRecord(test_id, length, "radix_sort", totalTime + (length < 10000 ? " ns" : " ms"));
        }

        factory.flush();

        //Write the average values to new File
        factory.newFile(System.getProperty("user.dir") + "\\reports\\arrays_tests_" + length + "_Average.csv");
        factory.addRecord(1, length, "bubble_sort",      avgBubble/TESTS_QTD       + (length < 10000 ? " ns" : " ms"));
        factory.addRecord(1, length, "selection_sort",   avgSelection/TESTS_QTD    + (length < 10000 ? " ns" : " ms"));
        factory.addRecord(1, length, "insertion_sort",   avgInsertion/TESTS_QTD    + (length < 10000 ? " ns" : " ms"));
        factory.addRecord(1, length, "heap_sort",        avgHeap/TESTS_QTD         + (length < 10000 ? " ns" : " ms"));
        factory.addRecord(1, length, "merge_sort",       avgMerge/TESTS_QTD        + (length < 10000 ? " ns" : " ms"));
        factory.addRecord(1, length, "quick_sort",       avgQuick/TESTS_QTD        + (length < 10000 ? " ns" : " ms"));
        factory.addRecord(1, length, "count_sort",       avgCount/TESTS_QTD        + (length < 10000 ? " ns" : " ms"));
        factory.addRecord(1, length, "bucket_sort",      avgBucket/TESTS_QTD       + (length < 10000 ? " ns" : " ms"));
        factory.addRecord(1, length, "radix_sort",       avgRadix/TESTS_QTD        + (length < 10000 ? " ns" : " ms"));
    }
}
