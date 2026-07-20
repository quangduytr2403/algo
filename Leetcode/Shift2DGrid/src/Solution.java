import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] res = new int[m][n];
        List<List<Integer>> resl = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[((i * n + j + k) % (m * n)) / n] [((i * n + j + k) % (m * n)) % n] = grid[i][j];
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) resl.add(new ArrayList<>());
                resl.get(i).add(res[i][j]);
            }
        }

        return resl;
    }
}