package gfg;

import java.util.Arrays;

public class KthSmallestElement {
    public static int kthSmallest(int[] arr, int l, int r, int k) {
        //Your code here
        //3
        Arrays.sort(arr);
        for(int i = 0; i < arr.length; i++) {
            if(i == k - 1)
                return arr[i];
        }

        return -1;
    }
}
