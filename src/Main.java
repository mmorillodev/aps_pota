public class Main {

    @SuppressWarnings("all")
    public static void main(String[] args) {
        var factory = new CSVFactory(System.getProperty("user.dir") + "/reports");
        factory.setHeaders("test_id", "array_size", "sort_method", "timestamp");

        int[] aux, arr;
        int test_id = 0;
        double initial, end;

        //TEST ARRAYS SIZE 5
        for(int i = 0; i < 50; i++, test_id++) {
            arr = Arrays.getIntArray(5);

            aux = new int[5];
            System.arraycopy(arr, 0, aux, 0, arr.length);

            initial = System.nanoTime();
            Arrays.bubbleSort(aux);
            end = System.nanoTime();

            factory.addRecord(test_id, 5, "bubble_sort", end-initial + "nS");

            //-------------------------------------------------------------

            System.arraycopy(arr, 0, aux, 0, arr.length);

            initial = System.nanoTime();
            Arrays.selectionSort(aux);
            end = System.nanoTime();

            factory.addRecord(test_id, 5, "selection_sort", end-initial + "nS");

            //-------------------------------------------------------------

            System.arraycopy(arr, 0, aux, 0, arr.length);

            initial = System.nanoTime();
            Arrays.insertionSort(aux);
            end = System.nanoTime();

            factory.addRecord(test_id, 5, "insertion_sort", end-initial + "nS");

            //-------------------------------------------------------------

            System.arraycopy(arr, 0, aux, 0, arr.length);

            initial = System.nanoTime();
            Arrays.mergeSort(aux);
            end = System.nanoTime();

            factory.addRecord(test_id, 5, "merge_sort", end-initial + "nS");

            //-------------------------------------------------------------

            System.arraycopy(arr, 0, aux, 0, arr.length);

            initial = System.nanoTime();
            Arrays.quickSort(aux);
            end = System.nanoTime();

            factory.addRecord(test_id, 5, "quick_sort", end-initial + "nS");

            //-------------------------------------------------------------

            System.arraycopy(arr, 0, aux, 0, arr.length);

            initial = System.nanoTime();
            Arrays.countSort(aux);
            end = System.nanoTime();

            factory.addRecord(test_id, 5, "count_sort", end-initial + "nS");

            //-------------------------------------------------------------

            System.arraycopy(arr, 0, aux, 0, arr.length);

            initial = System.nanoTime();
            Arrays.bucketSort(aux);
            end = System.nanoTime();

            factory.addRecord(test_id, 5, "bucket_sort", end-initial + "nS");

            //-------------------------------------------------------------

            System.arraycopy(arr, 0, aux, 0, arr.length);

            initial = System.nanoTime();
            Arrays.radixSort(aux);
            end = System.nanoTime();

            factory.addRecord(test_id, 5, "radix_sort", end-initial + "nS");
        }

        //TEST ARRAYS SIZE 10
        for(int i = 0; i < 50; i++) {
            arr = Arrays.getIntArray(5);

            aux = new int[10];
            System.arraycopy(arr, 0, aux, 0, arr.length);

            initial = System.nanoTime();
            Arrays.bubbleSort(aux);
            end = System.nanoTime();

            factory.addRecord(test_id, 10, "bubble_sort", end-initial + "nS");

            //-------------------------------------------------------------

            System.arraycopy(arr, 0, aux, 0, arr.length);

            initial = System.nanoTime();
            Arrays.selectionSort(aux);
            end = System.nanoTime();

            factory.addRecord(test_id, 10, "selection_sort", end-initial + "nS");

            //-------------------------------------------------------------

            System.arraycopy(arr, 0, aux, 0, arr.length);

            initial = System.nanoTime();
            Arrays.insertionSort(aux);
            end = System.nanoTime();

            factory.addRecord(test_id, 10, "insertion_sort", end-initial + "nS");

            //-------------------------------------------------------------

            System.arraycopy(arr, 0, aux, 0, arr.length);

            initial = System.nanoTime();
            Arrays.mergeSort(aux);
            end = System.nanoTime();

            factory.addRecord(test_id, 10, "merge_sort", end-initial + "nS");

            //-------------------------------------------------------------

            System.arraycopy(arr, 0, aux, 0, arr.length);

            initial = System.nanoTime();
            Arrays.quickSort(aux);
            end = System.nanoTime();

            factory.addRecord(test_id, 10, "quick_sort", end-initial + "nS");

            //-------------------------------------------------------------

            System.arraycopy(arr, 0, aux, 0, arr.length);

            initial = System.nanoTime();
            Arrays.countSort(aux);
            end = System.nanoTime();

            factory.addRecord(test_id, 10, "count_sort", end-initial + "nS");

            //-------------------------------------------------------------

            System.arraycopy(arr, 0, aux, 0, arr.length);

            initial = System.nanoTime();
            Arrays.bucketSort(aux);
            end = System.nanoTime();

            factory.addRecord(test_id, 10, "bucket_sort", end-initial + "nS");

            //-------------------------------------------------------------

            System.arraycopy(arr, 0, aux, 0, arr.length);

            initial = System.nanoTime();
            Arrays.radixSort(aux);
            end = System.nanoTime();

            factory.addRecord(test_id, 10, "radix_sort", end-initial + "nS");
        }

        //TEST ARRAYS SIZE 50
        for(int i = 0; i < 50; i++, test_id++) {
            arr = Arrays.getIntArray(50);

            aux = new int[50];
            System.arraycopy(arr, 0, aux, 0, arr.length);

            initial = System.nanoTime();
            Arrays.bubbleSort(aux);
            end = System.nanoTime();

            factory.addRecord(test_id, 50, "bubble_sort", end-initial + "nS");

            //-------------------------------------------------------------

            System.arraycopy(arr, 0, aux, 0, arr.length);

            initial = System.nanoTime();
            Arrays.selectionSort(aux);
            end = System.nanoTime();

            factory.addRecord(test_id, 50, "selection_sort", end-initial + "nS");

            //-------------------------------------------------------------

            System.arraycopy(arr, 0, aux, 0, arr.length);

            initial = System.nanoTime();
            Arrays.insertionSort(aux);
            end = System.nanoTime();

            factory.addRecord(test_id, 50, "insertion_sort", end-initial + "nS");

            //-------------------------------------------------------------

            System.arraycopy(arr, 0, aux, 0, arr.length);

            initial = System.nanoTime();
            Arrays.mergeSort(aux);
            end = System.nanoTime();

            factory.addRecord(test_id, 50, "merge_sort", end-initial + "nS");

            //-------------------------------------------------------------

            System.arraycopy(arr, 0, aux, 0, arr.length);

            initial = System.nanoTime();
            Arrays.quickSort(aux);
            end = System.nanoTime();

            factory.addRecord(test_id, 50, "quick_sort", end-initial + "nS");

            //-------------------------------------------------------------

            System.arraycopy(arr, 0, aux, 0, arr.length);

            initial = System.nanoTime();
            Arrays.countSort(aux);
            end = System.nanoTime();

            factory.addRecord(test_id, 50, "count_sort", end-initial + "nS");

            //-------------------------------------------------------------

            System.arraycopy(arr, 0, aux, 0, arr.length);

            initial = System.nanoTime();
            Arrays.bucketSort(aux);
            end = System.nanoTime();

            factory.addRecord(test_id, 50, "bucket_sort", end-initial + "nS");

            //-------------------------------------------------------------

            System.arraycopy(arr, 0, aux, 0, arr.length);

            initial = System.nanoTime();
            Arrays.radixSort(aux);
            end = System.nanoTime();

            factory.addRecord(test_id, 50, "radix_sort", end-initial + "nS");
        }

        //TEST ARRAYS SIZE 100
        for(int i = 0; i < 50; i++) {
            arr = Arrays.getIntArray(100);

            aux = new int[100];
            System.arraycopy(arr, 0, aux, 0, arr.length);

            initial = System.nanoTime();
            Arrays.bubbleSort(aux);
            end = System.nanoTime();

            factory.addRecord(test_id, 100, "bubble_sort", end-initial + "nS");

            //-------------------------------------------------------------

            System.arraycopy(arr, 0, aux, 0, arr.length);

            initial = System.nanoTime();
            Arrays.selectionSort(aux);
            end = System.nanoTime();

            factory.addRecord(test_id, 100, "selection_sort", end-initial + "nS");

            //-------------------------------------------------------------

            System.arraycopy(arr, 0, aux, 0, arr.length);

            initial = System.nanoTime();
            Arrays.insertionSort(aux);
            end = System.nanoTime();

            factory.addRecord(test_id, 100, "insertion_sort", end-initial + "nS");

            //-------------------------------------------------------------

            System.arraycopy(arr, 0, aux, 0, arr.length);

            initial = System.nanoTime();
            Arrays.mergeSort(aux);
            end = System.nanoTime();

            factory.addRecord(test_id, 100, "merge_sort", end-initial + "nS");

            //-------------------------------------------------------------

            System.arraycopy(arr, 0, aux, 0, arr.length);

            initial = System.nanoTime();
            Arrays.quickSort(aux);
            end = System.nanoTime();

            factory.addRecord(test_id, 100, "quick_sort", end-initial + "nS");

            //-------------------------------------------------------------

            System.arraycopy(arr, 0, aux, 0, arr.length);

            initial = System.nanoTime();
            Arrays.countSort(aux);
            end = System.nanoTime();

            factory.addRecord(test_id, 100, "count_sort", end-initial + "nS");

            //-------------------------------------------------------------

            System.arraycopy(arr, 0, aux, 0, arr.length);

            initial = System.nanoTime();
            Arrays.bucketSort(aux);
            end = System.nanoTime();

            factory.addRecord(test_id, 100, "bucket_sort", end-initial + "nS");

            //-------------------------------------------------------------

            System.arraycopy(arr, 0, aux, 0, arr.length);

            initial = System.nanoTime();
            Arrays.radixSort(aux);
            end = System.nanoTime();

            factory.addRecord(test_id, 100, "radix_sort", end-initial + "nS");
        }


        //TEST ARRAYS SIZE 1000
        for(int i = 0; i < 50; i++) {
            arr = Arrays.getIntArray(1000);

            aux = new int[1000];
            System.arraycopy(arr, 0, aux, 0, arr.length);

            initial = System.nanoTime();
            Arrays.bubbleSort(aux);
            end = System.nanoTime();

            factory.addRecord(test_id, 1000, "bubble_sort", end-initial + "nS");

            //-------------------------------------------------------------

            System.arraycopy(arr, 0, aux, 0, arr.length);

            initial = System.nanoTime();
            Arrays.selectionSort(aux);
            end = System.nanoTime();

            factory.addRecord(test_id, 1000, "selection_sort", end-initial + "nS");

            //-------------------------------------------------------------

            System.arraycopy(arr, 0, aux, 0, arr.length);

            initial = System.nanoTime();
            Arrays.insertionSort(aux);
            end = System.nanoTime();

            factory.addRecord(test_id, 1000, "insertion_sort", end-initial + "nS");

            //-------------------------------------------------------------

            System.arraycopy(arr, 0, aux, 0, arr.length);

            initial = System.nanoTime();
            Arrays.mergeSort(aux);
            end = System.nanoTime();

            factory.addRecord(test_id, 1000, "merge_sort", end-initial + "nS");

            //-------------------------------------------------------------

            System.arraycopy(arr, 0, aux, 0, arr.length);

            initial = System.nanoTime();
            Arrays.quickSort(aux);
            end = System.nanoTime();

            factory.addRecord(test_id, 1000, "quick_sort", end-initial + "nS");

            //-------------------------------------------------------------

            System.arraycopy(arr, 0, aux, 0, arr.length);

            initial = System.nanoTime();
            Arrays.countSort(aux);
            end = System.nanoTime();

            factory.addRecord(test_id, 1000, "count_sort", end-initial + "nS");

            //-------------------------------------------------------------

            System.arraycopy(arr, 0, aux, 0, arr.length);

            initial = System.nanoTime();
            Arrays.bucketSort(aux);
            end = System.nanoTime();

            factory.addRecord(test_id, 1000, "bucket_sort", end-initial + "nS");

            //-------------------------------------------------------------

            System.arraycopy(arr, 0, aux, 0, arr.length);

            initial = System.nanoTime();
            Arrays.radixSort(aux);
            end = System.nanoTime();

            factory.addRecord(test_id, 1000, "radix_sort", end-initial + "nS");
        }

        //TEST ARRAYS SIZE 10000
        for(int i = 0; i < 50; i++) {
            arr = Arrays.getIntArray(10000);

            aux = new int[10000];
            System.arraycopy(arr, 0, aux, 0, arr.length);

            initial = System.nanoTime();
            Arrays.bubbleSort(aux);
            end = System.nanoTime();

            factory.addRecord(test_id, 10000, "bubble_sort", end-initial + "nS");

            //-------------------------------------------------------------

            System.arraycopy(arr, 0, aux, 0, arr.length);

            initial = System.nanoTime();
            Arrays.selectionSort(aux);
            end = System.nanoTime();

            factory.addRecord(test_id, 10000, "selection_sort", end-initial + "nS");

            //-------------------------------------------------------------

            System.arraycopy(arr, 0, aux, 0, arr.length);

            initial = System.nanoTime();
            Arrays.insertionSort(aux);
            end = System.nanoTime();

            factory.addRecord(test_id, 10000, "insertion_sort", end-initial + "nS");

            //-------------------------------------------------------------

            System.arraycopy(arr, 0, aux, 0, arr.length);

            initial = System.nanoTime();
            Arrays.mergeSort(aux);
            end = System.nanoTime();

            factory.addRecord(test_id, 10000, "merge_sort", end-initial + "nS");

            //-------------------------------------------------------------

            System.arraycopy(arr, 0, aux, 0, arr.length);

            initial = System.nanoTime();
            Arrays.quickSort(aux);
            end = System.nanoTime();

            factory.addRecord(test_id, 10000, "quick_sort", end-initial + "nS");

            //-------------------------------------------------------------

            System.arraycopy(arr, 0, aux, 0, arr.length);

            initial = System.nanoTime();
            Arrays.countSort(aux);
            end = System.nanoTime();

            factory.addRecord(test_id, 10000, "count_sort", end-initial + "nS");

            //-------------------------------------------------------------

            System.arraycopy(arr, 0, aux, 0, arr.length);

            initial = System.nanoTime();
            Arrays.bucketSort(aux);
            end = System.nanoTime();

            factory.addRecord(test_id, 10000, "bucket_sort", end-initial + "nS");

            //-------------------------------------------------------------

            System.arraycopy(arr, 0, aux, 0, arr.length);

            initial = System.nanoTime();
            Arrays.radixSort(aux);
            end = System.nanoTime();

            factory.addRecord(test_id, 10000, "radix_sort", end-initial + "nS");
        }
    }
}
