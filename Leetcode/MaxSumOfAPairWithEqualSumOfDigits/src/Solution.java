import java.util.*;

class Solution {
    public int maximumSum(int[] nums) {
        Arrays.sort(nums);
        int res = -1;
        Map<Integer, Integer> m = new HashMap<>();
        Set<Integer> s = new HashSet<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            int sum = getSumDigit(nums[i]);
            if (m.containsKey(sum)) {
                if (!s.contains(sum)) {
                    res = Math.max(res, m.get(sum) + nums[i]);
                    s.add(sum);
                }
            } else m.put(sum, nums[i]);
        }

        return res;
    }

    public int getSumDigit(int num) {
        int res = 0;
        while (num > 0) {
            res += num % 10;
            num = num / 10;
        }
        return res;
    }
}