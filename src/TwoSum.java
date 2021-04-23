import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int[] res = new int[2];
        for(int i = 0; i < nums.length; i++) {
           hashMap.put(nums[i], i);
        }

//        System.out.println(hashMap);

        for(int i = 0; i < nums.length; i++) {
            int x = nums[i];
            int y = target - x;
            if(hashMap.containsKey(y) && i != hashMap.get(y)) {
//                System.out.println(i);
                res[0] = i;
                res[1] = hashMap.get(y);
                Arrays.sort(res);
                return res;
            }
        }
        Arrays.sort(res);
        return res;
    }
}
