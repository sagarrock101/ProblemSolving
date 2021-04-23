package gfg;

import java.util.ArrayList;

public class SubArrayWithGivenSum {
    // 12
    //1,2,3,7,5
    //1,3,6,13,18
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {

        ArrayList<Integer> arrayList = new ArrayList<>();
        if (arr.length == 0)
            return arrayList;
        int curSum = arr[0];
        int start = 0;
        for (int i = 1; i <= arr.length; i++) {
            while (curSum > s && start < i - 1) {
                curSum -= arr[start];
                start++;
            }
            if (curSum == s) {
                arrayList.add(start);
                arrayList.add(i);
                return arrayList;
            }

            if (i < n)
                curSum += arr[i];
        }

        return arrayList;
    }
}
