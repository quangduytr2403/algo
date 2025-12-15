class Solution {
    public long getDescentPeriods(int[] prices) {
        int[] dp = new int[prices.length];
        long res = 0;

        for (int i = 0 ; i < prices.length; i++) {
            dp[i] = 1 + (i > 0 && prices[i] == prices[i - 1] - 1 ? dp[i - 1] : 0);
            res += dp[i];
        }

        return res;
    }
}