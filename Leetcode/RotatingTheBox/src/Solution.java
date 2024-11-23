import java.util.Arrays;

class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;

        char[][] res = new char [n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(res[i], '.');
        };

        for (int i = 0; i < m; i++) {
            int curI = n - 1;
            int curJ = m - 1 - i;
            for (int j = n - 1; j >= 0; j--) {
                if (box[i][j] == '*') {
                    res[j][m - 1 -i] = '*';
                    curI = j - 1;
                } else if (box[i][j] == '#') {
                    res[curI][curJ] = '#';
                    curI--;
                }
            }
        }

        return res;
    }
}