package gfg;

import java.util.Arrays;

public class PythagoreanTriplet {
    public static boolean checkTriplet(int[] arr, int n) {
        // code here
        //3, 2, 4, 6, 5
        //9, 4, 16, 36, 25
        //4, 9, 16, 25, 36
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) Math.pow(arr[i], 2);
        }

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        for(int z = n - 1; z >= 2; z--) {
            int x = 0;
            int y = arr.length - 2;
            while (x < y) {
                if (arr[x] + arr[y] == arr[z])
                    return true;
                else if (arr[x] + arr[y] > arr[z])
                    y--;
                else {
                    x++;
                }
            }
        }

        return false;
    }
}
