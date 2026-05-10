class Solution {
    public int maximumJumps(int[] nums, int target) {
        int[] dp = new int[nums.length];

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (Math.abs(nums[j] - nums[i]) <= target && dp[j] != -1) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (dp[i] == 0) dp[i] = -1;
        }

        return dp[nums.length - 1];
    }
}