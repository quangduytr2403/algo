class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] sum = new int[m][n];
        int res = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) sum[i][j] = 1;
                sum[i][j] += i > 0 ? sum[i - 1][j] : 0;
                sum[i][j] += j > 0 ? sum[i][j - 1] : 0;
                sum[i][j] -= (i > 0 && j > 0) ? sum[i - 1][j - 1] : 0;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int size = 0;
                while (i + size < m && j + size < n) {
                    int sumSquare = sum[i + size][j + size];
                    sumSquare -= i > 0 ? sum[i - 1][j + size] : 0;
                    sumSquare -= j > 0 ? sum[i + size][j - 1] : 0;
                    sumSquare += (i > 0 && j > 0) ? sum[i - 1][j - 1] : 0;
                    if (sumSquare == (size + 1) * (size + 1)) res++;

                    size++;
                }
            }
        }

        return res;
    }
}