class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int[][] sum = new int[grid.length][grid[0].length];
        int res = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0;j < grid[0].length; j++) {
                sum[i][j] = (i > 0 ? sum[i - 1][j] : 0) + (j > 0 ? sum[i][j - 1] : 0) - (i > 0 && j > 0 ? sum[i - 1][j - 1] : 0) + grid[i][j];
                if (sum[i][j] <= k) res++;
            }
        }

        return res;
    }
}