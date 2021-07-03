package codeChef;

public class MaximumProduction {
    public static int maxProd(int d, int x, int y, int z) {
        int a = (7 * x);
        int b = (d * y) + ( 7 - d) * z;
        return Math.max(a, b);
    }
}
