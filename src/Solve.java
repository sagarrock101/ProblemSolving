import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solve {

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String lines = br.readLine();
        try {
            int t = Integer.parseInt(lines.split(" ")[0]);
            while (t-- > 0) {
                lines = br.readLine();
                int x = Integer.parseInt(lines.split(" ")[0]);
                System.out.println(power(2, x - 1));
            }
        } catch (Exception e) {

        }

    }

    static boolean equalityCheck(int x) {
        return (x ^ (x + 1)) == ((x + 2) ^ (x + 3));
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

