import java.util.Arrays;

class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        int max = 0;
        for (int i = 2; i < nums.length; i++) {
            max = Math.max(max, nums[i - 1] + nums[i - 2]);
            if (max > nums[i]) res = Math.max(res, max + nums[i]);
        }
        return res;
    }
}