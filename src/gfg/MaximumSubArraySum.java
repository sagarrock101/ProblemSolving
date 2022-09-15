package gfg;

import java.util.ArrayList;

public class MaximumSubArraySum {

    //Function to find maximum of each subarray of size k.
    public static ArrayList<Integer> maxOfSubArray(int arr[], int n, int k) {
        // Your code here
        int max = Integer.MIN_VALUE;
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < arr.length - k + 1; i++) {
            for (int j = i; j <= i + k - 1; j++) {
                max = Math.max(arr[j], max);
            }
            arrayList.add(max);
//            System.out.println(max);
            max = Integer.MIN_VALUE;
        }
        return arrayList;
    }
}
