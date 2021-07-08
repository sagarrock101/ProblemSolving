package codeChef;

import java.util.Arrays;

public class ChefAndBharath {

    public static long[] chefolaArray = new long[10000];

    public static void computeChefolaNumbers() {
        for (int i = 1; i < chefolaArray.length; i++) {
            chefolaArray[i] = getChefolaNumber(i);
        }
        System.out.println("Before prefix sum");
        System.out.println(Arrays.toString(chefolaArray));

        // 2, 4, 5, 6
        // 2, 6, 11, 17
        // 0, 1, 2,  3
        //
        //prefix sum
        for(int i = 1; i < chefolaArray.length; i++) {
            chefolaArray[i] = chefolaArray[i - 1] + chefolaArray[i];
        }
        System.out.println("prefix sum of chefola array: ");
        System.out.println(Arrays.toString(chefolaArray));
    }

    public static long getChefolaNumber(int num) {
        if(num == 1 || num == 2 || num == 3 || num == 4 || num == 5 || num == 6 || num == 7 || num == 8 || num == 9)
            return num;
        long quotientValue = num / 10;
        String quoString = String.valueOf(quotientValue);
        long newNum = (long) ((num * Math.pow(10, quoString.length())) + revNum(quotientValue));
        String stringNum = String.valueOf(newNum);
        if(stringNum.length() % 2 != 0)
            return newNum;
        else
            return 0;
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
        long answer = 0;
//        for(long i = l + 1; i <= r; i++) {
//            answer = answer + chefolaArray[(int) i];
//        }
        System.out.println("L: " + l + " R: " + (r) );
        System.out.println(chefolaArray[(int) l]);
        System.out.println(chefolaArray[(int) r]);
            answer = Math.abs(chefolaArray[(int) (l)] - chefolaArray[(int) (r)]);
//        System.out.println("Anser: " + answer);
        return power(l, answer);
        // 1, 2, 3, 4, 5, 6, 7, 8,
    }

    static long power(long x, long y) {
        long res = 1;     // Initialize result

        while (y > 0) {

            // If y is odd, multiply x with result
            if ((y & 1) != 0)
                res = (res * x) % 1000000007;

            // y must be even now
            y = y >> 1; // y = y/2
            x = (x * x) % 1000000007;  // Change x to x^2
        }
        return res;
    }

}
