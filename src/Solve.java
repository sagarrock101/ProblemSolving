import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solve {

    public static long modular = 1000000007;
    private static long[] a;
    public static void main(String args[]) throws IOException {


        FastReader fastReader = new FastReader();
        a = new long[1000002];
        a[1] = 2;

        for(int i = 2; i < 1000002; i++) {
            a[i] = (a[i - 1] * 2 % modular);
        }

        try {
            int t =  fastReader.nextInt();
            while (t-- > 0) {
                int n = fastReader.nextInt();
                int m = fastReader.nextInt();
                System.out.println(getTotalTuples(n, m));
            }
        } catch (Exception e) {

        }

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

    public static long getTotalNumberOfNotes(int D, int d, int P, int Q) {
        int n = D / d;
        long sum = 0;
        sum = (((long) P * n) +  ((long) (Q) * (n - 1) * n) / 2) * d;
        if( D % d != 0)
            sum += (D % d) * (P + (long) n * Q);
        return sum;
    }



    public static long getTotalTuples(int n, int m) {


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

