import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> mList = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++) {
            if(i > 0 && (nums[i] != nums[i - 1])) {
                int low = i + 1;
                int high = nums.length - 1;
                int sum = -nums[i];
                while (low < high) {
                    if(nums[low] + nums[high] == sum) {
                        mList.add(Arrays.asList(nums[low], nums[high], nums[i]));
                        while (low < high && nums[low] == nums[low + 1]) low++;
                        while (low < high && nums[high] == nums[high - 1]) high--;
                        low++;
                        high--;
                    } else if(nums[low] + nums[high] < sum) {
                        low++;
                    } else high--;
                }
            }
        }

        return mList;
    }

    private List<Integer> getArrayList(int[] nums) {
        List<Integer> tempList = new ArrayList<Integer>();
        if (nums[0] + nums[1] + nums[2] == 0) {
            tempList.add(nums[0]);
            tempList.add(nums[1]);
            tempList.add(nums[2]);
        }
        return tempList;
    }
}
