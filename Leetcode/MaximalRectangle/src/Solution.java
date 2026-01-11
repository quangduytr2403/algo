class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] maxCol = new int[n][m];
        int[][] maxRow = new int[n][m];
        int[][] dp = new int[n][m];
        int res = 0;
        int minHeight;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1') {
                    if (j > 0) maxRow[i][j] = maxRow[i][j - 1];
                    maxRow[i][j]++;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[j][i] == '1') {
                    if (j > 0) maxCol[j][i] = maxCol[j - 1][i];
                    maxCol[j][i]++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1') {
                    minHeight = Integer.MAX_VALUE;
                    for (int k = 0; k < maxRow[i][j]; k++) {
                        minHeight = Math.min(minHeight, maxCol[i][j - k]);
                        dp[i][j] = Math.max(dp[i][j], (k + 1) * minHeight);
                    }
                }

                res = Math.max(res, dp[i][j]);
            }
        }

        return res;
    }
}