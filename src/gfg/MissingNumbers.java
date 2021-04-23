package gfg;

import java.util.Arrays;
import java.util.HashMap;

public class MissingNumbers {
    public static int missingNumbers(int arr[], int n) {
        int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        int sn = n * ( n + 1) / 2;

        return  sn - sum;
    }
}
