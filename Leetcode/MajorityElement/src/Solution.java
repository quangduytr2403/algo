import java.util.HashMap;
import java.util.Map;

class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> m = new HashMap<>();
        int res = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (m.containsKey(nums[i])) {
                m.put(nums[i], m.get(nums[i]) + 1);
            } else {
                m.put(nums[i], 1);
            }

            if (m.get(nums[i]) > nums.length / 2) {
                return nums[i];
            } else {
                if (m.get(nums[i]) > max) {
                    max = m.get(nums[i]);
                    res = nums[i];
                }
            }
        }

        return res;
    }
}