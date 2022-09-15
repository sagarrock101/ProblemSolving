package codingninja;

import java.util.Arrays;

public class SumOfMaxMin {
    public static int sumOfMaxMin(int[] arr, int n) {
        // Write your code here.
        Arrays.sort(arr);
        int min = getMinElement(arr);
        int max = getMaxElement(arr);
        return min + max;
    }

    private static int getMaxElement(int[] arr) {
        return arr[0];
    }

    private static int getMinElement(int[] arr) {
        return arr[arr.length - 1];
    }
}
