import java.util.Arrays;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        int last = nums[nums.length - 1];
        while (k-- > 0) {
            last = nums[nums.length - 1];
            for(int i = nums.length - 2 ; i >= 0; i--) {
               nums[i+1] = nums[i];
            }
            nums[0] = last;
        }
        System.out.println(Arrays.toString(nums));
    }
}
