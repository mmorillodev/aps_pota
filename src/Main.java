public class Main {

    static final CSVFactory factory;

    static {
        factory = new CSVFactory(System.getProperty("user.dir") + "\\reports\\arraysTest5.csv");
        factory.setHeaders("test_id", "array_size", "sort_method", "timestamp");
        factory.printTrace(false);
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

    static void testSortMethods(int length) {
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

        for(int i = 0, test_id = 0; i < 50; i++, test_id++) {
            arr = Arrays.getIntArray(length);

            aux = new int[length];
            System.arraycopy(arr, 0, aux, 0, arr.length);

            initial = (length < 1000 ? System.nanoTime() : System.currentTimeMillis());
            Arrays.bubbleSort(aux);
            avgBubble += totalTime = (length < 1000 ? System.nanoTime() : System.currentTimeMillis()) - initial;

            factory.addRecord(test_id, length, "bubble_sort", totalTime + (length < 1000 ? " ns" : " ms"));

            //-------------------------------------------------------------

            System.arraycopy(arr, 0, aux, 0, arr.length);

            initial = (length < 1000 ? System.nanoTime() : System.currentTimeMillis());
            Arrays.selectionSort(aux);
            avgSelection += totalTime = (length < 1000 ? System.nanoTime() : System.currentTimeMillis()) - initial;

            factory.addRecord(test_id, length, "selection_sort", totalTime + (length < 1000 ? " ns" : " ms"));

            //-------------------------------------------------------------

            System.arraycopy(arr, 0, aux, 0, arr.length);

            initial = (length < 1000 ? System.nanoTime() : System.currentTimeMillis());
            Arrays.insertionSort(aux);
            avgInsertion += totalTime = (length < 1000 ? System.nanoTime() : System.currentTimeMillis()) - initial;

            factory.addRecord(test_id, length, "insertion_sort", totalTime + (length < 1000 ? " ns" : " ms"));

            //-------------------------------------------------------------

            System.arraycopy(arr, 0, aux, 0, arr.length);

            initial = (length < 1000 ? System.nanoTime() : System.currentTimeMillis());
            Arrays.heapSort(aux);
            avgHeap += totalTime = (length < 1000 ? System.nanoTime() : System.currentTimeMillis()) - initial;

            factory.addRecord(test_id, length, "heap_sort", totalTime + (length < 1000 ? " ns" : " ms"));

            //-------------------------------------------------------------

            System.arraycopy(arr, 0, aux, 0, arr.length);

            initial = (length < 1000 ? System.nanoTime() : System.currentTimeMillis());
            Arrays.mergeSort(aux);
            avgMerge += totalTime = initial - (length < 1000 ? System.nanoTime() : System.currentTimeMillis());

            factory.addRecord(test_id, length, "merge_sort", totalTime + (length < 1000 ? " ns" : " ms"));

            //-------------------------------------------------------------

            System.arraycopy(arr, 0, aux, 0, arr.length);

            initial = (length < 1000 ? System.nanoTime() : System.currentTimeMillis());
            Arrays.quickSort(aux);
            avgQuick += totalTime = (length < 1000 ? System.nanoTime() : System.currentTimeMillis()) - initial;

            factory.addRecord(test_id, length, "quick_sort", totalTime + (length < 1000 ? " ns" : " ms"));

            //-------------------------------------------------------------

            System.arraycopy(arr, 0, aux, 0, arr.length);

            initial = (length < 1000 ? System.nanoTime() : System.currentTimeMillis());
            Arrays.countSort(aux);
            avgCount += totalTime = (length < 1000 ? System.nanoTime() : System.currentTimeMillis()) - initial;

            factory.addRecord(test_id, length, "count_sort", totalTime + (length < 1000 ? " ns" : " ms"));

            //-------------------------------------------------------------

            System.arraycopy(arr, 0, aux, 0, arr.length);

            initial = (length < 1000 ? System.nanoTime() : System.currentTimeMillis());
            Arrays.bucketSort(aux);
            avgBucket += totalTime = (length < 1000 ? System.nanoTime() : System.currentTimeMillis()) - initial;

            factory.addRecord(test_id, length, "bucket_sort", totalTime + (length < 1000 ? " ns" : " ms"));

            //-------------------------------------------------------------

            System.arraycopy(arr, 0, aux, 0, arr.length);

            initial = System.nanoTime();
            Arrays.radixSort(aux);
            avgRadix += totalTime = initial - System.nanoTime();

            factory.addRecord(test_id, length, "radix_sort", totalTime + (length < 1000 ? " ns" : " ms"));
        }

        factory.flush();

        //Write the average values to new File
        factory.newFile(System.getProperty("user.dir") + "\\reports\\arrays_tests_" + length + "_Average.csv");
        factory.addRecord(1, length, "bubble_sort",      avgBubble/50);
        factory.addRecord(1, length, "selection_sort",   avgSelection/50);
        factory.addRecord(1, length, "insertion_sort",   avgInsertion/50);
        factory.addRecord(1, length, "heap_sort",        avgHeap/50);
        factory.addRecord(1, length, "merge_sort",       avgMerge/50);
        factory.addRecord(1, length, "quick_sort",       avgQuick/50);
        factory.addRecord(1, length, "count_sort",       avgCount/50);
        factory.addRecord(1, length, "bucket_sort",      avgBucket/50);
        factory.addRecord(1, length, "radix_sort",       avgRadix/50);
    }
}
