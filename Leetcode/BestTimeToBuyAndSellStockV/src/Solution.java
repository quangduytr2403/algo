class Solution {
    public long maximumProfit(int[] prices, int k) {
        long[][] dp = new long[prices.length][k + 1];

        for (int i = 0; i < prices.length; i++) {
            for (int j = 1; j <= Math.min(k, (i + 1) /2); j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                for (int l = (j - 1) * 2; l <= i - 1; l++) {
                    dp[i][j] = Math.max(dp[i][j], (l > 0 ? dp[l - 1][j - 1] : 0) + Math.abs(prices[i] - prices[l]));
                }
            }
        }

        return dp[prices.length - 1][k];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maximumProfit(new int[]{6,11,1,5,3,15,8}, 3));
    }
}