import codeChef.*;
import gfg.*;
import leetcode.RomanToInteger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static MyArticlesSupportPrograms.FlowRetryKt.simple;

public class Solve {

    public static long modular = 1000000007;
    private static long[] a;
    public static long[] chefolaArray = new long[100001];
    public static  long[] prefixChefola = new long[100001];


    public static void main(String args[]) throws IOException {
//        System.out.println(SubArrayWithGivenSum.subarraySum3(new int[]{1, 2, 3, 7, 5}, 5, 12));
//                                                                    //0, 1, 2, 3, 4
//        System.out.println(SubArrayWithGivenSum.subarraySum3(new int[]{1, 2, 3, 6, 8, 6, 9}, 7, 15));
//                                                                        //0, 1, 2, 3, 4, 5, 6
////        1,2,3,4,5,6,7,8,9,10
//        System.out.println(SubArrayWithGivenSum.subarraySum3(new int[]{1,2,3,4,5,6,7,8,9,10}, 10, 15));
//        System.out.println(KadanesAlgorithm.maxSubarraySum(new int[]{1, 2, 3, -2, 5}, 5));
        //        1, 2, 3, 4, 6, 7, 8
        //        0, 1, 2, 3, 4, 5, 6
//        System.out.println(MissingNumbers.missingNumberOptimized(new int[]{1, 2, 4, 6, 3, 7, 8}));
//        MergeTwoArrays.merge2(new long[]{ 1, 3, 5, 7}, new long[]{0, 2, 6, 8, 9}, 4, 5);
//        MergeTwoArrays.merge2(new long[]{1, 3, 5, 7}, new long[]{}, 4, 5);
//        SpiralTraversal.spirallyTraverse(new int[][] {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}}, 4, 4);
//        System.out.println(ParenthesisCheck.isPar("[()]{}{[()()]()}"));
//        System.out.println(ParenthesisCheck.isPar("[(])"));
//        System.out.println(ParenthesisCheck.isPar("[({[([{}])]})]"));
        System.out.println(Arrays.toString(NextGreaterElement.nextLargerElement(new long[]{1, 3, 2, 4}, 4)));
        System.out.println(Arrays.toString(NextGreaterElement.nextLargerElement(new long[]{6, 8, 0, 1, 3}, 4)));
    }



    public static void computeChefolaNumbers() {
        for (int i = 1; i < chefolaArray.length; i++) {
            chefolaArray[i] = getChefolaNumber(i);
            prefixChefola[i] = prefixChefola[i - 1] + chefolaArray[i];
        }
    }

    public static long findOptimum(int[] arr) {
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];
        int[] mid = new int[arr.length];
        long optimalDenominationValue = Integer.MAX_VALUE;
        int maxNum = Integer.MIN_VALUE;
        int maxIdx = 0;
        int sum = 0;
        // 9, 18, 27, 2, 36
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        left[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            left[i] = gcd(arr[i], left[i - 1]);
        }
//        System.out.println("left: " + Arrays.toString(left));

        right[arr.length - 1] = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            right[i] = gcd(arr[i], right[i + 1]);

        }

//        System.out.println("right: " + Arrays.toString(right));

        mid[0] = left[1];
        mid[arr.length - 1] = right[arr.length-2];
        for (int i = 1; i < arr.length - 1; i++) {
            mid[i] = gcd(left[i - 1], right[i + 1]);
        }
        int s = 0;
        for(int i = 0; i < arr.length; i++) {
            s = ((sum - arr[i]) / mid[i]) + 1;
            optimalDenominationValue = Math.min(optimalDenominationValue, s);
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

    public static long findHeight(int g, int c) {
        return (long) (Math.pow(c, 2) / (2L * g));
    }
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }



    public static long getChefolaNumber(int num) {
        //822
        if(num < 10)
            return num;
        long chefNum = num;
        num /= 10;
        while (num != 0) {
            chefNum = chefNum * 10 + num % 10;
            num /= 10;
        }
        return chefNum;
//        long palin = num;
//        num /= num;
//        while (num > 0) {
//            palin = (palin * 10) + (num % 10);
//            num /= num;
//        }

//        return palin;
//        long quotientValue = num / 10;
//        String quoString = String.valueOf(quotientValue);
//        long newNum = (long) ((num * Math.pow(10, quoString.length())) + revNum(quotientValue));
//        String stringNum = String.valueOf(newNum);
//        if(stringNum.length() % 2 != 0)
//            return newNum;
//        else
//            return 0;



    }

    public static long revNum(long num) {
        long temp;
        long rev = 0;
        while (num > 0) {
            temp = num % 10;
            rev = (rev * 10) + temp;
            num /= 10;
        }
        return rev;
    }

    public static long answerQuestions(long l, long r) {
        long y = 0;
        long x = 0;
        x = chefolaArray[(int) l];
        y = prefixChefola[(int) r] - prefixChefola[(int) l];
        return power(x, y);
        // 1, 2, 3, 4, 5, 6, 7, 8,
    }

    static long power(long x, long y) {
//        long res = 1;     // Initialize result
//
//        while (y != 0) {
//
//            // If y is odd, multiply x with result
//            if ((y & 1) != 0)
//                res = (res * x) % modular;
//
//            // y must be even now
//            y = y >> 1; // y = y/2
//            x = (x * x) % modular;  // Change x to x^2
//        }
        long res=1;
        while(y!=0){
            if(y%2==0){
                x=((x%modular)*(x%modular))%modular;
                y= (long) Math.floor(y >> 1);
            }
            else{
                res=((res%modular)*(x%modular))%modular;
                y=y-1;
            }
        }
        return res;
    }

    public static String convertToBin(int num) {
        String temp = "";
        for(int i = 0; num > 0; i++) {
            temp += (num % 2);
            num /= 2;
        }
        return temp;

    }

    public static int revNum(int num) {
        int temp;
        int rev = 0;
        while (num > 0) {
            temp = num % 10;
            rev = (rev * 10) + temp;
            num /= 10;
        }
        return rev;
    }




}

