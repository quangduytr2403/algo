class Solution {
    public int maxProductPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        long[][] max = new long[m][n];
        long[][] min = new long[m][n];

        max[0][0] = min[0][0] = grid[0][0];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;

                long val = grid[i][j];

                long maxVal = Long.MIN_VALUE;
                long minVal = Long.MAX_VALUE;

                if (i > 0) {
                    maxVal = Math.max(maxVal, Math.max(max[i-1][j] * val, min[i-1][j] * val));
                    minVal = Math.min(minVal, Math.min(max[i-1][j] * val, min[i-1][j] * val));
                }

                if (j > 0) {
                    maxVal = Math.max(maxVal, Math.max(max[i][j-1] * val, min[i][j-1] * val));
                    minVal = Math.min(minVal, Math.min(max[i][j-1] * val, min[i][j-1] * val));
                }

                max[i][j] = maxVal;
                min[i][j] = minVal;
            }
        }

        long res = max[m-1][n-1];
        if (res < 0) return -1;

        return (int)(res % 1_000_000_007);
    }
}