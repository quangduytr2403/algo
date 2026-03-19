class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][] d = new int[m][n][3];
        int res = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 3; k++) {
                    d[i][j][k] = (i > 0 ? d[i - 1][j][k] : 0) + (j > 0 ? d[i][j - 1][k] : 0) - (i > 0 && j > 0 ? d[i - 1][j - 1][k] : 0);
                }
                if (grid[i][j] == '.') d[i][j][0]++;
                else if (grid[i][j] == 'X') d[i][j][1]++;
                else d[i][j][2]++;

                if (d[i][j][1] > 0 && d[i][j][1] == d[i][j][2]) res++;
            }
        }

        return res;
    }
}