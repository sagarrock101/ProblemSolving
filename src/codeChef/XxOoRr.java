package codeChef;

import java.util.Arrays;

public class XxOoRr {
    public static int getMinimumOperations(int n, int k, int[] arr) {
        int[] sum = new int[33];
        for(int i = 0; i < n; i++) {
            int x = arr[i];
            int j = 32;
            while (x > 0) {
                sum[j] = sum[j] + x%2;
                j--;
                x /= 2;
            }
        }
        int minOperations = 0;
        for(int i = 0; i < 33; i ++) {
            if(sum[i] % k == 0) {
                minOperations = minOperations +  (sum[i]/k);
            } else {
                minOperations = minOperations +  (sum[i] / k) + 1;
            }
        }

        return minOperations;
    }
}
