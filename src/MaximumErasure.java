import java.util.ArrayList;

public class MaximumErasure {
    public static int maximumUniqueSubarray(int[] nums) {

        int l = nums.length;
        if (l == 1)
            return nums[0];
        int ans = nums[0], cur = ans, s = 0;
        boolean x[] = new boolean[10001];
        x[nums[0]] = true;
        for (int e = 1; e < l; e++) {
            while (x[nums[e]]) {
                cur -= nums[s];
                x[nums[s++]] = false;
            }
            cur += nums[e];
            x[nums[e]] = true;
            if (ans < cur)
                ans = cur;
        }
        return ans;

    }
}
