class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int res = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') dp[i][j] = 0;
                else {
                    int prev = i > 0 && j > 0 ? dp[i - 1][j -1] : 0;
                    dp[i][j] = prev + 1;
                    for (int k = 1; k <= prev; k++) {
                        if (matrix[i][j - k] != '1' || matrix[i - k][j] != '1') {
                            dp[i][j] = k;
                            break;
                        }
                    }
                }
                res = Math.max(res, dp[i][j]);
            }
        }

        return res * res;
    }
}