package gfg;

import java.util.Arrays;

public class RearrangeArrayAlt {
    public static void rearrange(int arr[], int n) {

        // Your code here
        int[] temp = new int[n];
        int mid = (arr.length - 1) / 2;
        int j = 0;
        for (int i = arr.length - 1; i >= mid; i--, j += 2) {
            if (j < n)
                temp[j] = arr[i];
        }
//        System.out.println(Arrays.toString(temp));
        j = 1;
        for (int i = 0; i <= mid; i++, j+=2) {
            if (j < n)
                temp[j] = arr[i];
        }

        for(int i = 0; i < arr.length; i++) {
            arr[i] = temp[i];
        }

    }
}
