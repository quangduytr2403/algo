class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[] one = new int[strs.length];
        int[] zero = new int[strs.length];

        for (int i = 0; i < strs.length; i++) {
            int countOne = 0;
            int countZero = 0;
            for (char c: strs[i].toCharArray()) {
                if (c == '0') countZero++;
                else countOne++;
            }
            one[i] = countOne;
            zero[i] = countZero;
        }

        int[][][] dp = new int[strs.length][m + 1][n + 1];
        int res = 0;

        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    dp[i][j][k] = i > 0 ? dp[i -1][j][k] : 0;
                    if (j >= zero[i] && k >= one[i]) {
                        dp[i][j][k] = Math.max(dp[i][j][k], (i > 0 ? dp[i - 1][j - zero[i]][k - one[i]] : 0) + 1);
                    }

                    res = Math.max(res, dp[i][j][k]);
                }
            }
        }

        return res;
    }
}