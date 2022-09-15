package codingninja;

import java.util.ArrayList;

public class MoveAllNegativeToFontAndPositiveToBack {
    // 1, 2, -3, 4, -4, -5
    // -3, 2, 1, 4, -4, -5
    // -3, -4, 1, 4, 2, -5
    //-3, -4, -5, 1, 4, 2

    public static ArrayList<Integer> separateNegativeAndPositive(ArrayList<Integer> nums) {
        // Write your code here.
        int moveIdx = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) < 0) {
                swap(nums, i, moveIdx++);
            }
        }
        return nums;
    }

    private static void swap(ArrayList<Integer> arr, int i, int j) {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }
}
