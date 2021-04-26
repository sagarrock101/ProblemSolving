package gfg;

import java.util.Arrays;

public class EquilbriumPoint {
    public static int equilibriumPoint(long arr[], int n) {
        // Your code here
        // 10, 20, 30, 40, 50
        //10, 30, 60, 100, 150
        long sum = 0;
        for (int i = 0; i < arr.length; i++)
            sum += arr[i];

        long leftSum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum -= arr[i];
            if(leftSum == sum)
                return i + 1;
            leftSum += arr[i];

        }
//        long[] temp = new long[arr.length];
//        temp[0] = arr[0];
//        for(int i = 1; i < arr.length; i++) {
//            temp[i] = temp[i - 1] + arr[i];
//        }
//
//        long[] temp1 = new long[arr.length];
//        temp1[temp1.length - 1] = arr[temp1.length - 1];
//        for(int i = temp1.length - 2; i >= 0; i--) {
//            temp1[i] = temp1[i + 1] + arr[i];
//        }
//
//        for(int i = 0, j = arr.length - 1; i < arr.length; i++, j--) {
//            if(temp[i] == temp1[i])
//                return i + 1;
//        }
//
//        System.out.println(Arrays.toString(temp1));
//
//
//        System.out.println(Arrays.toString(temp));

        return -1;
    }
}
