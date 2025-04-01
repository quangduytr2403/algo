class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long res = -1;

        long[] dp = new long[n];
        long[] max = new long[n];

        for (int i = n - 1; i >= 0; i--) {
            dp[i] = questions[i][0] + ((i + questions[i][1] + 1) < n ? max[i + questions[i][1] + 1] : 0);
            max[i] = Math.max(dp[i], i+ 1 < n ? max[i + 1] : 0);
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}