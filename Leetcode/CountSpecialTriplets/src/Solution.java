class Solution {
    public int specialTriplets(int[] nums) {
        int MOD = 1000_000_007;
        int n = nums.length;

        int[] count = new int[100001];
        int[] count2 = new int[100001];
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = ((i > 0 ? dp[i - 1] : 0) + (nums[i] % 2 == 0 ? count2[nums[i] / 2] : 0)) % MOD;
            count2[nums[i]] = (count2[nums[i]] + (nums[i] * 2 <= 100000 ? count[nums[i] * 2] : 0)) % MOD;
            count[nums[i]]++;
        }

        return dp[n - 1];
    }
}