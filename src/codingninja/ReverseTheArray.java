package codingninja;

import java.util.ArrayList;
import java.util.Arrays;

public class ReverseTheArray {
    public static void reverseArray(ArrayList<Integer> arr, int m)
    {
        // Write your code here.
       /*   6 3
            1 2 3 4 5 6
            */
//        10 4 5 2 3 6 1 3 6
//         0 1 2 3 4 5 6 7 8
        int j = arr.size() - 1;

        for (int i = 0; i < arr.size(); i++) {
            if (i > m && i <= j) {
                swap(arr, (i), j--);
            }
        }
        System.out.println(Arrays.toString(arr.toArray()));
    }

    private static void swap(ArrayList<Integer> arr, int i, int j) {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }

}
