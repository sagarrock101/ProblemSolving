package codeChef;

public class Golf {
    public static String isHolePresent(int n, int x, int k) {
        // 0, 1, 2, 3, 4, 5, 6
        if(((n+1)-x) % k == 0)
            return "YES";
        else return "NO";
    }
}
