package codeChef;

public class BitwiseTuples {

    public static long modular = 1000000007;

    public static long getTotalTuples(int n, int m) {
        long[] a = new long[1000002];
        a[1] = 2;

        for(int i = 2; i < 1000002; i++) {
            a[i] = (a[i - 1] * 2 % modular);
        }

        long x = a[n] - 1;
        return power(x, m);

    }

    static long power(long x, long y)
    {
        long res = 1;     // Initialize result

        while (y > 0)
        {

            // If y is odd, multiply x with result
            if ((y & 1) != 0)
                res =( res * x) % 1000000007;

            // y must be even now
            y = y >> 1; // y = y/2
            x = (x * x) % 1000000007;  // Change x to x^2
        }
        return res;
    }
}
