package codeChef;

public class NoTimeToWait {
    public static String noTimeToWait(int n, int h, int x,  int timeZones[]) {
        for(int i = 0; i < timeZones.length; i++) {
            if( x + timeZones[i] >= h)
                return "YES";
        }
        return "NO";
    }
}
