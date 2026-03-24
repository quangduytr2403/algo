class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] res = new int[m][n];
        int[][] prev = new int[m][n];
        int[][] suff = new int[m][n];
        int MOD = 12345;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                prev[i][j] = (i == 0 && j == 0 ? grid[0][0] : (j == 0 ? prev[i - 1][n - 1] : prev[i][j - 1]) * (grid[i][j] % MOD)) % MOD;
            }
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                suff[i][j] = (i == m - 1 && j == n - 1 ? grid[m - 1][n - 1] : (j == n - 1 ? suff[i + 1][0] : suff[i][j + 1]) * (grid[i][j] % MOD)) % MOD;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = (i == 0 && j == 0 ? 1 : (j == 0 ? prev[i - 1][n - 1] : prev[i][j - 1])) * (i == m - 1 && j == n - 1 ? 1 : (j == n - 1 ? suff[i + 1][0] : suff[i][j + 1])) % MOD;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().constructProductMatrix(new int[][]{{1,2}, {3,4}}));
    }
}