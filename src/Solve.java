import codeChef.ShortestRoute;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solve {

    public static long modular = 1000000007;
    private static long[] a;

    public static void main(String args[]) throws IOException {


        FastReader fastReader = new FastReader();
//        a = new long[1000002];
//        a[1] = 2;
//
//        for(int i = 2; i < 1000002; i++) {
//            a[i] = (a[i - 1] * 2 % modular);
//        }

//        TwoSum twoSum = new TwoSum();
//        System.out.println(Arrays.toString(twoSum.twoSum(new int[]{1, 2, 3, 4, 5}, 9)));

//        for codechef only
        try {

        } catch (Exception e) {

        }

        int t = fastReader.nextInt();
        while (t-- > 0) {
            int n = fastReader.nextInt();
            int m = fastReader.nextInt();
            int[] stns = new int[n];
            for (int i = 0; i < stns.length; i++) {
                int stn = fastReader.nextInt();
                stns[i] = stn;
            }
            int[] travellers = new int[m];
            for (int i = 0; i < m; i++) {
                travellers[i] = fastReader.nextInt();
                System.out.println(minRoute(n, m, stns, travellers[i]));
            }
//                System.out.println(Arrays.toString(minTimeRequired(n, m, stns, travellers)));
        }


    }

    public static int minRoute(int n, int m, int[] trains, int destination) {
        // 1 1 0 0 0 2 0 1 2 0
        //
        // 1 2 3 4 5 6 7 8 9 10
        // 5
        if (trains[destination - 1] == 1 || trains[destination - 1] == 2) {
            return 0;
        }

        int[] leftRightMins = new int[destination - 1];
        int[] rightLeftMins = new int[n - destination];
        int left = 0;
        int right = 0;
        for (int i = destination - 1; i >= 0; i--) {
            if (trains[i] == 1 && left < leftRightMins.length) {
                leftRightMins[left] = destination - (i + 1);
                break;
            }
        }

        for (int i = destination - 1; i < n; i++) {
            if (trains[i] == 2 && right < rightLeftMins.length) {
                rightLeftMins[right] = (i + 1) - destination;
                break;
            }
        }
        if (leftRightMins.length > 0 && rightLeftMins.length > 0)
            return Math.min(leftRightMins[leftRightMins.length - 1], rightLeftMins[rightLeftMins.length - 1]);
        else if (leftRightMins.length != 0)
            return leftRightMins[leftRightMins.length - 1];
        else if (rightLeftMins.length != 0)
            return rightLeftMins[rightLeftMins.length - 1];
        else return -1;

        //        for(int i = destination; i < n; i++)

    }

    private static int findMinDistForDest(int dest, int[] stns, int m, int n) {
        int ans = minStn(dest, stns, n);

        if (ans == Integer.MAX_VALUE) {
            ans = -1;
        }
        if (dest == 1)
            ans = 0;

        return ans;

    }

    public static int minStn(int dest, int[] stns, int n) {
        int preRight = -1;
        int preLeft = -1;

        ArrayList<Integer> minLeft = new ArrayList<>(n);
        ArrayList<Integer> minRight = new ArrayList<>(n);

        Collections.fill(minLeft, Integer.MAX_VALUE);
        Collections.fill(minRight, Integer.MAX_VALUE);

        for (int i = 1; i < n; i++) {
            if (stns[i] == 1) {
                preRight = i;
            }
            if (preRight != -1) {
                minRight.set(i, i - preRight);
            }
        }

        for (int i = n - 1; i >= n; i--) {
            if (stns[i] == 2) {
                preLeft = i;
            }
            if (preRight != -1) {
                minLeft.set(i, preLeft - i);
            }
        }

        return Math.min(minLeft.get(dest), minRight.get(dest));

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

