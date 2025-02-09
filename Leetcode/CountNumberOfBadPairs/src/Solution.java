import java.util.HashMap;
import java.util.Map;

class Solution {
    public long countBadPairs(int[] nums) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            nums[i] -= i;
            m.put(nums[i], m.getOrDefault(nums[i], 0) + 1);
        }

        long good = 0;
        for (var v : m.values()) good += ((long) v * (v - 1)) / 2;

        return (((long) nums.length * (nums.length - 1)) / 2) - good;
    }
}