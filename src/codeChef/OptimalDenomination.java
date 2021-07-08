package codeChef;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class OptimalDenomination {
    public static int findOptimum(int[] arr) {
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];
        int[] mid = new int[arr.length];
        int optimalDenominationValue = Integer.MIN_VALUE;
        int maxNum = Integer.MIN_VALUE;
        int maxIdx = 0;
        // 9, 18, 27, 2, 36
        for(int i = 0; i < arr.length; i++) {
            if(maxNum < arr[i]) {
                maxNum = arr[i];
                maxIdx = i;
            }
        }
        for (int i = 1; i < arr.length; i++) {
            left[i] = gcd(arr[i - 1], left[i - 1]);
        }
//        System.out.println("left: " + Arrays.toString(left));


        for (int i = arr.length - 2; i >= 0; i--) {
            right[i] = gcd(arr[i + 1], right[i + 1]);

        }

//        System.out.println("right: " + Arrays.toString(right));


        for (int i = 0; i < arr.length; i++) {
            mid[i] = gcd(left[i], right[i]);
            optimalDenominationValue = Math.max(optimalDenominationValue, mid[i]);
        }

//        System.out.println("mid: " + Arrays.toString(mid));

        if (areSame(mid)) {
            arr[maxIdx] = mid[maxIdx];
            optimalDenominationValue = 0;
            for(int i = 0; i <  arr.length; i++) {
                optimalDenominationValue += (arr[i] / mid[maxIdx]);
            }
            return optimalDenominationValue;
        }


        return optimalDenominationValue;
    }

    public static int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    public static boolean areSame(int[] arr) {
        int first = 0;
        for(int i = 1; i < arr.length; i++) {
            if(arr[first] != (arr[i]))
                return false;
        }
        return true;
    }

}
