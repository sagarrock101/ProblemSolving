import java.util.*;

public class TwoSum {
    public int[] twoSum(int[] nums, long target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        int[] sol = new int[2];
        //1, 2, 3, 4, 5
        //0, 1, 2, 3, 4
        for(int i = 0; i < nums.length; i++) {
            int diff = (int) (target - nums[i]);
            if(hashMap.containsKey(diff)) {
                sol[0] = hashMap.get(diff);
                sol[1] = i;
                return sol;
            } else {
                hashMap.put(nums[i], i);
            }
        }

        return sol;
    }
}
