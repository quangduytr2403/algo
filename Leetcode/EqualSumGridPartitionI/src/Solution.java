import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        long[][] dp = new long[m][n];
        Set<Long> s = new HashSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = (i > 0 ? dp[i - 1][j] : 0) + (j > 0 ? dp[i][j - 1] : 0) - (i > 0 && j > 0 ? dp[i - 1][j - 1] : 0) + grid[i][j];
                if (i == m - 1 || j == n - 1) s.add(dp[i][j]);
            }
        }

        return dp[m - 1][n - 1] % 2 == 0 && s.contains(dp[m - 1][n - 1] / 2);
    }
}