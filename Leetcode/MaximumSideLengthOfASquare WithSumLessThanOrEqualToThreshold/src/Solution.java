class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] sumCorner = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) sumCorner[i][j] = mat[i][j];
                else if (i == 0) {
                    sumCorner[i][j] = sumCorner[i][j - 1] + mat[i][j];
                } else if (j == 0) {
                    sumCorner[i][j] = sumCorner[i - 1][j] + mat[i][j];
                } else {
                    sumCorner[i][j] = sumCorner[i - 1][j] + sumCorner[i][j - 1] - sumCorner[i - 1][j - 1] + mat[i][j];
                }
            }
        }

        for (int k = Math.min(n, m); k >= 1; k--) {
            for (int i = 0; i <= n - k; i++) {
                for (int j = 0; j <= m - k; j++) {
                    if (sumCorner[i + k - 1][j + k - 1] - (i > 0 ? sumCorner[i - 1][j + k - 1] : 0) - (j > 0 ? sumCorner[i + k - 1][j  - 1] : 0) + (i > 0 && j > 0 ? sumCorner[i - 1][j - 1] : 0) <= threshold) return k;
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {2,2,2,2,2},
            {2,2,2,2,2},
            {2,2,2,2,2},
            {2,2,2,2,2},
            {2,2,2,2,2}
        };
        System.out.println(new Solution().maxSideLength(matrix, 1));
    }
}