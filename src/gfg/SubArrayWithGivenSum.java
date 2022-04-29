package gfg;

import java.util.ArrayList;

public class SubArrayWithGivenSum {

   public static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {

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

    // 12
    //1,2,3,7,5
    //1,3,6,13,18

    //15
    //1 2 3 6 8 6 9
    //0 1 2 3 4 5 6
    //15
    //1, 2, 3, 6, 8, 6, 9
    public static ArrayList<Integer> subarraySum2(int[] arr, int n, int s) {

        ArrayList<Integer> arrayList = new ArrayList<>();
        int i = 0;
        int j = 0;
        int sum = 0;
        int start = 0;
        while (i < arr.length) {
            if(sum <= s) {
                sum += arr[i];
                i++;
                if(sum == s) {
                    arrayList.add(j + 1);
                    arrayList.add(i);
                    return arrayList;
                }
            } else {
                while ( j < i) {
                    sum -= arr[j++];
                    if(sum == s) {
                        arrayList.add(j + 1);
                        arrayList.add(i);
                        return arrayList;
                    }
                }
            }
        }

        return arrayList;
    }

    public static ArrayList<Integer> subarraySum3(int[] arr, int n, int s) {
       ArrayList<Integer> arrayList = new ArrayList<>();
       int start = 0;
       int sum = 0;
       for(int i = 0; i < n; i++) {
           sum += arr[i];
           while(sum > s) {
               sum -= arr[start++];
           }
           if(sum == s) {
               arrayList.add(start + 1);
               arrayList.add(i + 1);
               return arrayList;
           }
       }
       arrayList.add(-1);
       return arrayList;
    }
}
