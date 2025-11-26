class Solution {
    public int numberOfPaths(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dp = new int [m][n][k];
        int r;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int q = 0; q < k; q++) {
                    r = q - (grid[i][j] % k);
                    if (r < 0) r += k;
                    if (i == 0 && j == 0 && r == 0) {
                        dp[i][j][q] = 1;
                        continue;
                    }
                    dp[i][j][q] = i == 0 ? 0 : dp[i - 1][j][r];
                    dp[i][j][q] += (j == 0 ? 0 : dp[i][j - 1][r]);
                    dp[i][j][q] %= 1000000007;
                }
            }
        }

        return dp[m - 1][n - 1][0];
    }
}