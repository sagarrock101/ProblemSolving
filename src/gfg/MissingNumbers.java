package gfg;

import java.util.Arrays;
import java.util.HashMap;

public class MissingNumbers {
    public static int missingNumbers(int arr[], int n) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        int sn = n * (n + 1) / 2;

        return sn - sum;
    }

    public static int getMissingNo(int a[], int n) {
        int total = 1;
        // 1, 2, 4, 5
        //4

        for (int i = 2; i <= (n + 1); i++) {
            total += i;
            total -= a[i - 2];
        }
        return total;
    }

    //1, 2, 3, 4, 5, 6, 7, 8, 10
    //0, 1, 2, 3, 4, 5, 6, 7, 8

    public static int missingNumberOptimized(int[] arr) {
        //        1, 2, 3, 4, 6, 7, 8
        //        0, 1, 2, 3, 4, 5, 6
        Arrays.sort(arr);
        int a = 0;
        int b = arr.length - 1;
        int mid = 0;
        while ((b - a) > 1) {
            mid = (a + b) / 2;
            if((arr[a] - a) != arr[mid] - mid) {    
                b = mid;
            } else if((arr[b] - b) != arr[mid] - mid){
                a = mid;
            }
        }
        return arr[a] + 1;
    }
}
