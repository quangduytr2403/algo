import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isGood(int[] nums) {
        int n = nums.length - 1;
        int countn = 0;
        Set<Integer> s = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (s.contains(nums[i]) && (nums[i] != n || countn == 2)) return false;
            if (nums[i] > n) return false;
            if (nums[i] == n) countn++;
            s.add(nums[i]);
        }

        return true;
    }
}