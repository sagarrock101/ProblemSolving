package gfg;

import java.util.Arrays;

public class CountTriplets {
    public static int countTriplets(int arr[], int n) {
        // 1 2 3 5
        Arrays.sort(arr);
        int count = 0;
        for(int i = 0; i < arr.length; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                if(binarySearch(arr, j + 1, arr.length - 1, arr[i] + arr[j]) != -1)
                    count++;
            }
        }
        return count;
    }

   public static int binarySearch(int arr[], int l, int r, int x)
    {
        if (r >= l) {
            int mid = l + (r - l) / 2;

            // If the element is present at the
            // middle itself
            if (arr[mid] == x)
                return mid;

            // If element is smaller than mid, then
            // it can only be present in left subarray
            if (arr[mid] > x)
                return binarySearch(arr, l, mid - 1, x);

            // Else the element can only be present
            // in right subarray
            return binarySearch(arr, mid + 1, r, x);
        }

        // We reach here when element is not present
        // in array
        return -1;
    }
}
