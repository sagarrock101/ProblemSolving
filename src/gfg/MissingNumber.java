package gfg;

import java.util.Arrays;

public class MissingNumber {

    public static int missingNumber(int arr[], int n) {
        Arrays.sort(arr);
        int count = 1;
        for (int i = 0; i < arr.length; i++) {
            if (count != arr[i]) {
                return count;
            } else {
                count++;
            }
        }

        return count;
    }

}
