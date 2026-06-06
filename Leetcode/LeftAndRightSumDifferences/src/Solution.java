class Solution {
    public int[] leftRightDifference(int[] nums) {
        int[] ans = new int[nums.length];
        int sum = 0, curr = 0;
        for (int n : nums) sum += n;

        for (int i = 0; i < nums.length; i++) {
            ans[i] = Math.abs(curr - (sum - curr - nums[i]));
            curr += nums[i];
        }

        return ans;
    }
}