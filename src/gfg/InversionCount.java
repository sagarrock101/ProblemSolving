package gfg;

import java.util.Arrays;

public class InversionCount {


    public static long mergeSortAndCount(long[] arr, int left, int right) {
        int count = 0;

        if (left < right) {
            int m = (left + right) / 2;

            // Total inversion count = left subarray count
            // + right subarray count + merge count

            // Left subarray count
            count += mergeSortAndCount(arr, left, m);

            // Right subarray count
            count += mergeSortAndCount(arr, m + 1, right);

            // Merge count
            count += mergeAndCount(arr, left, m, right);
        }

        return count;
    }

    private static int mergeAndCount(long[] arr, int l, int m, int r) {
        // Left subarray
        long[] left = Arrays.copyOfRange(arr, l, m + 1);

        // Right subarray
        long[] right = Arrays.copyOfRange(arr, m + 1, r + 1);

        int i = 0, j = 0, k = l, swaps = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j])
                arr[k++] = left[i++];
            else {
                arr[k++] = right[j++];
                swaps += (m + 1) - (l + i);
            }
        }
        while (i < left.length)
            arr[k++] = left[i++];
        while (j < right.length)
            arr[k++] = right[j++];
        return swaps;
    }

}
