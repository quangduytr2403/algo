class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int sum = 0;
        int res = 0;
        int max = 0;
        int min = 0;

        for (int  i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > max) max = sum;
            if (sum < min) min = sum;
        }

        return Math.max(res, Math.abs(max - min));
    }
}