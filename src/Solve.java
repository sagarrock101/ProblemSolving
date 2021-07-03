import codeChef.MaximumProduction;
import codeChef.ShortestRoute;
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
                int d = fastReader.nextInt();
                int x = fastReader.nextInt();
                int y = fastReader.nextInt();
                int z = fastReader.nextInt();
                System.out.println(maxProd(d, x, y, z));
            }
        } catch (Exception e) {

        }


    }

    static int maxProd(int d, int x, int y, int z) {
        int a = (7 * x);
        int b = (d * y) + ( 7 - d * z);
        return Math.max(a, b);
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


    public static int[] minTimeRequired(int n, int m, int[] trains, int[] travellers) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int[] res = new int[m];
        for (int i = 0; i < trains.length; i++) {
            if (trains[i] != 0)
                hashMap.put(i + 1, trains[i]);
        }

        for (int i = 0; i < travellers.length; i++) {
            res[i] = getShortest(travellers[i], hashMap);
        }

        return res;
    }

    public static int getShortest(int traveller, HashMap<Integer, Integer> hashMap) {
        int res = 0;
        int minDist = Integer.MAX_VALUE;
        if (traveller == 1) {
            return res;
        }
        for (Integer stnTrain : hashMap.keySet()) {
            if (traveller == stnTrain) {
                return res;
            }

            if (hashMap.get(stnTrain) == 1 && traveller >= stnTrain
                    || hashMap.get(stnTrain) == 2 && traveller <= stnTrain) {
                int distanceDiff = Math.abs(stnTrain - traveller);
                minDist = Math.min(minDist, distanceDiff);
            }
        }
        res = (minDist == Integer.MAX_VALUE) ? -1 : minDist;
        return res;
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

