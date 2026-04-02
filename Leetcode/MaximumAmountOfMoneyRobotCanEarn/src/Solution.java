class Solution {
    public int maximumAmount(int[][] coins) {
        int m = coins.length;
        int n = coins[0].length;
        int[][][] dp = new int[m][n][3];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k <= 2; k++) {
                    if (i == 0 && j == 0) {
                        dp[i][j][k] = coins[i][j] < 0 && k > 0 ? 0 : coins[i][j];
                        continue;
                    }

                    if (i == 0) {
                        dp[i][j][k] = dp[i][j - 1][k] + coins[i][j];
                        if (coins[i][j] < 0 && k > 0) dp[i][j][k] = Math.max(dp[i][j][k], dp[i][j - 1][k - 1]);
                    } else if (j == 0) {
                        dp[i][j][k] = dp[i - 1][j][k] + coins[i][j];
                        if (coins[i][j] < 0 && k > 0) dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j][k - 1]);
                    } else {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i][j - 1][k]) + coins[i][j];
                        if (coins[i][j] < 0 && k > 0) dp[i][j][k] = Math.max(dp[i][j][k], Math.max(dp[i][j - 1][k - 1], dp[i -1][j][k -1]));
                    }
                }
            }
        }

        return dp[m - 1][n - 1][2];
    }
}