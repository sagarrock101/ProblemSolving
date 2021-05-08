import codeChef.Golf;
import gfg.TrappingRainWater;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solve {

    public static void main(String args[]) throws IOException {

//        System.out.println(TrappingRainWater.trappingWater(new int[]{7,4,0,9}, 4));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String lines = br.readLine();
        try {
            int t = Integer.parseInt(lines.split(" ")[0]);
            while (t-- > 0) {
                lines = br.readLine();
                int x = Integer.parseInt(lines.split(" ")[0]);
                int a = Integer.parseInt(lines.split(" ")[1]);
                int b = Integer.parseInt(lines.split(" ")[2]);
                System.out.println(isHolePresent(x, a, b));
            }
        } catch (Exception e) {

        }

    }

    public static String isHolePresent(int n, int x, int k) {
        if (x % k == 0)
            return "YES";

        if (((n + 1) - x) % k == 0)
            return "YES";
        else
            return "NO";
    }


}

