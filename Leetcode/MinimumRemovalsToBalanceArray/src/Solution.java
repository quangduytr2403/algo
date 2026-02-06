import java.util.Arrays;

class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0, j = 0, res = Integer.MAX_VALUE;
        while (i < nums.length) {
            while (j < nums.length && ((long) nums[i] * k) >= nums[j]) j++;
            res = Math.min(res, nums.length - (j - i));
            i++;
        }

        return res;
    }
}