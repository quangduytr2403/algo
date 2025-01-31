class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = Integer.MIN_VALUE;
            for (int  j = 0; j <= i; j++) {
                if (prices[j] <= prices[i]) dp[i] = Math.max(dp[i], (j == 0 ? 0 : dp[j - 1]) + prices[i] - prices[j]);
            }
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[]{1,2,3,4,5}));
    }
}