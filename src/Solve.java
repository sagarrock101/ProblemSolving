import codeChef.BellaCiao;
import codeChef.TicTacToe;
import gfg.PythagoreanTriplet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solve {

    public static void main(String args[]) throws IOException {


        FastReader fastReader = new FastReader();

        try {
            int t =  fastReader.nextInt();
            while (t-- > 0) {
                int D = fastReader.nextInt();
                int d = fastReader.nextInt();
                int P = fastReader.nextInt();
                int Q = fastReader.nextInt();
                System.out.println(getTotalNumberOfNotes(D, d, P, Q));
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


}

