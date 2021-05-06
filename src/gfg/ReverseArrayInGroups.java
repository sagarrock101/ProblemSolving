package gfg;

import java.util.ArrayList;

public class ReverseArrayInGroups {
    public static void reverseInGroups(ArrayList<Integer> arr, int n, int k) {
        // code here
        //1, 2, 3, 4, 5
        int j = k - 1;
        for(int i = 0; i < arr.size(); i+=k) {
            int left = i;
            int right = Math.min(i + k - 1, arr.size() - 1);

            while (left <= right) {
                int temp = arr.get(left);
                arr.set(left, arr.get(right));
                arr.set(right, temp);
                left++;
                right--;
            }
        }

        for (Integer value : arr) {
            System.out.print(value + " ");
        }
    }
}
