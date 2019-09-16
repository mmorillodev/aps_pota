public class Tests {
    public static void main(String[] args) {
        int[] arr = {9, 5, 4, 1, 8, 3, 2, 7, 6};
        int[] corArr = {1,2,3,4,5,6,7,8,9};

//        System.out.println(java.util.Arrays.toString(arr));
//        System.out.println(java.util.Arrays.toString(arr2));
//
//        System.out.println(java.util.Arrays.toString(Arrays.getIntArray(1000)));
//        System.out.println(System.getProperty("user.dir"));
        Arrays.selectionSort(arr);
        System.out.println(java.util.Arrays.toString(arr));
    }
}
