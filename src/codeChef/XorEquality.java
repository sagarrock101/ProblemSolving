package codeChef;

public class XorEquality {
    public static boolean equalityCheck(int x) {
        return (x ^ (x + 1)) == ((x + 2) ^ (x + 3));
    }
}
