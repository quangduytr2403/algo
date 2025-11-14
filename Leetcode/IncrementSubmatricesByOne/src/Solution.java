class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] g = new int[n][n];

        for (int[] q : queries) {
            for (int i = q[0]; i <= q[2]; i++) g[i][q[1]]++;
            for (int i = q[0]; i <= q[2]; i++) if(q[3] < n - 1) g[i][q[3] + 1]--;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                g[i][j] = (j > 0 ? g[i][j - 1] : 0) + g[i][j];
            }
        }

        return g;
    }
}