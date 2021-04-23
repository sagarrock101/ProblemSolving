import java.util.Arrays;
import java.util.HashSet;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int first = 0;
        int second = 1;
        while (second < nums.length ) {
            if(nums[first] == nums[second]) {
                second++;
            } else {
                swap(++first, second, nums);
            }
        }
        System.out.println(Arrays.toString(nums));
        return first + 1;
    }

    private void swap(int first, int second, int[] nums) {
        nums[first] = nums[second];
    }
}
