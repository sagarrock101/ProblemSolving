package codeChef;

public class BellaCiao {
    public static long getTotalNumberOfNotes(int D, int d, int P, int Q) {
        int n = D / d;
        long sum = 0;
        sum = (((long) P * n) +  ((long) (Q) * (n - 1) * n) / 2) * d;
        if( D % d != 0)
            sum += (D % d) * (P + (long) n * Q);
        return sum;
    }
}
