package gfg;

import java.util.Arrays;

public class TrappingRainWater {
    public static int trappingWater(int arr[], int n) {
        int maxR = 0, maxL = 0, res = 0, left = 0, right = n - 1;
        while (left <= right) {
            if(arr[left] <= arr[right]) {
                if(arr[left] >= maxL)
                    maxL = arr[left];
                else {
                    res += (maxL - arr[left]);
                }
                left++;
            } else {
                if(arr[right] >= maxR)
                    maxR = arr[right];
                else {
                    res += (maxR - arr[right]);
                }
            }
        }

        return res;
    }


    static boolean isSortedDesc(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] < array[i + 1])
                return false;
        }
        return true;
    }

    static boolean isSortedAsc(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1])
                return false;
        }
        return true;
    }
}
