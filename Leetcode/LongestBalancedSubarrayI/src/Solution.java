import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int longestBalanced(int[] nums) {
        Set<Integer> s1;
        Set<Integer> s2;
        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            s1 = new HashSet<>();
            s2 = new HashSet<>();
            for (int j = i; j < nums.length; j++) {
                if (nums[j] % 2 == 0) s1.add(nums[j]);
                else s2.add(nums[j]);

                if (s1.size() == s2.size()) res = Math.max(res, j - i + 1);
            }
        }

        return res;
    }
}