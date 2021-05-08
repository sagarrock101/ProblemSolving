package codeChef;

public class Solubility {
    public static int getTotalSugarDissolved(int x, int a, int b) {
        int total = (a + (100 - x) * b);
        return total * 10;
    }
}
