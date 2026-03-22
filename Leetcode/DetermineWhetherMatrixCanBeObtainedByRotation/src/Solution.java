class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length, tmp;
        String targetString = "";
        String matString;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) targetString += target[i][j];
        }

        for (int t = 3; t >= 0; t--) {
            // transpose
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    tmp = mat[i][j];
                    mat[i][j] = mat[j][i];
                    mat[j][i] = tmp;
                }
            }

            // reverse each row
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n / 2; j++) {
                    tmp = mat[i][j];
                    mat[i][j] = mat[i][n - 1 - j];
                    mat[i][n - 1 - j] = tmp;
                }
            }
            matString = "";
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) matString += mat[i][j];
            }

            if (matString.equals(targetString)) return true;
        }
        return false;
    }
}