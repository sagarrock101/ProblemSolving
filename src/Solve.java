import codeChef.MaximumProduction;
import codeChef.Relativity;
import codeChef.ShortestRoute;
import codeChef.XxOoRr;
import leetcode.RomanToInteger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solve {

    public static long modular = 1000000007;
    private static long[] a;

    public static void main(String args[]) throws IOException {


        FastReader fastReader = new FastReader();
        try {
            int t = fastReader.nextInt();
            while (t-- > 0) {
                int n = fastReader.nextInt();
                int k = fastReader.nextInt();
                int[] arr = new int[n];
                for(int i = 0; i < arr.length; i++) {
                    arr[i] = fastReader.nextInt();
                }
                System.out.println(getMinimumOperations(n, k, arr));
            }
        } catch (Exception e) {

        }
        System.out.println(convertToBin(6));

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

    public static String convertToBin(int num) {
        String temp = "";
        for(int i = 0; num > 0; i++) {
            temp += (num % 2);
            num /= 2;
        }
        return temp;

    }

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

