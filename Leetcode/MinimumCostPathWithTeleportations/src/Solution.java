class Solution {
    public int minCost(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dp = new int[m][n][k + 1];
        int[][][] min = new int[10002][k + 1][3];


        for (int l = 0; l <= k; l++) {
            for (int i = 0; i <= 10001; i++) min[i][l][0] = Integer.MAX_VALUE;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == 0 && j == 0) dp[i][j][l] = grid[i][j];
                    else if (i == 0) dp[i][j][l] = dp[i][j - 1][l] + grid[i][j];
                    else if (j == 0) dp[i][j][l] = dp[i - 1][j][l] + grid[i][j];
                    else dp[i][j][l] = Math.min(dp[i - 1][j][l], dp[i][j - 1][l]) + grid[i][j];

                    if (l > 0 && min[grid[i][j]][l - 1][0] != Integer.MAX_VALUE) {
                        int o = min[grid[i][j]][l - 1][1];
                        int p = min[grid[i][j]][l - 1][2];
                        dp[i][j][l] = Math.min(dp[i][j][l], dp[o][p][l - 1]);
                    }

                    if (dp[i][j][l] < min[grid[i][j]][l][0]) {
                        min[grid[i][j]][l] = new int[]{dp[i][j][l], i, j};
                    }
                }
            }
            for (int i = 10000; i >= 0; i--) {
                if (min[i][l][0] == Integer.MAX_VALUE || min[i][l][0] >= min[i + 1][l][0]) {
                    min[i][l] = new int[]{min[i + 1][l][0], min[i + 1][l][1], min[i + 1][l][2]};
                }
            }
            for (int i = 0; i <= 10; i++) System.out.print(min[i][l][0] + " ");
            System.out.println();
        }

        return dp[m - 1][n - 1][k] - grid[0][0];
    }
}