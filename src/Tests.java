public class Tests {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] arr2 = arr.clone();

        arr[0] = 100;

//        System.out.println(java.util.Arrays.toString(arr));
//        System.out.println(java.util.Arrays.toString(arr2));
//
//        System.out.println(java.util.Arrays.toString(Arrays.getIntArray(1000)));
        System.out.println(System.getProperty("user.dir"));
    }
}
