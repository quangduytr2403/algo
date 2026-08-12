import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int res = Integer.MIN_VALUE;
        Map<Integer, Integer> m = new HashMap<>();
        int l = 0, r = -1, t;

        while (r < nums.length - 1) {
            r++;
            m.put(nums[r], m.getOrDefault(nums[r], 0) + 1);
            if (m.get(nums[r]) > k) {
                while (l < r) {
                    m.put(nums[l], m.get(nums[l]) - 1);
                    t = l;
                    l++;
                    if (nums[t] == nums[r]) break;
                }
            }

            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}